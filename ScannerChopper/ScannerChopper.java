package ScannerChopper;
import java.util.Scanner;

public class ScannerChopper {
    private String line;
    private int breaker;

    public ScannerChopper(){
        line = "";
        breaker = 1;
    }

    public ScannerChopper(String s){
        line = s;
        breaker = 1;
    }

    public ScannerChopper(String s, int b){
        line = s;
        breaker = b;
    }

    public void setLine(String s){
        line = s;
    }

    public void setBreaker(int b){
        breaker = b;
    }

    public void setLineBreaker(String s, int b){
        line = s;
        breaker = b;
    }

    public String getLine(){
        return line;
    }

    public int getCount(){
		int count = 0;
		Scanner lineScanner = new Scanner(line);
		while(lineScanner.hasNextInt()){
			count++;
			lineScanner.next();
		}
		lineScanner.close();
		return count;
	}

	public int getSum(){
		int sum = 0;
		Scanner lineScanner = new Scanner(line);
		while(lineScanner.hasNextInt()){
			sum += lineScanner.nextInt();
		}
		lineScanner.close();
		return sum;
	}

	public double getAverage(){
		return (double)getSum() / getCount();
	}

    public String getLineBreaker()
	{
		String box = "";
		String newLine = System.getProperty("line.separator");
		Scanner lineScanner = new Scanner(line);
		int counter = 0;
		while(lineScanner.hasNext()){
			box = box.concat(lineScanner.next());
			counter++;
			if(counter % breaker == 0) box = box.concat(newLine);
		}

		lineScanner.close();
		return box;
	}

    @Override
    public String toString(){
        return line;
    }

}
