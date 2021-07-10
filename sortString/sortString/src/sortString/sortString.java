package sortString;
import java.io.*;
public class sortString {
	public static String swap(String s, int a, int b) 
	{
		char[] c = s.toCharArray();
		char temp = c[a];
		c[a] = c[b];
		c[b] = temp;
		String newS = new String(c);
		return newS;
	}
	
	public static void main(String [] argv) throws IOException
	{
		while(true) 
		{
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			String s = stdin.readLine();
			int sLeng = s.length();
			for (int i = 0; i < sLeng; i++) 
			{
				for(int j = i+1 ; j < sLeng ; j++) 
				{
					char a = s.charAt(i);
					String a2 = Character.toString(a);
					char b = s.charAt(j);
					String b2 = Character.toString(b);
					if(a2.compareToIgnoreCase(b2) > 0)
					{
						sortString Swap = new sortString();
						s = Swap.swap(s, i, j);
					}
				}
			}
			for (int i = 0; i < sLeng; i++) 
			{
				for(int j = i+1 ; j < sLeng ; j++) 
				{
					char a = s.charAt(i);
					String a2 = Character.toString(a);
					char b = s.charAt(j);
					String b2 = Character.toString(b);
					if(a2.compareToIgnoreCase(b2) == 0) 
					{
						if(a2.compareTo(b2) > 0)
						{
							sortString Swap = new sortString();
							s = Swap.swap(s, i, j);
						}
					}
				}
			}
			System.out.println(s);
		}
	}
}
