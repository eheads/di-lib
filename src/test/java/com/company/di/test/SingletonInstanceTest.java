package com.company.di.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.company.di.DependencyFactory;

@DisplayName("SingletonExample Test")
public class SingletonInstanceTest {

	private DependencyFactory diFactory;

	@BeforeEach
	void setup() {
		diFactory = new DependencyFactory();
	}

	@Test
	@DisplayName("SingletonExample instance testing")
	void test_success_singleton_instance() {

		final SingletonExample bean1 = diFactory.getBean(SingletonExample.class);
		final SingletonExample bean2 = diFactory.getBean(SingletonExample.class);

		assertNotNull(bean1);
		assertNotNull(bean1);
		assertEquals(bean1, bean1);
	}
}