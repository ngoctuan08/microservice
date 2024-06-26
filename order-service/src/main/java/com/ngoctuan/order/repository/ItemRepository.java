//package com.ngoctuan.order.repository;
//
//import com.ngoctuan.data.entity.Item;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ItemRepository extends PagingAndSortingRepository<Item, Long>, CrudRepository<Item, Long> {
//
//	List<Item> findByName(@Param("name") String name);
//
//	List<Item> findByNameContaining(@Param("name") String name);
//
//	@Query("SELECT price FROM Item i WHERE i.itemId=?1")
//	double price(long itemId);
//
//}
