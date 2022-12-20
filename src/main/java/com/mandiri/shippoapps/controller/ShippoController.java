package com.mandiri.shippoapps.controller;
import com.mandiri.shippoapps.model.entity.Shippo;
import com.mandiri.shippoapps.service.ShippoServiceCreate;
import com.mandiri.shippoapps.service.ShippoServiceDelete;
import com.mandiri.shippoapps.service.ShippoServiceFind;
import com.mandiri.shippoapps.service.ShippoServiceUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/store/v1/shippo-store")
public class ShippoController {

    private final ShippoServiceFind shippoServiceFind;
    private final ShippoServiceCreate shippoServiceCreate;
    private final ShippoServiceUpdate shippoServiceUpdate;
    private final ShippoServiceDelete shippoServiceDelete;

    //Create a new store
    @PostMapping("/store")
    public void registerStore(@RequestBody Shippo shippo){
        shippoServiceCreate.createNew(shippo);
    }

    //Showing All stores
    @GetMapping("/stores")
    public List<Shippo> getAllStore(){
        return shippoServiceFind.getAllStore();
    }

    //Get Store By Id
    @GetMapping("/store")
    public Shippo getStoreById(@RequestParam String id){
        return shippoServiceFind.getStoreById(id);
    }

    @DeleteMapping("/store")
    public void removeStoreById(@RequestParam String id){
        shippoServiceDelete.deleteStoreById(id);
    }

    @PutMapping("/store/{id}")
    public void updateStore(@PathVariable String id, @RequestBody Shippo shippo){
        shippoServiceUpdate.updateStore(id, shippo);
    }

}
