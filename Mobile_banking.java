package new_banking;

public class Mobile_banking extends Account{
    private String number;
    private  int pin;

    public double total_amount;

    public Mobile_banking(String name, String number, int pin, double balance)
    {
        super(name, balance);
        this.number=number;
        this.pin=pin;
    }


    public String add_money(double amount, double maximum_add_money )
    {
        if(amount<=maximum_add_money) {         //cheek limit
            super.add_money(amount);
            return "SUccessfull";
        }
        else
            return "maximum quota exceed";
    }


    public String cash_out(double amount,int user_pin,double rate,double max_cashout)
    {
        if(user_pin==pin) {
            if (amount <= max_cashout) {            // cheek maximum cash out limit
                double total_amount =amount+ (amount * rate) / 1000;            //charge for chash out
                boolean cheek=super.cash_out(total_amount);

                if(cheek)            //if cash out successfully it return 1
                    return "Cash out successfully";
                else
                    return "Cash out failed for balance limit";
            }
            else
                return "Cash out failed due to limit exceed";
        }
        else
            return "Pin doesn't match";

    }


            //send money another account
    public String send_money(double amount,int pin,double spend,double limit)
    {
        if(pin==this.pin) {
            if (amount <= limit) {
                amount += spend;          //send money can take a charge
                boolean cheek=super.cash_out(amount);           //cheek it work or not

                if(cheek)
                    return "Money send successfully";
                else
                    return "Money doesn't sent due to short limit";
            } else
                return "Money send failed due to limit exceed";
        }
        else
            return "Pin doesn't match";
    }

    public String balance_check(int pin){
        if(pin == this.pin){
            return "Your balance is: "+getBalance();
        }
        else {
            return "Wrong pin";
        }
    }


    public String getNumber()
    {
        return number;
    }

        //print details about user
        @Override
    public String toString()
    {
        return "Account details for { "+ "Name  : " +getCustomer_name() + " ,   Mobile number : " +getNumber() + " , Total balance  : " +getBalance();
    }


        //for change pin
    public String pin_update(int old_pin, int new_pin){
        if(old_pin == this.pin){
            if(old_pin == new_pin){
                return "old pin can't be same as new pin";
            }
            else{
                this.pin = new_pin;
                return "Pin updated successfully";
            }

        }
        else
            return "Old pin does not match. Pin update failed";

    }



    //open account without setup pin

//    public Mobile_banking(String name, String number)
//    {
//        //super(name);
//        this.number=number;
//
//        System.out.println("Welcome you opened an account successfully");
//    }
//                // pin set up for new customer open an account without pin
//    public void setup_pin_new_customer( int pin)
//    {
//        pin=this.pin;
//
//        System.out.println("Pin set up successfully");
//    }

}
