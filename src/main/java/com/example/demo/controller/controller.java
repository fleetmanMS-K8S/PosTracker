package com.example.demo.controller;


import com.example.demo.Dataprocessing;
import com.example.demo.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@CrossOrigin("*")
@RequestMapping("/position")
public class controller {


	@Autowired
	private Dataprocessing dataservice;

	
	@GetMapping("/{message}")
	public ResponseEntity<String> publish(@PathVariable("message") String message) {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body("HELLO BODY");
		}
		
		//Define Custom exception later
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
	}


	@GetMapping("/fetch/{message}")
	public ResponseEntity<Position> getlatestpos(@PathVariable("message") String message) {

		try {
			Position pos = dataservice.getlatestpos(message);
			return ResponseEntity.status(HttpStatus.OK).body(pos);
		}

		//Define Custom exception later
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

	}

	@GetMapping("/fetch/vehicle")
	public ResponseEntity<String> getvehiclename(){
		  String vehicle = dataservice.getvehiclename();
          return ResponseEntity.status(HttpStatus.OK).body(vehicle);
	}



}
