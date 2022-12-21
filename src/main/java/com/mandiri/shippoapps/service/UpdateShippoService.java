package com.mandiri.shippoapps.service;

import com.mandiri.shippoapps.common.Message;
import com.mandiri.shippoapps.model.entity.Shippo;
import com.mandiri.shippoapps.repository.ShippoRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
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

        var name = StringUtils.defaultIfBlank(shippo.getName(), updateStore.getName());
        var address = StringUtils.defaultIfBlank(shippo.getAddress(), updateStore.getAddress());
        var phone = StringUtils.defaultIfBlank(shippo.getPhone(), updateStore.getPhone());
        var permitNumber = StringUtils.defaultIfBlank(shippo.getPermitNumber(), updateStore.getPermitNumber());
        var taxNumber = StringUtils.defaultIfBlank(shippo.getTaxNumber(), updateStore.getTaxNumber());

        System.out.println(name);
        System.out.println(address);
        System.out.println(phone);
        System.out.println(permitNumber);
        System.out.println(taxNumber);

        shippoRepository.save(updateStore);
    }
}
