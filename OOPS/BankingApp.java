import java.util.Scanner;

class BankDetails {
	private String accno;
	private String name;
	private String acc_type;
	private long balance;
	Scanner sc = new Scanner(System.in);
	//Method to open new account
	public void openAccount() {
		System.out.println("Enter Account No : ");
		accno = sc.next();
		System.out.println("Enter Account Type : ");
		acc_type = sc.next();
		System.out.println("Enter Name : ");
		name = sc.next();
		System.out.println("Enter Balance");
		balance = sc.nextLong();
	}
	public void showAccount() {
		System.out.println("Name of account holder: " + name);
		System.out.println("Account no.: " + accno);
		System.out.println("Account type : " + acc_type);
		System.out.println("Balance : " + balance);
	}
	public void deposit() {
		long amt;
		System.out.println("Enter the amount you want to deposit : ");
		amt = sc.nextLong();
		balance = balance + amt;

	}
	public void withdrawal() {
		long amt;
		System.out.println("Enter the amount you want to withdraw: ");
		amt = sc.nextLong();
		if(balance >= amt){
			balance = balance - amt;
			System.out.println("Balance after withdraw : "+balance);
		}
		else {
			System.out.println("Your balance is less than "+amt+"\tTransaction failed....!!");

		}
	}
	public boolean search(String ac_no) {
		if(accno.equals(ac_no)) {
			showAccount();
			return (true);
		}
		return (false);
	}	

}

public class BankingApp {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		/*Create Initial Account 
			How many number of customes do you want to input?
			Enter Account No :
			Enter Account Type :
			Enter Name :
			Enter Balance :
		*/

		System.out.println("How many number of customes do you want to input?");
		int n = sc.nextInt();
		BankDetails C[] = new BankDetails[n];
		for(int i=0; i<C.length; i++) {
			C[i] = new BankDetails();
			C[i].openAccount();
		}

		/* ***Banking Application System***
			1. Display all account details
			2. Search by Account number
			3. Deposit the amount
			4. Withdraw the amount
			5. Exit
			Enter your choice:
		*/

		int ch;

		do {
			System.out.println("\n***Banking System Application***");
			System.out.println("1. Display all account details\n2. Search by Account number\n3. Deposit the amount\n4. Withdraw the amount\n5. Exit");
			System.out.println("Enter your choice: ");
			ch = sc.nextInt();

			switch(ch) {
			case 1:
				for(int i=0; i<C.length; i++) {
					C[i].showAccount();
				}
				break;
			case 2:
				System.out.println("Enter account mo. you want to search : ");
				String ac_no = sc.next();
				boolean found = false;
				for(int i=0; i<C.length; i++) {
					found = C[i].search(ac_no);
					if(found) {
						break;
					}
				}
				if(!found) {
					System.out.println("Search failed! Account doesn't exist...!!");
				}
				break;
			case 3:
				System.out.println("Enter Account no. : ");
				ac_no = sc.next();
				found = false;
				for(int i=0; i<C.length; i++) {
					found = C[i].search(ac_no);
					if(found) {
						C[i].deposit();
						break;
					}
				}
				if(!found) {
					System.out.println("Search failed! Account doesn't exist..!!");
				}
				break;
			case 4:
				System.out.println("Enter Account No. : ");
				ac_no = sc.next();
				found = false;
				for(int i=0; i<C.length; i++) {
					found = C[i].search(ac_no);
					if(found) {
						C[i].withdrawal();
						break;
					}
				}
				if(!found) {
					System.out.println("Search failed! Account doesn't exist..!!");
				}
				break;
			case 5:
				System.out.println("See you soon...");
				break;

			}

		}while(ch != 5);




	}
}