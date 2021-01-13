package new_banking;

public class Account{

    private String customer_name;
    private double balance=0;


    public Account(String customer_name)        //constractor for take customer name
    {
        this.customer_name=customer_name;
    }


    public void add_money(double amount)
    {
        balance += amount;
    }

    public int cash_out(double amount)
    {
        if(amount<=balance)
        {
            balance -= amount;

            return 1;
        }
        else
            return 0;

    }

    public void send_money(double amount)
    {
        if(amount<=balance)
        {
            balance-=amount;
            System.out.println("Money sent successfully ");
        }
        else
            System.out.println("Money sent failed due to limited balance");
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
