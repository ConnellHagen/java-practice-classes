package ScannerFiles;

import java.util.Scanner;

public class Largest{
	private String line;

	public Largest(){
		line = "";
	}

	public Largest(String s){
		line = s;
	}

	public int getLargest(){
		int largest = Integer.MIN_VALUE;
		Scanner lineScan = new Scanner(line);

		while(lineScan.hasNextInt()){
			int num = lineScan.nextInt();
			if(num > largest){
				largest = num;
			}
		}

		lineScan.close();
		return largest;
	}

	@Override
	public String toString(){
		return "largest == " + getLargest();
	}
}