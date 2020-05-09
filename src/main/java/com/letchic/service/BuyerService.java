package com.letchic.service;

import com.letchic.model.Buyer;
import com.letchic.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

@Service
public class BuyerService extends AbstractService<Buyer, BuyerRepository> {

    @Autowired
    private BuyerRepository customerRepository;

    public List<String> getBuyerDistrict() {
        return customerRepository.getBuyerDistrict();
    }

    public Map<String, Double> getCBuyerLLastNameAndPriceByDistrict(String district) {
        return customerRepository.getCBuyerLLastNameAndPriceByDistrict(district)
                .stream()
                .collect(Collectors.toMap(
                        object -> ((String) object[0]),
                        object -> ((Number) object[1]).doubleValue()
                ));
    }
}