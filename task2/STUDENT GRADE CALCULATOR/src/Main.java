import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int subjects = scanner.nextInt();
        double totalMarks = 0;

        for (int i = 1; i <= subjects; i++ ){
            System.out.println("Enter marks for subject " + i + ": ");
            double marks = scanner.nextInt();
            totalMarks += marks;
        }

        double averagePercentage = totalMarks / subjects;
        System.out.print("Total Marks: "+ totalMarks);
        System.out.printf("Average Percentage: %.2f%% %n" , averagePercentage);

        char grade ;
        if(averagePercentage >= 90){
            grade = 'A';
        }else if(averagePercentage >= 80){
            grade = 'B';
        }else if (averagePercentage >= 70){
            grade ='C';
        }else if (averagePercentage >= 60){
            grade = 'D';
        }else {
            grade = 'F';
        }
        System.out.println("Grade: " + grade);

        scanner.close();
    }

}