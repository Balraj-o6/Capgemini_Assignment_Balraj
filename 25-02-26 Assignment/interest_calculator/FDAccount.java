package interest_calculator;

class FDAccount extends Account {

    private int noOfDays;
    private int ageOfACHolder;

    public FDAccount(double amount, int noOfDays, int age) {
        this.amount = amount;
        this.noOfDays = noOfDays;
        this.ageOfACHolder = age;
    }

    @Override
    double calculateInterest() throws InvalidInputException {

        if (amount < 0 || noOfDays < 0 || ageOfACHolder < 0) {
            throw new InvalidInputException("Invalid Number of days. Please enter correct values.");
        }

        // Amount < 1 crore
        if (amount < 10000000) {

            if (noOfDays >= 7 && noOfDays <= 14)
                interestRate = (ageOfACHolder >= 60) ? 5.00 : 4.50;

            else if (noOfDays >= 15 && noOfDays <= 29)
                interestRate = (ageOfACHolder >= 60) ? 5.25 : 4.75;

            else if (noOfDays >= 30 && noOfDays <= 45)
                interestRate = (ageOfACHolder >= 60) ? 6.00 : 5.50;

            else if (noOfDays >= 46 && noOfDays <= 60)
                interestRate = (ageOfACHolder >= 60) ? 7.50 : 7.00;

            else if (noOfDays >= 61 && noOfDays <= 184)
                interestRate = (ageOfACHolder >= 60) ? 8.00 : 7.50;

            else if (noOfDays >= 185 && noOfDays <= 365)
                interestRate = (ageOfACHolder >= 60) ? 8.50 : 8.00;

            else
                throw new InvalidInputException("Invalid Number of days. Please enter correct values.");
        }

        // Amount >= 1 crore
        else {

            if (noOfDays >= 7 && noOfDays <= 14)
                interestRate = 6.50;
            else if (noOfDays >= 15 && noOfDays <= 29)
                interestRate = 6.75;
            else if (noOfDays >= 30 && noOfDays <= 45)
                interestRate = 6.75;
            else if (noOfDays >= 46 && noOfDays <= 60)
                interestRate = 8.00;
            else if (noOfDays >= 61 && noOfDays <= 184)
                interestRate = 8.50;
            else if (noOfDays >= 185 && noOfDays <= 365)
                interestRate = 10.00;
            else
                throw new InvalidInputException("Invalid Number of days. Please enter correct values.");
        }

        return amount * interestRate / 100;
    }
}
