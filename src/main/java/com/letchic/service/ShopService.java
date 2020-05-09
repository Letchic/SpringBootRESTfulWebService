package com.letchic.service;

import com.letchic.model.Shop;
import com.letchic.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShopService extends AbstractService<Shop, ShopRepository> {
    @Autowired
    ShopRepository shopRepository;
    public List<String> getStoreNameByDistrict(String firstDistrict, String secondDistrict) {
        return shopRepository.getStoreNameByDistrict(firstDistrict, secondDistrict);
    }
}