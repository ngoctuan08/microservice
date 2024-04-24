package com.ngoctuan.shipping.repository;

import com.ngoctuan.data.entity.Shipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ShipmentRepository extends PagingAndSortingRepository<Shipment, Long>, CrudRepository<Shipment, Long> {

	@Query("SELECT max(s.updated) FROM Shipment s")
	Date lastUpdate();

}
