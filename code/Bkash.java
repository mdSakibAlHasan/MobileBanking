package new_banking.code;

public class Bkash extends Mobile_banking{

    public Bkash(String name, String number, int pin, double balance)
    {
        super(name,number,pin, balance);
    }

    public String cashIn(double amount) {
        return super.add_money(amount,30000);
    }

    public String cash_out(double amount, int pin)
    {
        return super.cash_out(amount,pin,18.5,25000);
    }


    public String send_money(double amount,int pin)
    {
        return super.send_money(amount,pin,5,30000);
    }

    public String transfer(double amount, int pin, String account_number){
       return super.transferToBank(amount,pin,account_number,30000);
    }

}
