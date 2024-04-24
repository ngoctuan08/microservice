package com.ngoctuan.order;//package com.ngoctuan.order;
//
//import com.ngoctuan.order.entity.Order;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Component;
//
//import com.ngoctuan.order.repository.CustomerRepository;
//import com.ngoctuan.order.repository.ItemRepository;
//import com.ngoctuan.order.entity.Address;
//import com.ngoctuan.order.repository.OrderRepository;
//
//import jakarta.annotation.PostConstruct;
//
//@Component
//@Profile("test")
//@DependsOn({ "itemTestDataGenerator", "customerTestDataGenerator" })
//public class OrderTestDataGenerator {
//
//	private final OrderRepository orderRepository;
//	private ItemRepository itemRepository;
//	private CustomerRepository customerRepository;
//
//	public OrderTestDataGenerator(OrderRepository orderRepository, ItemRepository itemRepository,
//			CustomerRepository customerRepository) {
//		this.orderRepository = orderRepository;
//		this.itemRepository = itemRepository;
//		this.customerRepository = customerRepository;
//	}
//
//	@PostConstruct
//	public void generateTestData() {
//		Order order = createOrder();
//		orderRepository.save(order);
//	}
//
//	public Order createOrder() {
//		Order order = new Order(customerRepository.findAll().iterator().next());
//		order.setShippingAddress(new Address("Ohlauer Str. 43", "10999", "Berlin"));
//		order.setBillingAddress(new Address("Krischerstr. 100", "40789", "Monheim am Rhein"));
//		order.addLine(42, itemRepository.findAll().iterator().next());
//		return order;
//	}
//
//}
