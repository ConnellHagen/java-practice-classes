package ScannerFiles;

import java.util.Scanner;

public class Social{
  	private String socialNum;

	public Social(){}

	public Social(String soc){
		socialNum = soc;
	}

	public void setSocial(String soc){
		socialNum = soc;
	}

	public int getSum(){
		Scanner sumScan = new Scanner(socialNum);
		sumScan.useDelimiter("-");
		int sum = 0;
		while(sumScan.hasNextInt()){
			sum += sumScan.nextInt();
		}
		sumScan.close();
		return sum;
	}

	@Override
	public String toString(){
		return "SS# " + socialNum + " has a sum of: " + getSum();
	}
}