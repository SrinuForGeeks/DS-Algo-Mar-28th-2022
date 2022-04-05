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
		5! = 5 * fact(4)
				  4 * fact(3)
				  		3 * fact(2)
				  				2 * fact(1)
		Time Complexity  : O(n)
		Space Complexity : O(n)
	*/
	public int fact(int n)
	{
		if( n == 1)
		{
			return 1;
		}

		return n*fact(n-1);
	}
}

public class FactorialEx
{
	public static void main(String[] args) {
		Sample s = new Sample();
		System.out.println(" Fact (5) -> "+s.fact(5));
	}
}



















