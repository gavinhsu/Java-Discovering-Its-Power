
public class Test1 implements Runnable{
	private IntFunction intFunction;
	
	public Test1(IntFunction intFunction) {
		this.intFunction = intFunction;
	}
	
	public void run() {
		for(int i=1;i<11;i++) {
			intFunction.setInt(i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
}
