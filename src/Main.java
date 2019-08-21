public class Main {

    /*  Ideas for further development:
        - add default super rate as an option
        - more precise currency handling.
        Different data types. Tax thresholds and rates as enums or key-value pairs?
        - better management of user input, error handling
        - incorporate tests
        - managers/repositories of employees and payslips
    */

    public static void main(String[] args) {

        System.out.println("Welcome to the payslip generator!\n");
        Employee newEmployee = Payroll.createNewEmployee();

        System.out.println(Payroll.generatePayslip(newEmployee));

    }
}
