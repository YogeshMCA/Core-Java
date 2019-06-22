
public class ArrayCons {

	public static void main(String[] args) {
					
		// Error - Array should be initialized
		String arr[];
		//arr[0]="Hai";
		
		//Array - Initialization 
		String init[] = new String[2];
		String arra[] = {"StringOne","StringTwo"};
		
		//Fixed Size
		String array[] = {"StringOne","StringTwo"};
		array[2] = "StringThree";
		System.out.println(array[2]); //ArrayIndexOutOfBoundsException

		passByRef(array);
		
		System.out.println(array[0]); //StringOneModified
	}
	
	public static void passByRef(String arr[]){
		arr[0]="StringOneModified";
	}

}