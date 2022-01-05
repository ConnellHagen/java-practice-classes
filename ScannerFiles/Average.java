package ScannerFiles;

import java.util.Scanner;

public class Average
{
	private String line;

	public Average(){
		line = "0";
	}

	public Average(String pLine){
		line = pLine;
	}

	public void setLine(String newLine){
		line = newLine;
	}

	private int getLowest(){
		int lowest = Integer.MAX_VALUE;
		Scanner lowScan = new Scanner(line);
		while(lowScan.hasNextInt()){
			int number = lowScan.nextInt();
			if(number < lowest)
				lowest = number;
		}
		lowScan.close();
		return lowest;
	}

	public double getAverage(){
		double average = 0.0;
		int totalNums = 0;
		Scanner scanAvg = new Scanner(line);
		boolean hasThrownOut = false; 

		while(scanAvg.hasNextInt()){
			int currentNum = scanAvg.nextInt();
			if(!hasThrownOut && currentNum == getLowest()){
				hasThrownOut = true;
				continue;
			}
			totalNums++;
			average += currentNum;
		}
		average *= 100;
		average /= totalNums;
		average = Math.round(average);
		average /= 100;
	
		scanAvg.close();
		return average;
	}

	public String getLine(){
		return line;
	}

	@Override
	public String toString(){
		return "average = " + getAverage();
	}

}