package com.mandiri.shippoapps.service;

import com.mandiri.shippoapps.model.entity.Shippo;
import com.mandiri.shippoapps.repository.ShippoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShippoServiceCreate {
    private final ShippoRepository shippoRepository;
    public void createNew(Shippo shippo){
        shippoRepository.save(shippo);
    }
}
