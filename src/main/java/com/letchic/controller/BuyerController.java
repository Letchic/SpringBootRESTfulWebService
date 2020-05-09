package com.letchic.controller;

import com.letchic.model.Buyer;
import com.letchic.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/customer")
public class BuyerController extends CommonController<Buyer, BuyerService> {

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/neigborhood")
    public List<String> getBuyerDistrict() {
        return buyerService.getBuyerDistrict();
    }

    @GetMapping("/getSecNameAndPriceByNeighborhood")
    public ResponseEntity<Map<String, Double>> getCBuyerLLastNameAndPriceByDistrict(@RequestParam String district) {
        Map<String, Double> result = buyerService.getCBuyerLLastNameAndPriceByDistrict(district);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public Class<Buyer> getEType() {
        return Buyer.class;
    }

}