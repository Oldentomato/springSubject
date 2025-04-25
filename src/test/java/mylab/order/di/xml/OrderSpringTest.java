package mylab.order.di.xml;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:mylab-order-di.xml")
public class OrderSpringTest {
	@Autowired
	OrderService service;
	@Autowired
	ShoppingCart shopping;

	@Test
	void testShoppingCart() {
		assertEquals(3000, shopping.getTotalPrice());
	}
	
	@Test 
	void testOrderService() {
		assertEquals(3000, service.calculateOrderTotal());
//		assertEquals(3000, service.toString());
		System.out.println(service.toString());
	}
}
