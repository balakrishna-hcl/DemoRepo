package com.virtusa.codetest;

class NumberWordConverter {

	static String one[] = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
			"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

	static String ten[] = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
	public static final String INVALID_INPUT_GIVEN = "Invalid input given";

	static String numToWords(int n, String s) {
		String str = "";
		if (n > 19) {
			str += ten[n / 10] + one[n % 10];
		} else {
			str += one[n];
		}

		if (n != 0) {
			str += s;
		}

		return str;
	}

	static String convert(final long n) {
		if (n < 0 || n > 999999999) {
			return INVALID_INPUT_GIVEN;
		}
		if (n < 20) {
			return one[(int) n];
		}
		if (n < 100) {
			return ten[(int) n / 10] + ((n % 10 != 0) ? " " : "") + one[(int) n % 10];
		}
		if (n < 1000) {
			return one[(int) n / 100] + " hundred" + ((n % 100 != 0) ? " and " : "") + convert(n % 100);
		}
		if (n < 1_000_000) {
			return convert(n / 1000) + " thousand" + ((n % 1000 != 0) ? " and " : "") + convert(n % 1000);
		}
		if (n < 1_000_000_000) {
			return convert(n / 1_000_000) + " million" + ((n % 1_000_000 != 0) ? " and " : "") + convert(n % 1_000_000);
		}
		return convert(n / 1_000_000_000) + " billion" + ((n % 1_000_000_000 != 0) ? " and " : "")
				+ convert(n % 1_000_000_000);
	}

}
