
public class Test2 implements Runnable{
	private IntFunction intFunction;
	
	public Test2(IntFunction intFunction) {
		this.intFunction = intFunction;
	}
	
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(intFunction.printInt());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
		}
}
