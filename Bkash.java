package new_banking;

public class Bkash extends Mobile_banking{

    public Bkash(String name, String number, int pin, double balance)
    {
        super(name,number,pin, balance);
    }

    public String cashIn(double amount) {
        return super.add_money(amount,30000);
    }

    public void cash_out(double amount, int pin)
    {
        super.cash_out(amount,pin,18.5,25000);
    }


    public void send_money(double amount,int pin)
    {
        super.send_money(amount,pin,5,122500);
    }


    //public void pin_update()
}
