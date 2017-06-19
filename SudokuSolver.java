import java.util.*;
import java.io.*;
import java.nio.charset.Charset;

public class SudokuSolver {
	
	private static void getinput(File file) throws IOException{
		BufferedReader reader = new BufferedReader(
			    new InputStreamReader(
			        new FileInputStream(file),
			        Charset.forName("UTF-8")));
			int c;
			
			//flag is used to determine if a point is empty or not
			//two consecutive ;'s indicate that a point is empty 
			int i=0,j=0,flag=0,n;
			
			//we read each character and store it in the correct point of our array
			while((c = reader.read()) != -1) {
			  char character = (char) c;
			  if (character == ';'){
				  if (flag == 0){
					  flag = 1;
				  }
				  else {
				  }
				  j++;
			  }
			  else if(c == '\n'){
				  flag = 0;
				  i++;
				  j = 0;
			  }
			  else {
				  n = Character.getNumericValue(character);
				  SudokuTable.add(n,i,j);
			  }
			}
	}
	
	public static void main(String[] args) throws IOException{
		
		File inputfile = null;
		if (0 < args.length){
			inputfile = new File(args[0]);
		}
		else{
			System.err.println("Invalid arguments count:" + args.length);
			System.exit(1);
		}
		getinput(inputfile);
		//if we find a solution, then print it
		//else print message
		if (SudokuTable.solve()){
			SudokuTable.printTable();		
		}
		else {
			System.out.print("No Solution for this input\n");
			SudokuTable.printTable();
		}
	}
}
