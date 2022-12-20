package com.mandiri.shippoapps.service;

import com.mandiri.shippoapps.common.Message;
import com.mandiri.shippoapps.model.entity.Shippo;
import com.mandiri.shippoapps.repository.ShippoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ShippoServiceUpdate {
    private final ShippoRepository shippoRepository;

    public void updateStore(String id, Shippo shippo){
        Shippo updateStore = shippoRepository.findById(id).get();
        if(!shippoRepository.findById(id).isPresent()){
            String message = Message.generateNotFoundMessage(Shippo.class.getSimpleName(), id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }

        updateStore.setName(shippo.getName());
        updateStore.setAddress(shippo.getAddress());
        updateStore.setPhone(shippo.getPhone());
        updateStore.setPermitNumber(shippo.getPermitNumber());
        updateStore.setTaxNumber(shippo.getTaxNumber());

        shippoRepository.save(updateStore);
    }
}
