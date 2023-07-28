package org.lamp.javacore.tutorial;

import java.util.stream.Stream;

public class SqlConjunctionMain {

	public static void main(String[] args) {
		StringBuffer columns = new StringBuffer();

		Stream.of("ID", "NAME", "AGE")
				.forEach(item -> columns.append(item).append(","));

		StringBuffer updatedColumns = columns.deleteCharAt(columns.length() - 1);

		String updatedSQL = "DELETE TABLE TBL_USER WHERE ID IN (%s)".formatted(updatedColumns);

		System.out.println(updatedSQL);
	}
}
