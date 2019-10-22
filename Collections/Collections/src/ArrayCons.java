

public class ArrayCons{

	
	public static void main(String[] args) {

		
		
		
		int N = 4;
		int s= 3;
		int k=0;
		int x = N*2;
		for(int i =1;i<=x;i++){
			for(int j=1;j<=i-k;j++){
				System.out.print(s);
			}
			if(i>N){
				s--;
				k = k+2;
			}
			else if(i!=N){
				s++;
			}else{
				k++;
			}
			System.out.println();
		}
		
		
		
		
		
		// Error - Array should be initialized
		String arr[];
		//arr[0]="Hai";
		
		//Array - Initialization 
		String init[] = new String[2];
		String arra[] = {"StringOne","StringTwo"};
		
		//Fixed Size
		String array[] = {"StringOne","StringTwo"};
		//array[2] = "StringThree";
		//System.out.println(array[2]); //ArrayIndexOutOfBoundsException

		passByRef(array);
		
		System.out.println(array[0]); //StringOneModified
	}
	
	public static void passByRef(String arr[]){
		//arr[0]="StringOneModified";
	}

}




