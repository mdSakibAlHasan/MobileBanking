package new_banking.code;

public class Mobile_banking extends Account{
    private String number;
    private  int pin;


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
            return "Successful";
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
                    return "Money doesn't sent due to shortage balance";
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


    public String transferToBank(double amount, int pin, String account_number, int max_transfer){
        if(pin == this.pin){
            if(amount<getBalance() && amount<max_transfer){
                return "balance transfer complete";
            }
            else{
                return "balance shortage or quota exceed";
            }
        }
        else{
            return "pin not match";
        }
    }

    public String addMoneyFromBank(double amount, String account_number){
        if(account_number.length() == 6){
            return "balance add complete";
        }
        else{
            return "wrong account number";
        }

    }


    public String mobileRechrge(String mobile_number,int pin,double amount){
        if(mobile_number.length() == 11){
            if(pin == this.pin){
                if(amount<getBalance() && amount>=20){
                    return "recharge successfully done";
                }
                else{
                    return "balance shortage or below amount";
                }
            }
            else {
                return "pin not match";
            }
        }
        else {
            return "phn number not valid";
        }
    }


}
