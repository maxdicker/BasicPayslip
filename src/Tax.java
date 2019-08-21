public abstract class Tax {
    private static final int firstThreshold = 18200;
    private static final double firstRate = 0;
    private static final int secondThreshold = 37000;
    private static final double secondRate = 0.19;
    private static final int thirdThreshold = 87000;
    private static final double thirdRate = 0.325;
    private static final int fourthThreshold = 180000;
    private static final double fourthRate = 0.37;
    private static final double fifthRate = 0.45;

    public static double calculateTax (int salary) {
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
}
