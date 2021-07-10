import java.util.*;

public class Stats {
	
	//Calculate transactions record.
	public static int count(Analyzer a) {
	   return a.requestData().size();
	}


	public static double sum(Analyzer a) {
		List<Double> data = a.requestData();
		double sum = 0;
		for(Double d :data) {
			sum += d;
		}return sum;
	}
	
	public static double average(Analyzer a) {
		if(count(a) > 0) {
			return sum (a)/count(a);	
		}return Double.NaN;
	}
	
	public static double stdDeviation(Analyzer a) {
		List<Double> data = a.requestData();
		double sumOfDifferenceSquared = 0;
		double difference = 0;
		double avg = average(a);
		
		if(count(a) >1) {
			for(Double dataa : data) {
				difference = dataa - avg;
				sumOfDifferenceSquared += Math.pow(difference,2) ;
			}
		}return Math.sqrt((sumOfDifferenceSquared)/(count(a)-1));
	}
	
	public static double min(Analyzer a) {
		List<Double> data = a.requestData();
		double min = Double.MAX_VALUE;
		for(Double d :data) {
			if(d < min) {
				min = d;
			}
		}return min;
	}
	
    public static double max(Analyzer a) {
      	List<Double> data = a.requestData();
		double max = Double.MIN_VALUE;
		for(Double d :data) {
			if(d > max) {
				max = d;
			}
		}return max;
	}	
}
