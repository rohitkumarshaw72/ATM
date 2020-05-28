import java.util.*;
import java.io.*;
public class ATM {
	public static void main(String args[]) {
		long balance=0, withdrawl, deposit;
		int ch, i=0,n=0, pin;
		char txn = 'y';
		int note[] = new int[4]; int pinarr[] = new int[4];
		System.out.print("Enter your 4 digit PIN: \t");
		Scanner s = new Scanner(System.in);
		pinarr[0]= s.nextInt(); pinarr[1]= s.nextInt(); pinarr[2]= s.nextInt(); pinarr[3]= s.nextInt();
		pin = (pinarr[0]*1000) + (pinarr[1]*100) + (pinarr[2]*10) + pinarr[3];
		if(pin != 6789){
			i++;
			while(pin != 6789 && i<3)	{
				System.out.print("Please enter valid PIN: \t");
				pinarr[0]= s.nextInt(); pinarr[1]= s.nextInt(); pinarr[2]= s.nextInt(); pinarr[3]= s.nextInt();
				pin = (pinarr[0]*1000) + (pinarr[1]*100) + (pinarr[2]*10) + pinarr[3];
				if(pin != 6789) {i++;}
			}
			if(i >= 2 && pin != 6789) { 
				System.out.println("Dear User, \n\r You have 3 incorrect attempts. Sorry! \n\rThank you for using our ATM services!\n\r \n\r"); 
				System.exit(1);
			}
		}
		do	{
			System.out.print("**** Welcome to our ATM Services **** \n\r 1. Balance Enquiry \n\r 2. Cash Withdrawl \n\r 3. Cash Deposit \n\r 4. Exit \n\r\n\r Enter your choice: ");
			ch = s.nextInt();
			switch(ch)	{
				case 1:	System.out.print("Your Account Balance is:  Rs. "+balance+"\n\r\n\r");
						break;
				case 2:	System.out.print("Enter the amount you wish to withdrawl:  Rs. ");
						withdrawl = s.nextLong();
						if((withdrawl <= 0) || (withdrawl > balance) || ((withdrawl % 100) != 0) || (withdrawl > 20000))
							System.out.print("Operation failed! \n");
						else	{
							balance = balance - withdrawl;
						
							//To determine no. of different notes...
							while(withdrawl >= 2000) {
        						note[0]++;
        						withdrawl = withdrawl - 2000;
    						}
    						while(withdrawl >= 500){
        						note[1]++;
        						withdrawl = withdrawl - 500;
   							}
    						while(withdrawl >= 200){
        						note[2]++;
        						withdrawl = withdrawl -200;
    						}
    						while(withdrawl >= 100){
        						note[3]++;
       	 						withdrawl = withdrawl - 100;
    						}
    						System.out.print("No. of 2000 rupees note: "+note[0]+"\n\r");
    						System.out.print("No. of 500 rupees note: "+note[1]+"\n\r");
    						System.out.print("No. of 200 rupees note: "+note[2]+"\n\r");
							System.out.print("No. of 100 rupees note: "+note[3]+"\n\r");
						
							System.out.print("Please collect your Cash \n\r Do you want to display your current balance?(y/n): ");
							//fflush(stdin);
							txn = s.next().charAt(0);
							if(txn == 'n' || txn == 'N')
								n=1;
							else if(txn == 'y' || txn == 'Y')
								System.out.print("Your Account Balance is:  Rs. "+balance+"\n\r\n\r");
						}
						break;
				case 3:	System.out.print("Enter the amount you wish to deposit in your account:  Rs. ");
						deposit = s.nextLong();
						if(deposit <= 0 || ((deposit % 100) != 0))
							System.out.print("Operation failed! \n");
						else {
							balance += deposit;
							System.out.print("Do you want to display your current balance?(y/n): ");
							//fflush(stdin);
							txn = s.next().charAt(0);
							if(txn == 'n' || txn == 'N')
								n=1;
							else if(txn == 'y' || txn == 'Y')
								System.out.print("Your Account Balance is:  Rs. "+balance+"\n\r\n\r");
						}
						break;
				case 4:	System.out.print("Thank you for using our ATM services!");
						System.exit(1);
				default:	System.out.print("INVALID CHOICE! \n\r");
			}
			n=0;
			System.out.print("Do you want to have another transaction?(y/n): ");
			//fflush(stdin);
			txn = s.next().charAt(0);
			if(txn == 'n' || txn == 'N')
				n=1;
		}while(n == 0);
		System.out.print("***** Thank you for using our ATM services *****");
	}
}