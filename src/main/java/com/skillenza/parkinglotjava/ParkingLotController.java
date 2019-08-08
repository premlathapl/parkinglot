package com.skillenza.parkinglotjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Random;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class ParkingLotController {

	@Autowired
	ParkingLotRepository parkingLotRepository;
	
    @GetMapping("/parkings")
    public List<ParkingLot> index(){
        return parkingLotRepository.findAll();
    }
    @PostMapping("/parkings")
    public ParkingLot create(@RequestBody String vehiclenum){
    	ParkingLot pl = new ParkingLot();
    	java.util.Date dt = new java.util.Date();

    	java.text.SimpleDateFormat sdf = 
    	     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    	String currentTime = sdf.format(dt);
    	int v = Integer.parseInt(vehiclenum);
    	pl.setCreated_at(currentTime);
    	Random r = new Random();
    	pl.setLot(r.nextInt(1000000000));
//    	pl.setVehicle_number(r.nextInt(1000000000));
    	pl.setVehicle_number(v);
    	pl.setParking_duration(60);
    	pl.setParking_amount(20);
    	pl.setUpdated_at(currentTime);
        return parkingLotRepository.save(pl);
    }    
}

