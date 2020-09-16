package com.company.di.model;

import javax.inject.Singleton;

@Singleton
public class SingletonExample {
	public SingletonExample() {}

	public void print() {
		System.out.println("Printing Prototype...");
	}
}
