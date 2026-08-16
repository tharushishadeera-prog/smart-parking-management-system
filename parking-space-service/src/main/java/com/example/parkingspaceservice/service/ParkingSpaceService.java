package com.example.parkingspaceservice.service;

import com.example.parkingspaceservice.entity.ParkingSpace;
import com.example.parkingspaceservice.repository.ParkingSpaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpaceService {

    private final ParkingSpaceRepository parkingSpaceRepository;

    public ParkingSpaceService(ParkingSpaceRepository parkingSpaceRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
    }

    public ParkingSpace createParkingSpace(ParkingSpace parkingSpace) {
        return parkingSpaceRepository.save(parkingSpace);
    }

    public List<ParkingSpace> getAllParkingSpaces() {
        return parkingSpaceRepository.findAll();
    }

    public ParkingSpace getParkingSpaceById(Long id) {
        return parkingSpaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parking space not found"));
    }

    public ParkingSpace updateParkingSpace(Long id, ParkingSpace parkingSpace) {

        ParkingSpace existing = getParkingSpaceById(id);

        existing.setSpaceNumber(parkingSpace.getSpaceNumber());
        existing.setLocation(parkingSpace.getLocation());
        existing.setStatus(parkingSpace.getStatus());
        existing.setPricePerHour(parkingSpace.getPricePerHour());

        return parkingSpaceRepository.save(existing);
    }

    public void deleteParkingSpace(Long id) {
        parkingSpaceRepository.deleteById(id);
    }

    public List<ParkingSpace> getByStatus(String status) {
        return parkingSpaceRepository.findByStatus(status);
    }

    public List<ParkingSpace> getByLocation(String location) {
        return parkingSpaceRepository.findByLocation(location);
    }
}