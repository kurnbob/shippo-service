package com.mandiri.shippoapps.service;
import com.mandiri.shippoapps.common.Message;
import com.mandiri.shippoapps.model.entity.Shippo;
import com.mandiri.shippoapps.repository.ShippoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippoServiceFind {
    private final ShippoRepository shippoRepository;
    public List<Shippo> getAllStore(){
        return shippoRepository.findAll();
    }

    public Shippo getStoreById(String id){
        if(!shippoRepository.findById(id).isPresent()){
            String message = Message.generateNotFoundMessage(Shippo.class.getSimpleName(), id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
        return shippoRepository.findById(id).get();
    }

}
