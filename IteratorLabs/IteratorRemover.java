package IteratorLabs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorRemover
{
	private ArrayList<String> list;
	private String toRemove;

	public IteratorRemover(String line, String rem) {
		list = new ArrayList<String>();
		String[] entries = line.split(" ");
		list = new ArrayList<String>(Arrays.asList(entries));

		toRemove = rem;
	}

	public void remove() {
		Iterator<String> listIterator = list.iterator();
		while(listIterator.hasNext()) {
			if(listIterator.next().equals(toRemove)) listIterator.remove();
		}
	}

	public String toString() {
		return list.toString();
	}
}