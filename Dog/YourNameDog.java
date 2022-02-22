package Dog;

public class YourNameDog implements Dog {
	private String ownerName;
	private String dogName;
	private String bark;


	public YourNameDog(String p_ownerName, String p_dogName, String p_bark) {
		ownerName = p_ownerName;
		dogName = p_dogName;
		bark = p_bark;
	}

	public String getOwnerName() {return ownerName;}
	public String getDogName() {return dogName;}
	public String getBark() {return bark;}

	@Override
	public String toString() {
		return ownerName + "'s dog "+ dogName +" says "+ bark;
	}
	
}