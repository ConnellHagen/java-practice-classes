package Person;

public class Person implements Comparable<Person>
{
	private int year;
	private int month;
	private int day;
	private String name;

	public Person(int year, int month, int day, String name) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.name = name;
	}

	public int compareTo(Person other) {
		if(year != other.getYear()) {
			return other.getYear() - year;
		}
		if(month != other.getMonth()) {
			return other.getMonth() - month;
		}
		if(day != other.getDay()) {
			return other.getDay() - day;
		}
		return other.getName().compareTo(name);
	}

	public int getYear() {return year;}
	public int getMonth() {return month;}
	public int getDay() {return day;}
	public String getName() {return name;}

	public String toString() {
		return year + "." + month + "." + day + " " + name;
	}
}