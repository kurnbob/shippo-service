package com.mandiri.shippoapps.controller;
import com.mandiri.shippoapps.model.entity.Shippo;
import com.mandiri.shippoapps.model.request.CreateShippoRequest;
import com.mandiri.shippoapps.model.response.Response;
import com.mandiri.shippoapps.service.PostShippoService;
import com.mandiri.shippoapps.service.DeleteShippoService;
import com.mandiri.shippoapps.service.GetShippoService;
import com.mandiri.shippoapps.service.UpdateShippoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/store/v1/shippo-store")
public class ShippoController {

    private final GetShippoService getShippoService;
    private final PostShippoService postShippoService;
    private final UpdateShippoService updateShippoService;
    private final DeleteShippoService deleteShippoService;

    //Create a new store
    @PostMapping("/store")
    public ResponseEntity<Response<Shippo>> registerStore(@RequestBody CreateShippoRequest shippo){
        Response<Shippo> response = new Response<Shippo>();
        response.setData(postShippoService.execute(CreateShippoRequest.builder()
                .name(shippo.getName())
                .address(shippo.getAddress())
                .phone(shippo.getPhone())
                .permitNumber(shippo.getPermitNumber())
                .taxNumber(shippo.getTaxNumber())
                .build()));
        response.setMessage("New Store Successfully Added");

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    //Showing All stores
    @GetMapping("/stores")
    public List<Shippo> getAllStore(){
        return getShippoService.getAllStore();
    }

    //Get Store By Id
    @GetMapping("/store")
    public Shippo getStoreById(@RequestParam String id){
        return getShippoService.getStoreById(id);
    }

    @DeleteMapping("/store")
    public void removeStoreById(@RequestParam String id){
        deleteShippoService.deleteStoreById(id);
    }

    @PutMapping("/store/{id}")
    public void updateStore(@PathVariable String id, @RequestBody Shippo shippo){
        updateShippoService.updateStore(id, shippo);
    }

}
