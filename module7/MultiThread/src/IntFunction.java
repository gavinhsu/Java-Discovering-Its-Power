
public class IntFunction {
	private Integer num = null;
	public synchronized void setInt(int i) {
			try {
				while(num != null) {
					notify();
					wait();
				}
			}
			catch(InterruptedException e) {	
			}
		num = i;
		notifyAll();
		}
	
	public synchronized Integer printInt() {
			try {
				while(num == null) {
					//System.out.println("rich fuck you");
					notify();
					wait();
				}
			}
			
			catch(InterruptedException e) {	
			}
			Integer temp = num;
			num = null;		
			notifyAll();
			return temp;
	}

}
