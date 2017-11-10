import java.util.*;

public class Quiz2 {
	
	public static void main(String[] args) {
		String restart = "y";
		Scanner input = new Scanner(System.in);
		while(!restart.equals("n")) {
			System.out.print("Input test string: ");
			System.out.println(isLanguage(input.nextLine()));
			System.out.println("Enter new test string? (y/n)");
			restart = input.nextLine();
			System.out.println();
		}
	}

	public static boolean isLanguage(String s) {
		if(s.length() == 0) {
			return true;
		}
		if(s.charAt(0) == 'A' && s.charAt(1) == 'A' && s.charAt(s.length()-1) == 'B' ){
			return isLanguage(s.substring(2,s.length()-1));
		}
		else {
			return false;
		}
	}
}
