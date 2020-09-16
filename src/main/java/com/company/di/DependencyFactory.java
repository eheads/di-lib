package com.company.di;

import java.util.HashMap;
import java.util.Map;

public class DependencyFactory {
	
	private static Map<Class<?>, Object> prototypes = new HashMap();

	public <T> T getBean(Class<?> thisClass) {
		T result = null;

		result = (T) createNewInstance(thisClass);

		return result;
	}

	private Object createNewInstance(Class<?> type) {
		Object result = null;

		try {
			result =  type.newInstance();

				prototypes.put(type, result);
		} catch (InstantiationException e) {
			System.out.println("Exception thrown: "+e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println("Exception thrown: "+e.getMessage());
		}
		return result;
	}
}