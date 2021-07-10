
public class assign5{
	interface Domestic { }
	interface Import { }
	interface Japanese extends Import { }
	interface German extends Import { }
	interface Detroit extends Domestic { }
	interface SpringHill extends Domestic { }

	interface Vehicle {
		int getWeightInPounds( );
	}
	interface Automobile extends Vehicle { }
	interface LargeAutomobile extends Vehicle { }
	interface Sedan extends Automobile { }
	interface Van extends LargeAutomobile { }
	interface Truck extends LargeAutomobile { }
	interface Compact extends Automobile { }
	interface SportsUtilityVehicle extends Truck, Van { }

	class SaturnSL1 implements SpringHill, Sedan {
		int weight=1000;
		public int getWeightInPounds() {
			return weight;
		}
	}
	
	class HondaCivic implements Japanese, Compact {
		int weight=1000;
		public int getWeightInPounds() {
			return weight;
		}
	}
	
	class MercedesC230 implements German, Sedan {
		int weight=1000;
		public int getWeightInPounds() {
			return weight;
		}
	}
	
	class ChevyS10 implements Detroit, Truck {
		int weight=2500;
		public int getWeightInPounds() {
			return weight;
		}
	}
	
	class SubaruOutback implements Japanese, SportsUtilityVehicle {
		int weight=2500;
		public int getWeightInPounds() {
			return weight;
		}
	}
	
	class ParkingGarage{
		int carsTotal = 0,weightsTotal = 0;
		
		public void parkVehicle (Vehicle v) {
			int newWeight = v.getWeightInPounds();
			if ((carsTotal < 20) & (weightsTotal + newWeight < 25000)) {
				carsTotal += 1;
				weightsTotal += newWeight;
			}else {
				System.out.println("Full capacity. No more parking allowed.");
			}
		}
		
		void main() {
			System.out.printf("Current Capacity: %d vehicles, %d pounds",carsTotal, weightsTotal);
		}
	}
	
	public static void main(String[] args) {
		SaturnSL1 sl = new assign5().new SaturnSL1();
		HondaCivic hc = new assign5().new HondaCivic( );
		Japanese jp = null;
		German gr = new assign5().new MercedesC230( );
		ChevyS10 cs = null;
		SubaruOutback sb = new assign5().new SubaruOutback( );
		Domestic dm = sl;
		dm = null;
		dm = cs;
		dm = (Domestic)cs;
		Import im = sb;
		gr = null;
		jp = null;
		jp = (Japanese)im;
		Automobile a = hc;
		
		ParkingGarage pg001 = new assign5().new ParkingGarage();
		pg001.parkVehicle(hc);
		pg001.parkVehicle(sb);
		pg001.main();
	}
	
}
