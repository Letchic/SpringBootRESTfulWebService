package com.letchic.views;

import java.sql.Date;

public interface PurchaseView {
    Integer getId();
    Date getSaleDate();
    String getLastname();
    Double getDiscount();
    String getTitle();
    Double getQuantity();
    String getDistrict();
}
