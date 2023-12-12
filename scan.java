//Java uses the Scanner class found in java.util package to get user input. You have to import the package to use the Scanner class.
import java.util.Scanner;

class Codechef
{
	public static void main (String[] args)
	{
		// your code goes here
    //To use the Scanner class, you have to create an object of the class and use any of the methods to read string, numbers etc.
		Scanner objName = new Scanner(System.in);
    //The method nextLine() is used to read a line of text from input and return it in string format. The following line will read a string input from user
		String varName = objName.nextLine();
		System.out.println(varName);
	}
}
