
public class Account {
	
	private String uname;
	private int pin;
	private double balance;
	
	// Constructors
	public Account(String u, int p, double b){
		this.uname = u;
		this.pin = p;
		this.balance =  b;
	}

	public String getUname()  {return this.uname;}
	public int getPin() {return this.pin;}
	public double getBalance() {return this.balance;}
	
	public double withdraw(double w){
		if (w>balance){
			StdOut.println("Not Suffient Enough Funds to Withdraw $"+w);
			StdOut.println("Overdraft by $"+ (w-balance));
			return this.balance;
		}else if(w==balance){
			this.balance = this.balance-w;
			StdOut.println("$"+w+" Withdrawn From Account");
			StdOut.println("All Funds Have Been Removed From Your Account");
			return this.balance;
		}else{
			this.balance = this.balance-w;
			StdOut.println("$"+w+" Withdrawn From Account");
			return this.balance;
		}	
	}
	
	public double deposit(double d){
		this.balance = this.balance + d;
		StdOut.println("$"+d+" Deposited Into Account");
		StdOut.println("Current Balance: "+this.balance);
		return this.balance;
	}
}
