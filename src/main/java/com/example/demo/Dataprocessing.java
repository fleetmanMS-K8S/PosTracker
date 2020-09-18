package com.example.demo;

import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

@Repository
public class Dataprocessing {

    //Map<String, Queue<Position>>positionqueues;

    //Queue<Position> positions = new PriorityQueue<Position>();
    HashMap<String, Queue<Position>> hash_map = new HashMap<String, Queue<Position>>();

    //Queue<Position> cusqueue = new PriorityQueue<Position>();
    Queue<Position> cusqueue  = new LinkedList<>();


    public void updateposition(String message){

        JSONObject obj = new JSONObject(message);
        String vehiclename = obj.get("vehicle").toString();

        System.out.print("Checking exec");
        Queue<Position> temqueue = hash_map.get(vehiclename);

        if (temqueue == null)
        {
                temqueue  = new LinkedList<>();
                hash_map.put(vehiclename,temqueue);
        }



        Position pos = new Position(new BigDecimal(obj.get("lat").toString()),new BigDecimal(obj.get("long").toString()));
        temqueue.add(pos);
        System.out.println("The size of the queue is "  + temqueue.size());


    }

    public Position getlatestpos(String vehiclename) throws Exception {
        Queue<Position> queue = hash_map.get(vehiclename);
        if(queue == null){
            throw new Exception("Problem with latest pos update as the queue is null");
        }
        System.out.println("The size of the queue is "  + queue.size());
        return queue.remove();

    }

    public String getvehiclename(){

        for ( String vehicle : this.hash_map.keySet() ) {
          //  System.out.println( key );
            return vehicle;
        }

        return "";

    }

}
