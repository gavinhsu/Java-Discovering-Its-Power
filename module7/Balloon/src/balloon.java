import java.util.Scanner;

public class balloon {
	private static int maxPressure = 100;
	public static int nowPressure = 0;
	
	public static int inflate(int pressure) { 
		nowPressure += pressure;
		return nowPressure;
	}
	
	public static void main(String args[]) {
		
		while(true){
			if(nowPressure < maxPressure) {
				Scanner sc= new Scanner(System.in);
				System.out.println("How much you would like to inflate:");
		        Integer inflateVolume = sc.nextInt();
		        int volume = inflate(inflateVolume);
		        if(volume<=maxPressure) {
			        System.out.println("The volume of the balloon right now is: " + volume);
		        }
			}
			else {
				break;
			}
		}
		if(nowPressure > maxPressure) {
			System.out.println("Balloon is overflated");
		}
		

		
	}

}
