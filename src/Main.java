import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //deal with dates a bit better
        //add a default option for super rate
        //could possibly use enums for tax thresholds

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Welcome to the payslip generator!\n\n" + "Please input your name:");
        String firstName = myScanner.nextLine();
        System.out.println("Please input your surname:");
        String lastName = myScanner.nextLine();
        System.out.println("Please enter your annual salary:");
        String salary = myScanner.nextLine();
        System.out.println("Please enter your super rate (%):");
        String superRate = myScanner.nextLine();
        Employee newEmployee = new Employee(firstName, lastName, salary, superRate);

        System.out.println("Please enter a payment start date (DD/MM/YYYY):");
        String startDate = myScanner.nextLine();
        System.out.println("Please enter a payment end date (DD/MM/YYYY):");
        String endDate = myScanner.nextLine();
        System.out.println("");

        //change the super input
        //should round output digits in payslip function
        //payroll class will also be in charge of calculating stuff
        Payroll.getPayslip(newEmployee, startDate, endDate);
    }
}
