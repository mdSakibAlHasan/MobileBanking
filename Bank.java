package new_banking;

public class Bank extends Account{

    private String account_number;

    public Bank(String name, String account_number)
    {
        super(name);
        this.account_number=account_number;
    }

    public void deposite(double amount)
    {
        super.add_money(amount);
        System.out.println(amount+ "taka deposited successfully toyour account");
    }

    public void withdraw(double amount)
    {
        int cheek=super.cash_out(amount);           //cheek there are sufficient balance or not

        if(cheek==1)
            System.out.println(amount+ "taka successfully withdraw from your account");
        else
            System.out.println("Money withdraw failed due to balance short");
    }

    public void send_money(double amount)
    {
        amount-=100;

        int cheek=super.cash_out(amount);

        if(cheek==1)
        {
            amount+=100;
            System.out.printf(amount+ "Money send successfully");
        }
        else
            System.out.println("Money send failed due to short balance");
    }


}
