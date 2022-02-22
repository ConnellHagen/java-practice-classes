package ArrayListToy;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ToyStore
{
	private List<Toy> toyList;
	
	public ToyStore() {
		toyList = new ArrayList<Toy>();
	}
	
	public void loadToys(String[] r) {
		toyList = new ArrayList<Toy>();
		for(String name : r) {
			Toy possibleToy = getThatToy(name);
			if(possibleToy == null) toyList.add(new Toy(name));
			else possibleToy.addCount(1);
		}
	}

	public Toy getThatToy(String name) {
		for(Toy toy : toyList) {
			if(toy.getName().equals(name)) return toy;
		}
		return null;
	}
	
	public String getMostFrequentToy() {
		int freq = 0;
		String name = "";
		for(Toy toy : toyList) {
			if(toy.getCount() > freq) {
				freq = toy.getCount();
				name = toy.getName();
			}
		}
		return name;
	}
	
	public void sortToysByCount() {
		Collections.sort(toyList);
	}
	
	public String toString() {
		return toyList.toString();
	}

}