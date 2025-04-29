package myspring.di.annot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.HelloBean;
import myspring.di.annot.PrinterBean;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloBeanConfig.class, loader=AnnotationConfigContextLoader.class)
public class HelloBeanConfigTest {
	@Autowired
	HelloBean hello;
	
	@Autowired
	PrinterBean stringPrinter; //이름을 맞춰줘야 알아서 잘 찾음
	
	@Test
	void helloBeanTest() {
		assertEquals("Hello 어노테이션", hello.sayHello());
		hello.print();
		assertEquals("Hello 어노테이션", stringPrinter.toString());
		
		assertEquals(3, hello.getNames().size());
	}
}
