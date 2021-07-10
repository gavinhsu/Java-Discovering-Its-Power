
import java.io.IOException;
import java.util.*;
import java.text.ParseException;
public class Bowling {
	public String name;
	public int gamePlays;
	public double avgPoint;
	public int lastPoint;
	public String date;
	//constructor for hashmap's value
	public Bowling(String name,Integer gamePlays, Double avgPoint, Integer lastPoint, String date) {
		 this.name = name;
		 this.gamePlays = gamePlays;
		 this.avgPoint = avgPoint;
		 this.lastPoint = lastPoint;
		 this.date = date;
	}
	 
public static void main (String[] args) throws IOException, ParseException {
	boolean add =true;
	HashMap<String, Bowling> bowling = new HashMap();
	while(add) {
		Scanner sc= new Scanner(System.in);
		System.out.println("If you want to add a player's new record, input 'add'. If you want to check all the record, input 'check'.");
        String input = sc.nextLine();
        if(input.contains("add") ){
        	System.out.println("Bowler's name:");
        	String name = sc.nextLine();
        	System.out.println("Playing date(dd-MM-yyyy):");
        	String date = sc.nextLine();
        	System.out.println("Bowler's points:");
        	Integer lastPoint = sc.nextInt();

        	if(bowling.size() >= 1) { //when more than one record
	          		Integer gamePlays = 0;
	          		
	          		if(bowling.containsKey(name)==false){ //insert new record
	          			Integer firstGamePlays = 1;
          			    Double avgPoint = (double) lastPoint;
          			    Bowling record = new Bowling(name, firstGamePlays, avgPoint, lastPoint,date);
        			    bowling.put(record.name,record);   
          		   }  
          		   else {   // if duplicate name
          			   	Bowling repeat = bowling.get(name);
          			   	double avg = (repeat.gamePlays*repeat.avgPoint + lastPoint) / (repeat.gamePlays+1);
	          			int Plays = repeat.gamePlays+1;
	          			String d = date;
	          			Bowling record = new Bowling(repeat.name,Plays, avg, lastPoint,d);
	          			bowling.put(record.name,record);
            	   }	
            	}
        	else { // the first record
        		Integer gamePlays = 1;
            	Double avgPoint = (double) lastPoint;
        		Bowling record = new Bowling(name, gamePlays, avgPoint, lastPoint,date);
   			    bowling.put(record.name,record);
        	}
	}
        else if(input.contains("check")) { //test case(check the record)
        	for (Object o : bowling.keySet()) {
          		String key = (String)o;   
          		Bowling recordName =  (Bowling)bowling.get(key);
            	System.out.println("Bowler name: " +recordName.name + ", Number of Games: " + recordName.gamePlays+ ", Average score of all the games: " + 
          		recordName.avgPoint+ ", Score of their last game: " + recordName.lastPoint+ ", Date of their last game: " + recordName.date);
      		   }
        }
	}

}}
