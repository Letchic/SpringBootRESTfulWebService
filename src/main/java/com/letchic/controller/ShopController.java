package com.letchic.controller;

import com.letchic.model.Shop;
import com.letchic.service.ShopService;
import com.letchic.views.ShopTitleView;
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

    @GetMapping("/getStoreNameByDistrict")
    public ResponseEntity<List<ShopTitleView>> getStoreNameByDistrict(@RequestParam String firstDistrict,
                                                                      String secondDistrict) {
        List<ShopTitleView> result = storeService.getStoreNameByDistrict(firstDistrict, secondDistrict);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}