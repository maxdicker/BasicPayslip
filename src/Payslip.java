import java.time.LocalDate;
import java.time.Period;

public class Payslip {
    private String slipNumber;
    private String employeeName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Period period;
    private long grossIncome;
    private long incomeTax;
    private long superannuation;

    public Payslip(Employee employee, String startDate, String endDate) {
        this.employeeName = employee.getName();
        this.startDate = Format.convertToDate(startDate);
        this.endDate = Format.convertToDate(endDate);
        this.slipNumber = employee.getEmployeeNumber() + this.endDate.getMonth();
        this.period = this.startDate.until(this.endDate.plusDays(1));

        this.grossIncome = scaleAmountForPeriod(employee.getSalary());
        this.incomeTax = scaleAmountForPeriod(Tax.calculateTax(employee.getSalary()));
        this.superannuation = scaleAmountForPeriod(calculateSuper(employee));

        System.out.println("Your payslip has been generated:\n");
    }

    @Override
    public String toString() {
        return "Name: " + employeeName + '\n' +
                "Pay period: " + Format.convertToReadableDate(startDate) + " - " + Format.convertToReadableDate(endDate) + '\n' +
                "Gross Income: " + grossIncome + '\n' +
                "Income Tax: " + incomeTax + '\n' +
                "Net Income: " + (grossIncome - incomeTax) + '\n' +
                "Super: " + superannuation + '\n' +
                "\nThank you for using MYOB!";
    }

    private long scaleAmountForPeriod (double amount) {
        return Math.round(amount * this.period.getMonths() / 12);
    }

    private static double calculateSuper (Employee employee) {
        return employee.getSuperRate() * employee.getSalary();
    }

}
