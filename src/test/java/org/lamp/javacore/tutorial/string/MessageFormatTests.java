package org.lamp.javacore.tutorial.string;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageFormatTests {

	@Test
	protected void testMessageFormat() {
		String messageValue = MessageFormat.format("name={0}, age={1}, comment={0}", "Lamp", 25);

		assertEquals("name=Lamp, age=25, comment=Lamp", messageValue);
	}

	@Test
	protected void testStringFormat() {
		String stringValue = String.format("name=%s, age=%d, comment=%s", "Lamp", 25, "Lamp");

		assertEquals("name=Lamp, age=25, comment=Lamp", stringValue);
	}

	@Test
	protected void testInConsecutiveIndex() {
		String messageValue = MessageFormat.format("name={2}, age={1}, comment={2}", null, 25, "Lamp");
		assertEquals("name=Lamp, age=25, comment=Lamp", messageValue);
	}

}
