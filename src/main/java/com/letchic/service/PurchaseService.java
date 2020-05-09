package com.letchic.service;

import com.letchic.model.Book;
import com.letchic.model.Purchase;
import com.letchic.model.Shop;
import com.letchic.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService extends AbstractService<Purchase, PurchaseRepository> {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<String> monthsOfSale() {
        return purchaseRepository.monthsOfSale();
    }

    public List<Object[]> getSecNameAndTitleForSale() {
        return purchaseRepository.getSecNameAndTitleForSale();
    }

    public List<Object[]> getSacNameDateDiscountBookTitleAndQuantity() {
        return purchaseRepository.getSacNameDateDiscountBookTitleAndQuantity();
    }

    public List<Object[]> getSaleIdCustomerAndDateForSaleCost(double saleCostLevel) {
        return purchaseRepository.getSaleIdCustomerAndDateForSaleCost(saleCostLevel);
    }

    public List<Object[]> getSaleInCustomerNeighborhoodForMonth(int monthNumber) {
        return purchaseRepository.getSaleInCustomerNeighborhoodForMonth(monthNumber);
    }

    public List<Shop> getStoreFromSaleForNeighborhood(String neighborhood) {
        return purchaseRepository.getStoreFromSaleForNeighborhood(neighborhood);
    }

    public List<Book> getBookFromSaleForQuantity(int quantity){
        return purchaseRepository.getBookFromSaleForQuantity(quantity);
    }
}

