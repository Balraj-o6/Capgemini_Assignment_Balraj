package interest_calculator;

import java.util.Scanner;

public class InterestCalculatorApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		int ch;
		
		do {
			System.out.println("1. Interest Calculator –SB");
			System.out.println("2. Interest Calculator –FD");
			System.out.println("3. Interest Calculator –RD");
			System.out.println("4. Exit");
			System.out.print("Enter Choice: ");
			
			ch = sc.nextInt();
			sc.nextLine();
			try {
			switch (ch) {
			case 1:
				System.out.println("Enter Amount: ");
				double sa = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter the Account type(Normal/NRI): ");
				String at = sc.nextLine();
				Account sb = new SBAccount(sa, at);
				System.out.println(sb.calculateInterest());
				break;
			case 2:
				System.out.println("Enter Amount: ");
				double fa = sc.nextDouble();
				System.out.println("Enter No. of Days: ");
				int d = sc.nextInt();
				System.out.println("Enter age of Acc.Holder: ");
				int ag = sc.nextInt();
				Account fd = new FDAccount(fa,d,ag);		
				System.out.println(fd.calculateInterest());
				break;
			case 3:
				System.out.println("Enter the monthly amount:");
                double rdAmt = sc.nextDouble();
                System.out.println("Enter number of months:");
                int months = sc.nextInt();
                System.out.println("Enter your age:");
                int rdAge = sc.nextInt();

                RDAccount rd = new RDAccount(rdAmt, months, rdAge);
                System.out.println("Interest gained is: " + rd.calculateInterest());
                break;
			case 4:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice");
			}
			}catch (InvalidInputException e) {
				System.out.println(e.getMessage());
			}
			
		}while(ch != 4);
		
		sc.close();
	}
}
