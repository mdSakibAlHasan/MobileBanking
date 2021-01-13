package new_banking;

public class Roket extends Mobile_banking{

    public Roket(String name, String number, int pin)
    {
        super(name,number,pin);
    }

    public Roket(String name, String number)        //open an account without setup pin
    {
        super(name,number);
    }

    @Override
    public void add_money(double amount) {
        super.add_money(amount,30000);
    }

    public void cash_out(double amount, int pin)
    {
        super.cash_out(amount,pin,18,25000);
    }


    public void send_money(double amount,int pin)
    {
        super.send_money(amount,pin,0,25000);
    }


}
