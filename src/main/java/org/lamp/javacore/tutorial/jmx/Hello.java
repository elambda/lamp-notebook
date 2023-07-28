package org.lamp.javacore.tutorial.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

// A simple JMX Java code that creates and registers an MBean
public class Hello implements HelloMBean {

	private String message = "Hello, world!";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void sayHello() {
		System.out.println(message);
	}

	@Override
	public String greeting() {
		return "hello "+ message;
	}

	public static void main(String[] args) throws Exception {
		// Get the MBean server
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		// Create and register the Hello MBean
		ObjectName name = new ObjectName("org.lamp:type=Hello");
		Hello mbean = new Hello();
		mbs.registerMBean(mbean, name);
		// Wait for user input
		System.out.println("Press enter to exit...");
		System.in.read();
	}
}

