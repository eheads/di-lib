# DI-Library #

A lightweight Dependency Injection Library

## Design Considerations ##

 A single class called DependencyFactory is created to contain the logic for determining the type of class that will be injected. The main method  can accept a Class of any type so that there's no need to create different cache/hashmap objects for each type. At the moment, the logic can only validate if a certain type is of Singleton by checking if it has @Singleton annotation.

## Limitations ##

- Doesn't support interface and abstract class
- Doesn't support inner class
- Can only determine a singleton class if it has @Singleton annotation
- Spring can automatically inject an object using @Autowired annotation, this Dependency Injection library does not support it yet
- Setter injection such is not supported
- Has not tested in any Java version aside from Java 8
- The limitations above are the features I'm planning to add in the future


## Getting Started ##

Add as a Maven dependency

```xml
<dependency>
    <groupId>com.company</groupId>
    <artifactId>di-library</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

Create your classes

```java
//For prototype bean
public class Example {
	public Example() {}

	public void print() {
		System.out.println("Printing Prototype...");
	}
}
```

```java
//For Singleton bean
@Singleton
public class SingletonExample {
	public SingletonExample() {}

	public void print() {
		System.out.println("Printing Singleton...");
	}
}
```

Initialize DependencyFactory in your code and use the getBean method passing in the Class that you want to be injected

```java
public class Application {
	
	public static void main(String[] args) {
		DependencyFactory factory = new DependencyFactory();
		SingletonExample singletonExample = factory.getBean(SingletonExample.class);	
		singletonExample.print();
		
		Example prototypeExample = factory.getBean(Example.class);	
		prototypeExample.print();
	}
}
```


