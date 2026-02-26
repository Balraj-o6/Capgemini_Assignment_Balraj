package interest_calculator;

class RDAccount extends Account {

    private int noOfMonths;
    private double monthlyAmount;
    private int ageOfACHolder;

    public RDAccount(double monthlyAmount, int noOfMonths, int age) {
        this.monthlyAmount = monthlyAmount;
        this.noOfMonths = noOfMonths;
        this.ageOfACHolder = age;
    }

    @Override
    double calculateInterest() throws InvalidInputException {

        if (monthlyAmount < 0 || noOfMonths <= 0) {
            throw new InvalidInputException("Invalid input values.");
        }

        // Rate selection
        if (noOfMonths == 6)
            interestRate = (ageOfACHolder >= 60) ? 8.00 : 7.50;
        else if (noOfMonths == 9)
            interestRate = (ageOfACHolder >= 60) ? 8.25 : 7.75;
        else if (noOfMonths == 12)
            interestRate = (ageOfACHolder >= 60) ? 8.50 : 8.00;
        else if (noOfMonths == 15)
            interestRate = (ageOfACHolder >= 60) ? 8.75 : 8.25;
        else if (noOfMonths == 18)
            interestRate = (ageOfACHolder >= 60) ? 9.00 : 8.50;
        else if (noOfMonths == 21)
            interestRate = (ageOfACHolder >= 60) ? 9.25 : 8.75;
        else
            throw new InvalidInputException("Invalid number of months.");

        double totalAmount = monthlyAmount * noOfMonths;
        return totalAmount * interestRate / 100;
    }
}
