package  task1;
import java.util.InputMismatchException;
import java.util.Scanner;
public class NumberGuessingGame{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=7;
		System.out.println("\n\n------------Welcome to Number Guessing game--------\n\n");
		System.out.println("	I've chosen number between 1 and 100\n\n	Try to guess it within"+n+" limit");
		int attempt=0;
		int min=1;
		int max=100;
		int sysguess=guessnum(min,max);
		int userguess;
		do {
			try {
				System.out.print("\nEnter your guess	: ");
				userguess=sc.nextInt();
				if(userguess>100 || userguess<1) {
					System.out.println("\nInvalid Number Enter between "+min+" and "+max);
				}
				else {
					if(userguess==sysguess) {
						System.out.println("\n\n______Yes ! Correct Guess______\n");
						break;
					}
					else if(userguess<sysguess) {
						 System.out.println("\nThe number is greater than " + userguess + ".");
					}
					else {
                        System.out.println("\nThe number is less than " + userguess + ".");
					}
				attempt++;
				}
			}
			catch (InputMismatchException e) {
				// TODO: handle exception
				 System.out.println("\nInvalid input. Please enter a valid integer.");
				 sc.nextLine();
			}
		} while (n!=attempt);
		if (attempt == n) {
            System.out.println("\n\nYou have exhausted all " + n + " attempts.");
            System.out.println("------The correct number was " + sysguess + ".------");
        }
    }
	private static int guessnum(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

		
	
}