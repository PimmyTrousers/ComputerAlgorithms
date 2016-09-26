public class Homework4 {

	/***
	 * determines if an input array is of the format where the first n values
	 *  are false and the second n values are true for all n >= 0
	 * @param b array of booleans
	 * @return true if the Boolean array contains n false values followed by 
	 *    n true values for all n >= 0
	 */
	public static boolean StackChecker(boolean [] b) {

		// variable declarations
		int lowToMid = b.length/2;
		int midToHigh = b.length;
		int falseCount = 0;
		int trueCount = 0;
	java.util.Stack
		// checks if the first elem is true then return false
		if(b[0]==true){
			return false;
		}


		System.out.println(lowToMid);
		System.out.println(midToHigh);

		// loops through the first half of the array and checks for false values
		for(int i = 0; i < lowToMid; i++){
			if(b[i]==false){
				falseCount++;
			}
			if(b[i]==true){
				return false;
			}
		}

		// loops through the second half of the array and hcecks for true values
		for(int i = lowToMid; i < midToHigh; i++){
			if(b[i]==true){
				trueCount++;
			}
			if(b[i]==false){
				return false;
			}

		}

		// checks if the 2 sets are even
		if(trueCount == falseCount){
			return true;
		}
		return false;
		
	}
	
}
