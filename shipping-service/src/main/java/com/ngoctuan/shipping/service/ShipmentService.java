package com.ngoctuan.shipping.service;

import com.ngoctuan.data.entity.Shipment;

import java.util.List;

public interface ShipmentService {

    void ship(Shipment shipment);

    Shipment findById(long id);

    List<Shipment> findAll();
}
