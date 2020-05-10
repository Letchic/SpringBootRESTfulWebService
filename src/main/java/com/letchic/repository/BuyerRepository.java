package com.letchic.repository;

import com.letchic.model.Buyer;
import com.letchic.views.DistrictView;
import com.letchic.views.LastNameAndDiscountView;


import java.util.List;

public interface BuyerRepository extends CommonRepository<Buyer>{

    List<LastNameAndDiscountView> findByDistrict(String district);
    List<DistrictView> findDistinctBy();
}

