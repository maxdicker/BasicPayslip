public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private double superRate;
    private String employeeNumber;

    private static final String orgCode = "MYOB";
    private static int totalEmployees = 0;

    public Employee(String firstName, String lastName, String salary, String superRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = Integer.parseInt(salary);
        this.superRate = Double.parseDouble(superRate)/100;
        this.employeeNumber = orgCode + ++totalEmployees;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public double getSuperRate() {
        return superRate;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }
}
