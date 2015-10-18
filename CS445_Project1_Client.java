import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/* CS 445 - Computer Architecture & Organization
 * File Name: CS445_Project1_Client.java
 * Project 1 - Due X/XX/XXXX
 * Instructor: Dr. Dan Grissom
 * 
 * Name: FirstName LastName
 * Name: FirstName LastName
 * Description: Insert your meaningful description for the CS445_Project1_Client client.
 */

///////////////////////////////////////////////////////////////////////////////
// INSTRUCTIONS: Update the header above with the correct due date,
// first/last name(s) and description for this specific project. You should also update
// the first/last name below in the "System.out.println" statement at the beginning
// of the "main()" method. Failure to do so will result in lost points. DO NOT change
// the name of the class or the autograder will give you 0 points.
//
// COLLABORATION: Students may work alone or with 1 (one) partner. AT NO POINT should you
// ever look at the code of your classmate's project OR show your code to help another
// classmate. If you need help, please ask your instructor, who is MORE THAN HAPPY to assist
// you and point you in the right direction.
//
// CHEATING: Your projects will be automatically and algorithmically checked for cheating
// by the online submission system. These algorithms are very good and will check against
// each of your classmate's submissions (in this section and other sections), projects that
// have been submitted in the past by previous students at this university and other
// universities, as well as content and code found on the internet. In short, if you cheat,
// EXPECT TO BE CAUGHT.
//
// Be aware that being caught for cheating can result in a 0% on the project for you AND the
// person that gave their code (it is your responsibility to not share your code, too). By the
// course breakdown, this will result in an automatic loss in 15% of your entire course grade.
//
// The instructor is available for help and there is NO REASON to take the risk in cheating.
///////////////////////////////////////////////////////////////////////////////
public class CS445_Project1_Client
{
	public static void main(String[] args)
	{
		// Your program should always output your name and the project number.
		// DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Josh Dubisz & Carson Hall");
		System.out.println("CS445 Project 1");
		System.out.println("");
		
		String[][] array = new String [160][4];
		for (String[] row : array)
		    Arrays.fill(row, "0");
		
		System.out.println(Arrays.deepToString(array));


		
		Scanner in = new Scanner(System.in);
		System.out.println("enter a string");
		String str = in.nextLine();
		
		// str is the input
		// use the spaces as delimeters
        int y = 0;
        
		StringTokenizer newstr = new StringTokenizer(str," ");
        while(newstr.hasMoreTokens()){
        	
	    	String temp = newstr.nextToken();
	    	int len = temp.length();
	    	int fillLine = len % 4;
	    	System.out.println(fillLine);
	    	if(fillLine != 0){
	    	while(fillLine < 4){
	    		temp = temp + '$';
	    		fillLine++;
	    	}
	    	}
            System.out.println(temp);
            int lines = len/4;
            //lines is the amount of lines we need for each word
            //array[y][x]
            int ch = 0;
            int positionOfInput = 0;
            
            while(y <= lines){
            	for(int x = 0; x < 4; x++){
            		char c = temp.charAt(positionOfInput);
            		array[y][x] = Character.toString(c);
            		positionOfInput++;
            	}
            	y++;
            }
        }
        
		System.out.println(Arrays.deepToString(array));

		///////////////////////////////////////////////////////////////////////
		// Your code should go below these comments.
		//
		// See the "User Interface Requirements - Details" section (with
		// steps 1-4, including all sub-steps) of the project description
		// for a description of the program flow that should be found here.
		//
		// When done, your console output should look similar to that seen in the
		// "User Interface Requirements - Sample Console Input/Output" section of
		// the project description.

	}
}