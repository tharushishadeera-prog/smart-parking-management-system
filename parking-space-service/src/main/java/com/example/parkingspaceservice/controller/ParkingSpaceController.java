package com.example.parkingspaceservice.controller;

import com.example.parkingspaceservice.entity.ParkingSpace;
import com.example.parkingspaceservice.service.ParkingSpaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking-spaces")
public class ParkingSpaceController {

    private final ParkingSpaceService parkingSpaceService;

    public ParkingSpaceController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    @PostMapping
    public ResponseEntity<ParkingSpace> createParkingSpace(
            @RequestBody ParkingSpace parkingSpace) {

        return ResponseEntity.ok(
                parkingSpaceService.createParkingSpace(parkingSpace)
        );
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpace>> getAllParkingSpaces() {

        return ResponseEntity.ok(
                parkingSpaceService.getAllParkingSpaces()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpace> getParkingSpaceById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                parkingSpaceService.getParkingSpaceById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpace> updateParkingSpace(
            @PathVariable Long id,
            @RequestBody ParkingSpace parkingSpace) {

        return ResponseEntity.ok(
                parkingSpaceService.updateParkingSpace(id, parkingSpace)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteParkingSpace(
            @PathVariable Long id) {

        parkingSpaceService.deleteParkingSpace(id);

        return ResponseEntity.ok("Parking space deleted successfully");
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ParkingSpace>> getByStatus(
            @PathVariable String status) {

        return ResponseEntity.ok(
                parkingSpaceService.getByStatus(status)
        );
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<ParkingSpace>> getByLocation(
            @PathVariable String location) {

        return ResponseEntity.ok(
                parkingSpaceService.getByLocation(location)
        );
    }
}