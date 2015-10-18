
public class CS445Project1HelperCode
{

	public static void main(String[] args)
	{
		byte [][] memory = new byte[2][4]; 	// Memory with 2 rows of 4 columns of bytes:
											// byte byte byte byte
											// byte byte byte byte
		
		// Look at an example integer
		int intVal = 23403294; // 0x0165 1B1E
		System.out.println("Original integer (" + intVal + ") in hex: 0x" + Integer.toHexString(intVal));
		
		int intCopy = intVal;  // Make copy for manipulation
		
		// Break the 4-byte integer into its parts to store in the small memory
		memory[0][3] = (byte)intVal;		// Cast (will save lowest-order byte)
		intVal = intVal >> 8; 				// Shift 8-bits (1 byte) to right 
		memory[0][2] = (byte)intVal; // Cast (will save lowest-order byte)
		intVal = intVal >> 8; 				// Shift 8-bits (1 byte) to right
		memory[0][1] = (byte)intVal; // Cast (will save lowest-order byte)
		intVal = intVal >> 8; 				// Shift 8-bits (1 byte) to right
		memory[0][0] = (byte)intVal; // Cast (will save lowest-order byte)
		
		// Print out hex values of the 4 bytes
		System.out.print("Individual bytes in hex: ");
		for (byte b : memory[0])
			System.out.print(Integer.toHexString(b) + "    ");

		// Print out decimal values of the 4 bytes
		System.out.print("\nIndividual bytes in decimal: ");
		for (byte b : memory[0])
			System.out.print(b + "    ");		
	}
}
