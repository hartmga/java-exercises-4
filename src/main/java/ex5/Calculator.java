package ex5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static void use() {
		System.out.println("Running Calculator");
		System.out.println("Supported two-argument operations:\na + b\na - b\na * b\na / b\na ^ b\n");
		System.out.println("Supported one-argument operations:\nsqrt(x)\nsin(x)\ncos(x)\ntan(x)\n");
		System.out.println("type 'exit' to exit");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		while (!"exit".equalsIgnoreCase(input)) {
			try {
				evaluate(input);
			} catch (Exception e) {
				System.out.println("an error occurred");
			}
			input = in.nextLine();
		}
		System.out.println("-------------------------------");

	}

	public static int evaluate(String s) {
		s = s.trim();
		if (s.matches("^[a-zA-Z].*")) {
			return oneArgEval(s);
		} else {
			return twoArgEval(s);
		}
	}

	public static int twoArgEval(String s) {
		double arg1, arg2, value = 0;
		// matches two decimal arguments with an operator in between
		Pattern exprPattern = Pattern.compile(
				"(-?(?:(?:\\d+\\.?\\d*)|(?:\\d*\\.?\\d+)))\\s*(\\D)\\s*(-?(?:(?:\\d+\\.?\\d*)|(?:\\d*\\.?\\d+)))");
		Matcher m = exprPattern.matcher(s);
		if (m.matches()) {
			try {
				arg1 = Double.parseDouble(m.group(1));
				arg2 = Double.parseDouble(m.group(3));
			} catch (NumberFormatException e) {
				System.out.println("\tinvalid argument");
				return -1;
			}
			// find the requested operation
			switch (m.group(2)) {
			case "+":
				value = add(arg1, arg2);
				break;
			case "-":
				value = subtract(arg1, arg2);
				break;
			case "*":
				value = multiply(arg1, arg2);
				break;
			case "/":
				value = divide(arg1, arg2);
				break;
			case "^":
				value = power(arg1, arg2);
				break;
			default:
				System.out.println("\tinvalid operation");
				return -1;
			}
			System.out.println("\t" + value);
			return 0;
		} else {
			System.out.println("\tinvalid input");
			return -1;
		}

	}

	public static int oneArgEval(String s) {
		double arg1, value = 0;
		// matches a function with one argument in parentheses
		Pattern exprPattern = Pattern.compile("([a-zA-Z]+)\\((-?((?:\\d+\\.?\\d*)|(?:\\d*\\.?\\d+)))\\)");
		Matcher m = exprPattern.matcher(s);
		if (m.matches()) {
			try {
				arg1 = Double.parseDouble(m.group(2));
			} catch (NumberFormatException e) {
				System.out.println("invalid argument");
				return -1;
			}
			// find the requested operation
			switch (m.group(1)) {
			case "sqrt":
				value = sqrt(arg1);
				break;
			case "sin":
				value = sine(arg1);
				break;
			case "cos":
				value = cosine(arg1);
				break;
			case "tan":
				value = tangent(arg1);
				break;
			default:
				System.out.println("\tinvalid operation");
				return -1;
			}
			System.out.println("\t" + value);
			return 0;
		} else {
			System.out.println("invalid input");
			return -1;
		}
	}

	public static double add(double a, double b) {
		return a + b;
	}

	public static double subtract(double a, double b) {
		return a - b;
	}

	public static double multiply(double a, double b) {
		return a * b;
	}

	public static double divide(double a, double b) {
		return a / b;
	}

	public static double power(double a, double b) {
		return Math.pow(a, b);
	}

	public static double sqrt(double a) {
		return Math.sqrt(a);
	}

	public static double sine(double a) {
		return Math.sin(a);
	}

	public static double cosine(double a) {
		return Math.cos(a);
	}

	public static double tangent(double a) {
		return Math.tan(a);
	}
}
