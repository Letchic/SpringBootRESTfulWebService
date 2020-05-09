package com.letchic.repository;


import com.letchic.model.Buyer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuyerRepository extends CommonRepository<Buyer>{

    @Query(value = "SELECT DISTINCT district FROM Buyer ")
    List<String> getBuyerDistrict();

    @Query(value = "SELECT b.lastname, b.discount FROM Buyer b WHERE b.district = :district")
    List<Object[]> getCBuyerLLastNameAndPriceByDistrict(@Param("district") String district);
}
