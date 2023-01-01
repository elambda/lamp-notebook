package org.lamp.javacore.tutorial.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DotAllMain {

	public static void main(String[] args) {
		withDotAll();
		withoutDotAll();
		withDotAll1();
	}

	private static void withDotAll() {
		System.out.println("===========withDotAll=============");

		String regex = ".";
		String input = "this is first line of sample. \nthis is second line.";
		Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(input);
		int count = 0;
		while (matcher.find()) {
			count++;
			System.out.print(matcher.group());
		}
		System.out.println();
		System.out.println("Number of new line characters: " + count);
		System.out.println("===========withDotAll=============");
	}

	private static void withoutDotAll() {
		System.out.println("===========withoutDotAll=============");
		String regex = ".";
		String input = "this is first line of sample. \nthis is second line.";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		int count = 0;
		while (matcher.find()) {
			count++;
			System.out.print(matcher.group());
		}
		System.out.println();
		System.out.println("Number of new line characters: " + count);
		System.out.println("===========withoutDotAll=============");
	}

	private static void withDotAll1() {
		System.out.println("===========withDotAll1=============");

		String regex = ".";
		String input = "this is first line of sample. \nthis is second line.";
		Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(input);
		int count = 0;
		while (matcher.find()) {
			count++;
			System.out.print(matcher.group());
		}
		System.out.println();
		System.out.println("Number of new line characters: " + count);
		System.out.println("===========withDotAll1=============");
	}
}