import java.util.Scanner;

public abstract class Payroll {
    private static Scanner scanner = new Scanner(System.in);

    public static Employee createNewEmployee() {
        System.out.println("Please input your name:");
        String firstName = scanner.nextLine();
        System.out.println("Please input your surname:");
        String lastName = scanner.nextLine();
        System.out.println("Please enter your annual salary:");
        String salary = scanner.nextLine();
        System.out.println("Please enter your super rate (%):");
        String superRate = scanner.nextLine();

        return new Employee(firstName, lastName, salary, superRate);
    }

    public static Payslip generatePayslip(Employee employee) {
        System.out.println("Period must be in whole months. Please enter a payment start date (DD/MM/YYYY):");
        String startDate = scanner.nextLine();
        System.out.println("Please enter a payment end date (DD/MM/YYYY):");
        String endDate = scanner.nextLine();
        System.out.println();

        return new Payslip(employee, startDate, endDate);
    }

}
