package com.company.di.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Prototype Instance Test")
public class PrototypeInstanceTest {
	
	private DependencyFactory factory;
	
	@BeforeEach
	void setup() {
		factory = new DependencyFactory();
	}

	@Test
	@DisplayName("Prototype instance testing")
	public void test_success_prototype_instance() {

		final Example bean1 = factory.getBean(Example.class);
		final Example bean2 = factory.getBean(Example.class);

		assertNotNull(bean1);
		assertNotNull(bean2);
		assertNotEquals(bean1, bean2);
	}

    class Example {   	
    	public Example() {}
    	public void print() {
    		System.out.println("Printing Prototype instance...");
    	}
    }
}