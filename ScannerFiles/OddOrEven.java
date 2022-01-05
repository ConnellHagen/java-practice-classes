package ScannerFiles;

public class OddOrEven{
	private int number;

	public OddOrEven(){
		number = 0;
	}

	public OddOrEven(int num){
		number = num;
	}

	public void setNum(int num){
		number = num;
	}

	private boolean isOdd(){
		return number % 2 == 1;
	}

	@Override
	public String toString(){
		if(isOdd())
			return number + " is odd.";
		else
			return number + " is even.";
	}
}
