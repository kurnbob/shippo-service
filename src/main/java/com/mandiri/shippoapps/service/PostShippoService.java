package com.mandiri.shippoapps.service;

import com.mandiri.shippoapps.model.entity.Shippo;
import com.mandiri.shippoapps.model.request.CreateShippoRequest;
import com.mandiri.shippoapps.repository.ShippoRepository;
import com.mandiri.shippoapps.utils.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostShippoService {
    private final ShippoRepository shippoRepository;

    public Shippo execute(CreateShippoRequest shippo){
        Shippo newShippo = Shippo.builder()
                .name(shippo.getName())
                .address(shippo.getAddress())
                .phone(shippo.getPhone())
                .permitNumber(shippo.getPermitNumber())
                .taxNumber(shippo.getTaxNumber())
                .build();
        return shippoRepository.save(newShippo);
    }
}
