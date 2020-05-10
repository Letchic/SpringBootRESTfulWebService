package com.letchic.service;

import com.letchic.model.Shop;
import com.letchic.repository.ShopRepository;
import com.letchic.views.ShopTitleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShopService extends AbstractService<Shop, ShopRepository> {
    @Autowired
    ShopRepository shopRepository;
    public List<ShopTitleView> getStoreNameByDistrict(String firstDistrict, String secondDistrict) {
        return shopRepository.findByDistrictOrDistrict(firstDistrict, secondDistrict);
    }
}