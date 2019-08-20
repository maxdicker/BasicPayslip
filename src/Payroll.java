import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Payroll {
    private static final int firstThreshold = 18200;
    private static final double firstRate = 0;
    private static final int secondThreshold = 37000;
    private static final double secondRate = 0.19;
    private static final int thirdThreshold = 87000;
    private static final double thirdRate = 0.325;
    private static final int fourthThreshold = 180000;
    private static final double fourthRate = 0.37;
    private static final double fifthRate = 0.45;

    public static void getPayslip (Employee employee, String startDate, String endDate) {

        Period payslipPeriod = calculatePeriod(convertToDate(startDate), convertToDate(endDate));

        System.out.println("Your payslip has been generated:\n\n" +
                "Name: " + employee.getName() + "\n" +
                "Pay period: " + convertToReadableDate(convertToDate(startDate)) + " - " + convertToReadableDate(convertToDate(endDate)) + "\n" +
                "Gross Income: " + scaleAmountForPeriod(employee.getSalary(), payslipPeriod) + "\n" +
                "Income Tax: " + scaleAmountForPeriod(calculateTax(employee.getSalary()), payslipPeriod) + "\n" +
                "Net Income: " + (scaleAmountForPeriod(employee.getSalary(), payslipPeriod) - scaleAmountForPeriod(calculateTax(employee.getSalary()), payslipPeriod)) + "\n" +
                "Super: " + scaleAmountForPeriod(calculateSuper(employee.getSuperRate(), employee.getSalary()), payslipPeriod) + "\n" +
                "\nThank you for using MYOB!");

    }

    private static LocalDate convertToDate (String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu", Locale.ENGLISH);
        return LocalDate.parse(date, formatter);
    }

    private static String convertToReadableDate (LocalDate date) {
        return date.getDayOfMonth() + " " + date.getMonth() + " " + date.getYear();
    }

    private static Period calculatePeriod (LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate.plusDays(1));
    }

    //not sure if rounds months or only whole months
    private static int scaleAmountForPeriod (double amount, Period period) {
        return (int) Math.round(amount * period.getMonths() / 12);
    }

    private static double calculateTax (int salary) {
        double tax = 0;

        if (salary > firstThreshold) {
            tax += ((salary - firstThreshold) * (secondRate - firstRate));

            if (salary > secondThreshold) {
                tax += ((salary - secondThreshold) * (thirdRate - secondRate));

                if (salary > thirdThreshold) {
                    tax += ((salary - thirdThreshold) * (fourthRate - thirdRate));

                    if (salary > fourthThreshold) {
                        tax += ((salary - fourthThreshold) * (fifthRate - fourthRate));
                    }
                }
            }
        } else {
            tax += salary * firstRate;
        }

        return tax;
    }

    private static double calculateSuper (double superRate, int salary) {
        return superRate * salary;
    }

}
