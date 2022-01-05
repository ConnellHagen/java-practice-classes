package ScannerFiles;

public class Box{
	private String let;
	private int size;

	public Box(){
		let = "";
		size = 0;
	}

	public Box(String line){
		let = line.substring(0,1);
		size = Integer.valueOf(line.substring(2));
	}

	@Override
	public String toString(){
		String output = "";
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				output += let;
			}
			output += "\n";
		}

		return output;
	}
}