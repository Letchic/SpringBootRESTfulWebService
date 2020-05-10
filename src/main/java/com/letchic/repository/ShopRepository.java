package com.letchic.repository;

import com.letchic.model.Shop;
import com.letchic.views.ShopTitleView;
import java.util.List;

public interface ShopRepository extends CommonRepository<Shop> {

  List<ShopTitleView> findByDistrictOrDistrict(String firstNeighborhood, String secondNeighborhood);
}