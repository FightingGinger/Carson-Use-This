import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* CS 445 - Computer Architecture & Organization
 * File Name: BigEndianMemorySystem.java
 * Project 1 - Due 10/18/2015
 * Instructor: Dr. Dan Grissom
 * 
 * Name: Josh Dubisz
 * Name: Carson Hall
 * Description: Insert your meaningful description for the BigEndianMemorySystem class.
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

public class BigEndianMemorySystem
{
	///////////////////////////////////////////////////////////////////////
	// YOU MAY ADD ANY ADDITIONAL METHODS OR MODIFY THE ONES BELOW. THE 
	// METHOD TEMPLATES FOUND IN THIS FILE ARE JUST TO HELP YOU GET STARTED
	// AND UNDERSTAND THE REQUIRMENTS DETAILED IN THE PROJECT DESCRIPTION.
	///////////////////////////////////////////////////////////////////////
	
	//creates a byte array to mimic the memory
	private byte[][] memory  = new byte[20][4];
	
	// Constructor (you may modify this as you see fit)
	BigEndianMemorySystem()
	{
		//Fills the memory variable with zeros (yo)
		for(int row = 0; row < 20; row++)
		{
			for(int col = 0; col < 4; col++)
			{
				memory[row][col] = 0;
			}
		}
	}

	///////////////////////////////////////////////////////////////////////
	// Method to receive raw data from a little endian system (HINT: You may
	// want to take in a parameter of a 1D or 2D byte array.) You cannot 
	// pass anything other than raw data (no helper variables). This method
	// will receive the raw bytes and convert it to it's own system, overwriting
	// it's internal memory.
	public void receiveRawBytesFromLittleEndianMem(byte[][] littleEndian)
	{
		
	}
	
	///////////////////////////////////////////////////////////////////////
	// Gets a copy of the raw bytes (should be instance variable) and returns
	// it to caller. See above comment for hint on what data type would be best
	public Object getRawBytes()
	{
		return null;
	}
	
	///////////////////////////////////////////////////////////////////////
	// Prints the raw data to the console as described in the project
	// description
	public void printRawBytes()
	{
		for (int row = 0; row < memory.length;row++)
		{
			System.out.print("A" + (row * 4) + ": ");
			System.out.print("[");
			//System.out.println();
			for(int col = 0; col < memory[row].length;col++)
			{
				System.out.print("[" + String.format("%02X", memory[row][col]) + "]"); //Outputs the hex
				
			}
//			System.out.println();
//			for (int col = 0; col < memory[row].length;col++)
//			{
//				System.out.print("[" + Integer.parseInt(Byte.toString(memory[row][col]), 16) + "]"); //Outputs the integer
//			}
			
			System.out.print("]");
			System.out.println();
		}
	}
	
	//Method called by client... Redirects to proper method depending on isInt flag
	public void addData(String data, int row, boolean isInt)
	{
		if(isInt)
		{
			addIntData(Integer.parseInt(data), row);
		}
		else if(!isInt)
		{
			addStringData(data, row);
		}
	}
	
	//TODO Put flags in memory to differentiate between Strings and ints
	//For characters, data is stored from right to left
	private void addStringData(String data, int row)
	{
		int actualRow = row / 4; //converts the row entered by the user to the real row used by the array to mimic memory
		int col = 3; //0-3 position of the row
		byte[] rawData = data.getBytes(); //Converts data entered by user into a byte array
		
		//Goes through the users input character by character and inputs it into the correct memory location
		for (byte character: rawData)
		{
			//if position < 0, resets it to zero. Memory only goes 0-3
			if (col < 0)
			{
				col = 3;
				actualRow++; //goes up to next row when memory runs out of slots
			}
				
			memory[actualRow][col] = character; //Commits temp to memory
			col--; //Goes to next column
		}		
	}
	
	//Same as above, but stores int data instead... 
	//For Big Endian, data is stored from left to right
	private void addIntData(int data, int row)
	{
		int actualRow = row / 4; //converts the row entered by the user to the real row used by the array to mimic memory
		int col = 0; //0-3 position of the row
		String hex = Integer.toHexString(data); //Converts user input into a string of hex characters
		int numberOfHexCharacters = (int) Math.ceil((double)hex.length() / 2); //number of hex pairs... divides by 2 because I'm pairing them...
		int dataCopy = data; //stores users int as a copy
		byte[] byteStorage = new byte[numberOfHexCharacters];
		
		//Stores the hex into a byte array
		for(int i = 0; i < byteStorage.length; i++)
		{
			byteStorage[i] = (byte)dataCopy;
			dataCopy = dataCopy >> 8; //Shifts data 8 bits to the right
		}		
		
		//Goes through the input byte array and inputs it into the correct memory location
		for(byte unit : byteStorage)
		{
			//if position >= 4, resets it to zero. Memory only goes 0-3
			if (col >= 4)
			{
				col = 0;
				actualRow++; //goes up to next row when memory runs out of slots
			}
				
			memory[actualRow][col] = unit; //Commits temp to memory
			col++; //Goes to next column
		}		
	}
}
