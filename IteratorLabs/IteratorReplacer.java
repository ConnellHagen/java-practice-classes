package IteratorLabs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class IteratorReplacer
{
	private ArrayList<String> list;
	private String toRemove;
	private String replacement;

	public IteratorReplacer(String line, String rem, String rep) {
		list = new ArrayList<String>();
		String[] entries = line.split(" ");
		list = new ArrayList<String>(Arrays.asList(entries));

		toRemove = rem;
		replacement = rep;
	}

	public void replace() {
		ListIterator<String> listIterator = list.listIterator();
		while(listIterator.hasNext()) {
			if(listIterator.next().equals(toRemove)) listIterator.set(replacement);
		}
	}

	public String toString() {
		return list.toString();
	}
}