package interest_calculator;

class SBAccount extends Account {

    private String accountType; // Normal or NRI

    public SBAccount(double amount, String accountType) {
        this.amount = amount;
        this.accountType = accountType;
    }

    @Override
    double calculateInterest() throws InvalidInputException {

        if (amount < 0) {
            throw new InvalidInputException("Invalid amount. Please enter correct values.");
        }

        if (accountType.equalsIgnoreCase("Normal")) {
            interestRate = 4;
        } else if (accountType.equalsIgnoreCase("NRI")) {
            interestRate = 6;
        } else {
            throw new InvalidInputException("Invalid account type.");
        }

        return amount * interestRate / 100;
    }
}