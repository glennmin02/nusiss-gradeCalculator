import java.util.Scanner;

public class gradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your Design grade: ");
        String designGrade = sc.nextLine();
        float designGPA = gradeToGPA(designGrade);

        System.out.print("Enter your Development grade: ");
        String devGrade = sc.nextLine();
        float devGPA = gradeToGPA(devGrade);

        System.out.print("Enter your Machine Learning grade: ");
        String mlGrade = sc.nextLine();
        float mlGPA = gradeToGPA(mlGrade);

        System.out.print("Enter your ASD grade: ");
        String asdGrade = sc.nextLine();
        float asdGPA = gradeToGPA(asdGrade);

        System.out.print("Enter your Mobile grade: ");
        String mobileGrade = sc.nextLine();
        float mobileGPA = gradeToGPA(mobileGrade);

        System.out.print("Enter your Capstone grade: ");
        String capstoneGrade = sc.nextLine();
        float capstoneGPA = gradeToGPA(capstoneGrade);

        float currentGPA = (designGPA + devGPA) / 2;
        float totalGPA = (designGPA + devGPA + mlGPA + asdGPA + mobileGPA + capstoneGPA) / 6;

        System.out.println("========================");
        System.out.printf("Your current GPA is: %.2f\n", currentGPA);
        System.out.println("========================");
        System.out.printf("Your predicted GPA is: %.2f\n", totalGPA);
        System.out.println("==Your Predicted Grade==");
        System.out.println("Design for " + designGrade);
        System.out.println("Development for " + devGrade);
        System.out.println("Machine Learning for " + mlGrade);
        System.out.println("ASD for " + asdGrade);
        System.out.println("Mobile for " + mobileGrade);
        System.out.println("Capstone for " + capstoneGrade);

        sc.close();
    }

    public static float gradeToGPA(String grade) {
        switch (grade.toLowerCase()) {
            case "c":
                return 2f;
            case "cpos":
            case "c+":
                return 2.5f;
            case "bneg":
            case "b-":
                return 3f;
            case "b":
                return 3.5f;
            case "bpos":
            case "b+":
                return 4f;
            case "aneg":
            case "a-":
                return 4.5f;
            case "a":
                return 5f;
            case "apos":
            case "a+":
                return 5f;
            default:
                return 5f;
        }
    }
}