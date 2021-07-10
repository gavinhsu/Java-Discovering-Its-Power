public class IntHolder {
	public static void main(String args[]) {
		IntFunction intfunction = new IntFunction();
		Thread test1 = new Thread(new Test1(intfunction));
		test1.start();
		Thread test2 = new Thread(new Test2(intfunction));
		test2.start();
	}
}

