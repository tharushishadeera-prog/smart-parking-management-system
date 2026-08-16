package com.example.parkingspaceservice.repository;

import com.example.parkingspaceservice.entity.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {

    List<ParkingSpace> findByStatus(String status);

    List<ParkingSpace> findByLocation(String location);
}