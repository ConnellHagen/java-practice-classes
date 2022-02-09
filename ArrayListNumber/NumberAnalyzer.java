package ArrayListNumber;

import java.util.ArrayList;
import java.util.Iterator;

public class NumberAnalyzer
{
	private ArrayList<Number> list;

	public NumberAnalyzer(ArrayList<Number> p_list) {
	list = new ArrayList<Number>();

		list = p_list;
	}

	public NumberAnalyzer(int[] intArray) {

		list = new ArrayList<Number>();

		for(int i = 0; i < intArray.length; i++) {
			list.add(new Number(intArray[i]));
		}
	}

	public int countOdds() {
		int counter = 0;
		Iterator<Number> iter = list.iterator();
		while(iter.hasNext()) {
			if(!iter.next().isEven()) counter++;
		}

		return counter;
	}

	public int countEvens() {
		int counter = 0;
		Iterator<Number> iter = list.iterator();
		while(iter.hasNext()) {
			if(iter.next().isEven()) counter++;
		}

		return counter;
	}

	public int countPerfects() {
		int counter = 0;
		Iterator<Number> iter = list.iterator();
		while(iter.hasNext()) {
			if(iter.next().isPerfect()) counter++;
		}

		return counter;
	}
	
	public String toString() {
		return list.toString();
	}
}