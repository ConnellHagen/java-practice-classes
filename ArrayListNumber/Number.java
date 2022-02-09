package ArrayListNumber;

import java.util.ArrayList;

public class Number {
	private int number;

	public Number(int p_number) {
		number = p_number;
	}

	public boolean isEven() {
		return number % 2 == 0;
	}

	public boolean isPerfect() {
		ArrayList<Integer> divisors = new ArrayList<Integer>();

		int currentNum = 1;
		while(currentNum <= number / 2.0) {
			if(number % currentNum == 0) divisors.add(currentNum);
			currentNum++;
		}

		int total = 0;
		for(int num : divisors) {
			total += num;
		}

		return total == number;

	}

	public String toString() {
		return String.valueOf(number);
	}
	
}