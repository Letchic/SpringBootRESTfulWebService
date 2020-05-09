package com.letchic.controller;

import com.letchic.model.Shop;
import com.letchic.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/store")
public class ShopController extends CommonController<Shop, ShopService> {

    @Autowired
    ShopService storeService;

    @GetMapping("/getStoreTitleByNeighborhood")
    public ResponseEntity<List<String>> getStoreNameByDistrict(@RequestParam String firstDistrict,
                                                                    String secondDistrict) {
        List<String> result = storeService.getStoreNameByDistrict(firstDistrict, secondDistrict);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public Class<Shop> getEType() {
        return Shop.class;
    }
}