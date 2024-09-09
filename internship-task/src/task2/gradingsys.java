package task2;
import java.util.Scanner;
public class gradingsys {
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("-----------STUDENT GRADE CALCULATOR-----------\n\n");
		System.out.println("Enter marks obtained in each subject (out of 100):");
        int numSubjects = 5; 
        String[] sub= {"Tamil","English","Mathametics","Science","Social"};
        double[] marks = new double[numSubjects]; 
        double totalMarks = 0.0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print(sub[i]+" : ");
            marks[i] = sc.nextDouble(); 
            totalMarks += marks[i];
        }
        sc.close();
        
        double averagePercentage = totalMarks / numSubjects;

        
        char grade;
        if (averagePercentage >= 90) {
            grade = 'O';
        } else if (averagePercentage >= 80) {
            grade = 'A';
        } else if (averagePercentage >= 70) {
            grade = 'B';
        } else if (averagePercentage >= 60) {
            grade = 'C';
        } else if (averagePercentage >= 50){
            grade = 'D';
        }
        else {
        	grade = 'F';
        }

        // Display Results
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

	}
}
