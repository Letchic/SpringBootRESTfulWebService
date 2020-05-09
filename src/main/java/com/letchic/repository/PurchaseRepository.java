package com.letchic.repository;

import com.letchic.model.Book;
import com.letchic.model.Purchase;
import com.letchic.model.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PurchaseRepository extends CommonRepository<Purchase> {
    String queryGetSaleForMonth = "SELECT c.lastname, c.district, s.saledate " +
            "FROM purchase s JOIN buyer c ON s.buyer = c.id JOIN purchase ON shop.id = s.seller " +
            "WHERE c.district = store.district AND EXTRACT(month from s.sale_date) >= :monthNumber " +
            "ORDER BY s.saledate";

  @Query(value = "SELECT DISTINCT to_char(s.saledate, 'Month')  FROM Purchase s", nativeQuery = true)
    List<String> monthsOfSale();

    @Query(value = "SELECT s.buyer.lastname, s.seller.name FROM Purchase s")
    List<Object[]> getSecNameAndTitleForSale();

    @Query(value = "SELECT s.saledate,s.buyer.lastname,s.buyer.discount,s.book.title,s.quantity FROM Purchase s")
    List<Object[]> getSacNameDateDiscountBookTitleAndQuantity();

    @Query(value = "SELECT s.id,s.buyer.lastname,s.saledate FROM Purchase s WHERE s.saleCost >= :saleCostLevel")
    List<Object[]> getSaleIdCustomerAndDateForSaleCost(@Param("saleCostLevel") double saleCostLevel);

    @Query(value = queryGetSaleForMonth, nativeQuery = true)
    List<Object[]> getSaleInCustomerNeighborhoodForMonth(@Param("monthNumber") int monthNumber);

    @Query(value = "SELECT s.seller FROM Purchase s WHERE s.seller.district <> :district AND s.buyer.discount BETWEEN 10 AND 15")
    List<Shop> getStoreFromSaleForNeighborhood(@Param("district") String district);

    @Query(value = "SELECT s.book FROM Purchase s WHERE s.book.warehouse = s.seller.district AND s.book.quantity > :quantity")
    List<Book> getBookFromSaleForQuantity(@Param("quantity") int quantity);
}