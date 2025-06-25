package org.example.vehicleservice.repo;

import org.example.vehicleservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE vehicle SET exit_time = NOW() WHERE id = :id", nativeQuery = true)    void updateExitTime(Long id);
}

