import java.io.BufferedReader; 
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class LinesCount {
	public static void main(String[] args) throws IOException {
		ArrayList<String> lineList = new ArrayList<String>();
		try {
			Scanner sc= new Scanner(System.in);
	        System.out.println("Which File do you want to read:");
	        String fileName = sc.nextLine();
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			while (br.ready()) {
				String line = br.readLine();
				lineList.add(line);
			}
			
			while(true) {
				System.out.println("How many lines that you want to read:");
		        Integer lineNums = sc.nextInt();
		        if(lineList.size() > lineNums  && lineNums > 0) {
		        	for(String i : lineList.subList(0, lineNums)){
		        	System.out.println(i);}
		        }
		        else if(lineNums == 0 || -1 * lineList.size() > lineNums || 1 * lineList.size() < lineNums) {
		        	for(String i : lineList) {
		        	System.out.println(i);}
		        }
		        else {
		        	for(String i: lineList.subList(lineList.size() + lineNums, lineList.size())) {
		        		System.out.println(i);
		        	}
		        }
		        fr.close();
			}
	        
			
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}
