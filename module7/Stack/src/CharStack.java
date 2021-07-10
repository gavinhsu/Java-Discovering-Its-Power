import java.io.*;
import java.util.Arrays;

public class CharStack {
	//initiate array
	private char[] m_data; 
	private int m_ptr;
	
	public CharStack(int size) {
		m_ptr = 0;  //index in array
		m_data = new char[(size > 1 ? size : 10)];  //if size > 1 then return size else return 10
	}
	
	public void push(char c) {
		if(m_ptr >= m_data.length) {
			//Grow the array automatically
			char[] tmp = new char[m_data.length * 2];
			//System.arraycopy(sourceArray, startIndexFromSource, targetArray, startIndexFromTarget, copyLength)
			//Copy to tmp
			System.arraycopy(m_data, 0, tmp, 0, m_data.length); //System.arraycopy(sourceArray, startIndexFromSource, targetArray, startIndexFromTarget, copyLength)
			m_data = tmp;
		}
		m_data[m_ptr++] = c;
	}
	

	public char pop(){
		return m_data[--m_ptr];
	}
	
	
	public boolean hasMoreElements() {
		return(m_ptr != 0);
	}
	
	
	public static void main(String[] argv) throws IOException{
			CharStack stack = new CharStack(10);

			try {
				stack.push('c');
				stack.push('b');
				stack.push('a');
				for(int i=0 ; i<10; i++) {
					System.out.println(stack.pop());
				}
			}
			catch (ArrayIndexOutOfBoundsException outOfBounds) {
				System.out.println("Stack Underflow!");
			}
			
		
	}
	

}
