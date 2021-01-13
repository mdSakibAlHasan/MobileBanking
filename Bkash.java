package new_banking;

public class Bkash extends Mobile_banking{

    public Bkash(String name, String number, int pin)
    {
        super(name,number,pin);
    }

    public Bkash(String name, String number)        //open an account without setup pin
    {
        super(name,number);
    }


    @Override
    public void add_money(double amount) {
        super.add_money(amount,30000);
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
