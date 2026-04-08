package com.pranav.laptop.controllers;

import com.pranav.laptop.dto.LaptopRequest;
import com.pranav.laptop.dto.LaptopResponse;
import com.pranav.laptop.entities.Laptop;
import com.pranav.laptop.repositories.LaptopRepository;
import com.pranav.laptop.services.LaptopService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/laptop")
public class Controller {
    private final LaptopService laptopService;

    @PostMapping("addLaptop")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LaptopResponse> addLaptop(@RequestBody LaptopRequest laptopRequest) {
        LaptopResponse laptopResponse=laptopService.addLaptop(laptopRequest);

        return  ResponseEntity.ok(laptopResponse);
    }

    @GetMapping("getLaptop/{laptopId}")
    public ResponseEntity<LaptopResponse> getLaptop(@PathVariable Integer laptopId) {
        LaptopResponse laptopResponse = laptopService.getLaptopById(laptopId);
        return ResponseEntity.ok(laptopResponse);
    }

    @PutMapping("updateLaptop/{laptopId}")
    public ResponseEntity<LaptopResponse> updateLaptop(@PathVariable Integer laptopId, @PathVariable LaptopRequest laptopRequest){
        LaptopResponse laptopResponse = laptopService.updateLaptop(laptopId,laptopRequest);
        return ResponseEntity.ok(laptopResponse);
    }





    @DeleteMapping("deleteLaptop/{laptopId}")
    public ResponseEntity<String> deleteLaptop(@PathVariable Integer laptopId) {
        laptopService.deleteLaptopById(laptopId);
        return  ResponseEntity.ok("laptop is deleted");
    }

}
