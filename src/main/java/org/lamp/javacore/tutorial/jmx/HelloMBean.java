package org.lamp.javacore.tutorial.jmx;

// The interface for the Hello MBean
public interface HelloMBean {
	// Get and set the message attribute
	String getMessage();

	void setMessage(String message);

	// Invoke the sayHello operation
	void sayHello();

	String greeting();
}
