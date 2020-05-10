package com.letchic.controller;

import com.letchic.model.Book;
import com.letchic.model.Purchases;
import com.letchic.model.Shop;
import com.letchic.service.PurchaseService;
import com.letchic.views.LastNameAndShopTitleView;
import com.letchic.views.MonthView;
import com.letchic.views.PurchaseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rest/sale")
public class PurchaseController extends CommonController<Purchases, PurchaseService> {

    @Autowired
    PurchaseService saleService;

    @GetMapping("/monthsOfSale")
    public List<MonthView> getMonthsOfSale(){
        return saleService.monthsOfSale();
    }

    @GetMapping("/getLastNameAndTitle")
    public ResponseEntity<List<LastNameAndShopTitleView>> getLastNameAndTitleForSale(){
        List<LastNameAndShopTitleView> result = saleService.getLastNameAndTitleForSale();
        if(!result.isEmpty()){
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getSaleIdBuyerAndDateForSaleCost")
    public ResponseEntity<List<PurchaseView>> getSaleIdBuyerAndDateForSaleCost(@RequestParam double saleCost){
        List<PurchaseView> result = saleService.getSaleIdBuyerAndDateForSaleCost(saleCost);
        if(!result.isEmpty()){
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getLastNameDateDiscountBookTitleAndQuantity")
    public ResponseEntity<List<PurchaseView>> getLastNameDateDiscountBookTitleAndQuantity(){
        List<PurchaseView> result = saleService.getLastNameDateDiscountBookTitleAndQuantity();
        if(!result.isEmpty()){
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getSaleInBuyerDistrictForMonth")
    public ResponseEntity<List<PurchaseView>> getSaleInBuyerDistrictForMonth(@RequestParam int monthNumber) {
        List<PurchaseView> result = saleService.getSaleInBuyerDistrictForMonth(monthNumber);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getBookFromSaleForQuantity")
    public ResponseEntity<List<Book>> getBookFromSaleForQuantity(@RequestParam int quantity){
        List<Book> result = saleService.getBookFromSaleForQuantity(quantity);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getShopFromSaleForDistrict")
    public ResponseEntity<List<Shop>> getStoreFromSaleForDistrict(@RequestParam String district){
        List<Shop> result = saleService.getShopFromSaleForDistrict(district);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
