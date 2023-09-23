package new_banking;

public class Bank extends Account{

    private String account_number;

    public Bank(String name, String account_number)
    {
        super(name,0.0);
        this.account_number=account_number;
    }

    public void deposite(double amount)
    {
        super.add_money(amount);
        System.out.println(amount+ "taka deposited successfully toyour account");
    }

    public void withdraw(double amount)
    {
        boolean cheek=super.cash_out(amount);           //cheek there are sufficient balance or not

        if(cheek)
            System.out.println(amount+ " taka successfully withdraw from your account");
        else
            System.out.println("Money withdraw failed due to balance short");
    }

    public void transfer(double amount)
    {
        boolean cheek=super.send_money(amount);

        if(cheek)
        {
            System.out.printf(amount+ " taka send successfully");
        }
        else
            System.out.println("Money send failed due to short balance");
    }

}
