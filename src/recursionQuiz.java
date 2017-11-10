
public class recursionQuiz {
	
	import java.util.*;

	public static void main(String[] args){
		String restart ="y";
		while(!restart.equals("n")) {
			
		}
		String s = "AAABBBBBBBBB";
		String x = "AABBBBB";
		System.out.println(s);
		System.out.println(isLanguage(s));
		System.out.println(x);
		System.out.println(isLanguage(x));
		
	}
	public static boolean isLanguage(String s) {
		if(s.length() == 0) {
			return true;
		}
		if(s.charAt(0) == 'A' && s.charAt(s.length()-1) == 'B' && s.charAt(s.length()-2) == 'B' && s.charAt(s.length()-3) == 'B' ){
			return isLanguage(s.substring(1,s.length()-3));
		}
		else {
			return false;
		}
	}

}
