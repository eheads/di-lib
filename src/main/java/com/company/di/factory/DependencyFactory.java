package com.company.di.factory;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

public class DependencyFactory {
	
	private static Map<Class<?>, Object> prototypes = new HashMap<Class<?>, Object>();
	private static Map<Class<?>, Object> singletons = new HashMap<Class<?>, Object>();

	@SuppressWarnings("unchecked")
	public <T> T getBean(Class<?> thisClass) {
		T result = null;

		if(isSingleton(thisClass)) {
			result = (T) singletons.get(thisClass);

			if(result == null) {
				result = (T) createNewInstance(thisClass);
			}
		}else {
			result = (T) createNewInstance(thisClass);
		}

		return result;
	}

	private boolean isSingleton(Class<?> type) {
		return (type.isAnnotationPresent(Singleton.class));
	}

	private Object createNewInstance(Class<?> type) {
		Object result = null;

		try {
			result =  type.newInstance();

			if(isSingleton(type)) {
				singletons.put(type, result);
			}else {
				prototypes.put(type, result);
			}
		} catch (InstantiationException e) {
			System.out.println("Exception thrown: "+e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println("Exception thrown: "+e.getMessage());
		}
		return result;
	}
}