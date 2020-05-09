package com.letchic.controller;

import com.letchic.model.Book;
import com.letchic.model.Purchase;
import com.letchic.model.Shop;
import com.letchic.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/sale")
public class PurchaseController extends CommonController<Purchase, PurchaseService> {

    @Autowired
    PurchaseService saleService;

    @GetMapping("/monthsOfSale")
    public List<String> getMonthsOfSale(){
        return saleService.monthsOfSale();
    }

    @GetMapping("/getSecNameAndShopTitle")
    public ResponseEntity<List<Object[]>> getSecNameAndShopTitle(){
        List<Object[]> result = saleService.getSecNameAndTitleForSale();
        if(!result.isEmpty()){
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getSacNameDateDiscountBookTitleAndQuantity")
    public ResponseEntity<List<Object[]>> getSacNameDateDiscountBookTitleAndQuantity(){
        List<Object[]> result = saleService.getSacNameDateDiscountBookTitleAndQuantity();
        if(!result.isEmpty()){
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getSaleIdCustomerAndDateForSaleCost")
    public ResponseEntity<List<Object[]>> getSaleIdCustomerAndDateForSaleCost(@RequestParam double saleCostLevel){
        List<Object[]> result = saleService.getSaleIdCustomerAndDateForSaleCost(saleCostLevel);
        if(!result.isEmpty()){
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getSaleInCustomerNeighborhoodForMonth")
    public ResponseEntity<List<Object[]>> getSaleInCustomerNeighborhoodForMonth(@RequestParam int monthNumber) {
        List<Object[]> result = saleService.getSaleInCustomerNeighborhoodForMonth(monthNumber);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getStoreFromSaleForNeighborhood")
    public ResponseEntity<List<Shop>> getStoreFromSaleForNeighborhood(@RequestParam String neighborhood){
        List<Shop> result = saleService.getStoreFromSaleForNeighborhood(neighborhood);
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

    @Override
    public Class<Purchase> getEType() {
        return Purchase.class;
    }

}
