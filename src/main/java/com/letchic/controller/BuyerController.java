package com.letchic.controller;

import com.letchic.model.Buyer;
import com.letchic.service.BuyerService;
import com.letchic.views.DistrictView;
import com.letchic.views.LastNameAndDiscountView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/customer")
public class BuyerController extends CommonController<Buyer, BuyerService> {

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/getLastNameAndPrice")

   public ResponseEntity<List<LastNameAndDiscountView>> getSecNameAndPriceByDistrict(@RequestParam String district) {
        List<LastNameAndDiscountView> result = buyerService.getCustomerSecNameAndPriceByDistrict(district);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

   @GetMapping("/district")
      public List<DistrictView> getDistrict() {
        return buyerService.getCustomersNeighborhood();
    }

}