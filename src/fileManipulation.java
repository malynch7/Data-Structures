import java.io.*;
import java.util.*;
public class fileManipulation {

	
	public static void main(String[] args) {
        File inFile = new File("d:\\test.txt");
        String input = null;
        try
        {
          Scanner fileinput = new Scanner(inFile);
          int lineCount = 0;
          int wordCount = 0;
          int sentenceCount = 0;
          while(fileinput.hasNext()) {
        	  lineCount ++;
              input = fileinput.nextLine();
              for(int i = 0; i < input.length();i++)
            	  if(input.charAt(i)==('!'|'.'|'?')) {
            		  sentenceCount ++;
            	  }
              StringTokenizer t = new StringTokenizer(input);
              wordCount += t.countTokens();
              System.out.println(input);
          }
          fileinput.close();
          System.out.println("Line Count: " + lineCount + "\nWord Count: " + wordCount + "\nSentence Count: " + sentenceCount);
        }catch(FileNotFoundException e){
          System.out.println(e);
          System.exit(1);
        }
       // FileWriter fw = new FileWriter();
	}
}
