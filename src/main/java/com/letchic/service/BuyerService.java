package com.letchic.service;

import com.letchic.model.Buyer;
import com.letchic.repository.BuyerRepository;
import com.letchic.views.DistrictView;
import com.letchic.views.LastNameAndDiscountView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BuyerService extends AbstractService<Buyer, BuyerRepository> {

    @Autowired
    private BuyerRepository customerRepository;


public List<DistrictView> getCustomersNeighborhood() {
    return customerRepository.findDistinctBy();
}


public List<LastNameAndDiscountView> getCustomerSecNameAndPriceByDistrict(String district) {
    return customerRepository.findByDistrict(district);
}
}