package com.mandiri.shippoapps.service;

import com.mandiri.shippoapps.repository.ShippoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteShippoService {
    private final ShippoRepository shippoRepository;
    public void deleteStoreById(String id){
        shippoRepository.deleteById(id);
    }
}
