package new_banking.code;

public class Account{

    private String customer_name;
    private double balance=0;


    public Account(String customer_name, double amount)        //constractor for take customer name
    {
        this.customer_name=customer_name;
        balance = amount;
    }


    public void add_money(double amount)
    {
        balance += amount;
    }

    public boolean cash_out(double amount)
    {
        if(amount<=balance)
        {
            balance -= amount;

            return true;
        }
        else
            return false;

    }

    public boolean send_money(double amount)
    {
        if(amount<=balance)
        {
            balance-=amount;
            return true;
        }
        else
            return false;
    }




    public String getCustomer_name()
    {
        return customer_name;
    }


    public double getBalance()
    {
        return balance;
    }


}
