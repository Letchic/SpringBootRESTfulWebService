package com.letchic.repository;

import com.letchic.model.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ShopRepository extends CommonRepository<Shop> {

    @Query(value = "SELECT s.name FROM Shop s WHERE s.district = :firstDistrict OR s.district = :secondDistrict")
    List<String> getStoreNameByDistrict(@Param("firstDistrict") String firstDistrict,
                                            @Param("secondDistrict") String secondDistrict);
}