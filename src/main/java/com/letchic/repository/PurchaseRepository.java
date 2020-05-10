package com.letchic.repository;

import com.letchic.model.Book;
import com.letchic.model.Purchases;
import com.letchic.model.Shop;
import com.letchic.views.LastNameAndShopTitleView;
import com.letchic.views.MonthView;
import com.letchic.views.PurchaseView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PurchaseRepository extends CommonRepository<Purchases> {
    String queryGetSaleForMonth = "SELECT c.lastname AS lastname, c.district AS district, s.saledate AS saledate " +
            "FROM purchases s JOIN buyer c ON s.buyer = c.id JOIN purchases ON shop.id = s.seller " +
            "WHERE c.district = store.district AND EXTRACT(month from s.sale_date) >= :monthNumber " +
            "ORDER BY s.saledate";

  @Query(value = "SELECT DISTINCT to_char(s.saledate, 'Month') AS month FROM Purchases s", nativeQuery = true)
    List<MonthView> monthsOfSale();

    @Query(value = "SELECT s.buyer.lastname AS lastname, s.seller.name AS name FROM Purchases s")
    List<LastNameAndShopTitleView> getLastNameAndTitleForSale();

    @Query(value = "SELECT s.saledate AS saledate,s.buyer.lastname AS lastname,s.buyer.discount AS discount,s.book.title AS title,s.quantity AS quantity FROM Purchases s")
    List<PurchaseView> getSacNameDateDiscountBookTitleAndQuantity();

    @Query(value = "SELECT s.id AS id,s.buyer.lastname AS lastname,s.saledate AS saledate FROM Purchases s WHERE s.salecost >= :saleCost")
    List<PurchaseView> getSaleIdBuyerAndDateForSaleCost(@Param("saleCost") double saleCost);

    @Query(value = queryGetSaleForMonth, nativeQuery = true)
    List<PurchaseView> getSaleInBuyerDistrictForMonth(@Param("monthNumber") int monthNumber);

    @Query(value = "SELECT s.seller FROM Purchases s WHERE s.seller.district <> :district AND s.buyer.discount BETWEEN 10 AND 15")
    List<Shop> getShopFromSaleForDistrict(@Param("district") String district);

    @Query(value = "SELECT s.book FROM Purchases s WHERE s.book.warehouse = s.seller.district AND s.book.quantity > :quantity")
    List<Book> getBookFromSaleForQuantity(@Param("quantity") int quantity);
}