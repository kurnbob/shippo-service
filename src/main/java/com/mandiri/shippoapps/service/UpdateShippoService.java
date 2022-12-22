package com.mandiri.shippoapps.service;

import com.mandiri.shippoapps.common.Message;
import com.mandiri.shippoapps.model.entity.Shippo;
import com.mandiri.shippoapps.model.request.UpdateShippoRequest;
import com.mandiri.shippoapps.repository.ShippoRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateShippoService {
    private final ShippoRepository shippoRepository;

    public Shippo execute(UpdateShippoRequest shippo){
        Optional<Shippo> shippoOpt = shippoRepository.findById(shippo.getId());

        if(!shippoOpt.isPresent()){
            String message = Message.generateNotFoundMessage(Shippo.class.getSimpleName(), shippo.getId());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }

        Shippo newShippo = shippoOpt.get();

        var name = StringUtils.defaultIfBlank(shippo.getName(), newShippo.getName());
        var address = StringUtils.defaultIfBlank(shippo.getAddress(), newShippo.getAddress());
        var phone = StringUtils.defaultIfBlank(shippo.getPhone(), newShippo.getPhone());
        var permitNumber = StringUtils.defaultIfBlank(shippo.getPermitNumber(), newShippo.getPermitNumber());
        var taxNumber = StringUtils.defaultIfBlank(shippo.getTaxNumber(), newShippo.getTaxNumber());

        var updateStore = Shippo.builder()
                .id(newShippo.getId())
                .name(name)
                .address(address)
                .phone(phone)
                .permitNumber(permitNumber)
                .taxNumber(taxNumber)
                .build();

        return shippoRepository.save(updateStore);
}
}
