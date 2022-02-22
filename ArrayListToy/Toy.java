package ArrayListToy;

public class Toy implements Comparable<Toy> {
	private String name;
	private int count;

	public Toy(String p_name) {
		name = p_name;
		count = 1;
	}

	public int compareTo(Toy other) {
		int compare = other.getCount() - count;
		if(compare != 0) return compare;
		return name.compareTo(other.getName());
	}

	public String toString() {
		return "Name: " + name + ", Count: " + count;
	}

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int p_count) {
		count = p_count;
	}

	public void addCount(int num) {
		count += num;
	}

}
