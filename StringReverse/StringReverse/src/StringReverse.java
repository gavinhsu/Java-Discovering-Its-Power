import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class StringReverse {

	public static void main(String[] args) throws IOException {
        
		while(true){
	        System.out.println("The word you want to reverse: ");
	        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	        String s = stdin.readLine();
	        String reversedWord = reverse(s);
	        System.out.println("The reversed string is: " + reversedWord);
		}

    }

    public static String reverse(String s)
    {
        if (s.isEmpty())
            return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }
		

}
