package com.letchic.service;

import com.letchic.model.Book;
import com.letchic.model.Purchases;
import com.letchic.model.Shop;
import com.letchic.repository.PurchaseRepository;
import com.letchic.views.LastNameAndShopTitleView;
import com.letchic.views.MonthView;
import com.letchic.views.PurchaseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService extends AbstractService<Purchases, PurchaseRepository> {

    @Autowired
    private PurchaseRepository purchaseRepository;

   public List<MonthView> monthsOfSale() {
        return purchaseRepository.monthsOfSale();
    }

    public List<LastNameAndShopTitleView> getLastNameAndTitleForSale() {
        return purchaseRepository.getLastNameAndTitleForSale();
    }

    public List<PurchaseView> getLastNameDateDiscountBookTitleAndQuantity() {
        return purchaseRepository.getSacNameDateDiscountBookTitleAndQuantity();
    }

    public List<PurchaseView> getSaleIdBuyerAndDateForSaleCost(double saleCost) {
        return purchaseRepository.getSaleIdBuyerAndDateForSaleCost(saleCost);
    }

    public List<PurchaseView> getSaleInBuyerDistrictForMonth(int monthNumber) {
        return purchaseRepository.getSaleInBuyerDistrictForMonth(monthNumber);
    }

    public List<Shop> getShopFromSaleForDistrict(String neighborhood) {
        return purchaseRepository.getShopFromSaleForDistrict(neighborhood);
    }

    public List<Book> getBookFromSaleForQuantity(int quantity){
        return purchaseRepository.getBookFromSaleForQuantity(quantity);
    }
}

