/*


n = 5 ;
	5 * 4 * 3 * 2 * 1 = 120
Time Complexity : O(n)
Space Complexiyt: O(1)
int fact = 1;
while(n > 1)
{
	fact = fact * n;
	n--;
}

*/
class Sample
{
	/*	
		5 = printNumber(5)n:5
				 printNumber(4)n:4
				 		printNumber(3) n:3
				 				printNumber(2)n:2
				 						printNumber(1)n:1
				 								printNumber(0) n:0

		Time Complexity  : O(n)
		Space Complexity : O(n)
	*/
	public void printNumber(int n)
	{
		if( n == 0)
		{
			return;
		}

		printNumber(n-1);

		System.out.println(n);
		 
	}
}

public class PrintNumberEx
{
	public static void main(String[] args) {
		Sample s = new Sample();
		s.printNumber(5);
	}
}



















