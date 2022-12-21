package com.mandiri.shippoapps.service;

import com.mandiri.shippoapps.common.Message;
import com.mandiri.shippoapps.model.entity.Shippo;
import com.mandiri.shippoapps.repository.ShippoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UpdateShippoService {
    private final ShippoRepository shippoRepository;

    public void updateStore(String id, Shippo shippo){
        Shippo updateStore = shippoRepository.findById(id).get();
        if(!shippoRepository.findById(id).isPresent()){
            String message = Message.generateNotFoundMessage(Shippo.class.getSimpleName(), id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }

        if (StringUtils.isBlank(updateStore.getName())){
            updateStore.setName(shippo.getName());
        }
        if (StringUtils.isBlank(updateStore.getAddress())) {
            updateStore.setAddress(shippo.getAddress());
        }
        if (StringUtils.isBlank(updateStore.getPhone())){
            updateStore.setPhone(shippo.getPhone());
        }
        if (StringUtils.isBlank(updateStore.getPermitNumber())){
            updateStore.setPermitNumber(shippo.getPermitNumber());
        }
        if (StringUtils.isBlank(updateStore.getTaxNumber())){
            updateStore.setTaxNumber(shippo.getTaxNumber());
        }

        shippoRepository.save(updateStore);
    }
}
