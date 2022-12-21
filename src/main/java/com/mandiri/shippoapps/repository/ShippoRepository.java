package com.mandiri.shippoapps.repository;

import com.mandiri.shippoapps.model.entity.Shippo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface ShippoRepository extends JpaRepository<Shippo, String> {
}
