
public class ATM {
	
	private int total;
	private Account[] Accounts;
	private int a;
	private int option;
	
	public ATM(){
		this.total= 200000;
		this.a=-1;
		this.option = -1;
		
		Accounts = new Account[8];
		Accounts[0]= new Account("barr",5656,2000.00);
		Accounts[1]= new Account("dickson",1234,350.00);
		Accounts[2]= new Account("dragon",3415,500.00);
		Accounts[3]= new Account("erkan",1212,900.12);
		Accounts[4]= new Account("prestopnik",1004,760.00);
		Accounts[5]= new Account("stansfield",4321,400.03);
		Accounts[6]= new Account("turnbull",8888,1500.0);
		Accounts[7]= new Account("Admin",0000,0.0);
	}
	
	public boolean login(){
		StdOut.println("\nWelcome to Northern Bank and Trust");
		StdOut.println("Please Login");
		
		while(true){
			StdOut.println("\nUsername: ");
			String un = StdIn.readString();
			
			//check username 
			for (int i=0; i<Accounts.length; i++){
				if(Accounts[i].getUname().equals(un)){
					StdOut.println("Pin Number: ");
					int p = StdIn.readInt();
					//check pin
					if(Accounts[i].getPin()==p){
						StdOut.println("Logged In As: "+un);
						
						//admin login shuts down program
						if (Accounts[i].getUname().equals("Admin")){
							StdOut.println("***Logging out of ATM and Shutting Down***");
							return false;
						}else{
							a = i;
							run();
						}
					}else{
						StdOut.println("Pin Incorrect");
					}
				}
			}
			StdOut.println("Not a Valid Username");
		}
	}
	
	
	public int getMenu(){
		StdOut.println(" 1) Check Balance");
		StdOut.println(" 2) Make Deposit");
		StdOut.println(" 3) Make Withdrawal");
		StdOut.println(" 4) Logout");
		StdOut.println("\nSelect Option (1-4): ");
		int x= StdIn.readInt();
		return x;
	}

	public void run(){
		StdOut.println("\nWelcome to Northern Bank and Trust ATM");
		option=getMenu();
		while(true){
			if (option == 1){
				//check balance of the account logged into
				StdOut.println("Current Balance: "+Accounts[a].getBalance());
				option = getMenu();
			}else if (option==2){
				//Deposit to Account and ATM
				StdOut.println("Amount to Deposit: ");
				int MoneyInput = StdIn.readInt();
				Accounts[a].deposit(MoneyInput);
				//Deposit money into ATM
				moneyIn(MoneyInput);
				StdOut.println(MoneyInput+ " Deposited");
				option = getMenu();
			}else if (option==3){
				//Withdraw from Account and ATM
				StdOut.println("Amount to Withdraw: ");
				int MoneyOutput = StdIn.readInt();
				//Withdraw money from ATM
				moneyOut(MoneyOutput);
				Accounts[a].withdraw(MoneyOutput);
				StdOut.println("Current Balance: "+Accounts[a].getBalance()+"\n");
				option = getMenu();
			}else if (option==4){
				//log out of ATM
				StdOut.println("***Logging out of ATM***");
				a=-1;
				option=-1;
                return;
			}else {
				StdOut.println("Invalid Option");
				option = getMenu();
			}
		}
	}
	
	public int moneyIn(int cashIn){
		return total = total + cashIn;
		
	}
	
	public int moneyOut(int cashOut){
		if (cashOut>total){
			System.out.println("Not Enough Money in ATM to Withdraw $"+ cashOut);
		}else{
			return this.total=this.total-cashOut;
		}
		return this.total;
	}
	
	//test ATM
	public static void main (String[]args){
		ATM atm1 = new ATM();
		atm1.login();
	}
}

