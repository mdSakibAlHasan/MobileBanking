package new_banking;

public class Mobile_banking extends Account{
    private String number;
    private  int pin;

    public double total_amount;

    public Mobile_banking(String name, String number, int pin)
    {
        super(name);
        this.number=number;
        this.pin=pin;
    }


    public void add_money(double amount,double maximum_add_money)
    {
        if(amount<=maximum_add_money) {         //cheek limit
            super.add_money(amount);
            System.out.println(amount+ "cash in succesfully");
        }
        else
            System.out.println("Add money failed due to limit exeed ");
    }


    public void cash_out(double amount,int user_pin,double rate,double max_cashout)
    {
        if(user_pin==pin) {
            if (amount <= max_cashout) {            // cheek maximum cash out limit
                double total_amount =amount+ (amount * rate) / 1000;            //charge for chash out
                int cheek=super.cash_out(total_amount);

                if(cheek==1)            //if cash out successfully it return 1
                    System.out.println("Cashout successfully "  +amount);
                else
                    System.out.println("Cashout failed for balance limit");
            }
            else
                System.out.println("Cash out failed due to limit exeed");
        }
        else
            System.out.println("Pin doesn't match");

    }


            //send money another account
    public void send_money(double amount,int pin,double spend,double limit)
    {
        if(pin==this.pin) {
            if (amount <= limit) {
                amount += spend;          //send money can take a charge
                int cheek=super.cash_out(amount);           //cheek it work or not

                if(cheek==1)
                    System.out.println("Money send successfully");
                else
                    System.out.println("Money doesn't sent due to short limit");
            } else
                System.out.println("Money send failed due to limit excced");
        }
        else
            System.out.println("Pin doesn't match ");
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
    public void pin_update(int old_pin, int new_pin){
        if(old_pin == this.pin){
            this.pin = new_pin;
            System.out.println("Pin updated successfully  " );
        }
        else
            System.out.println("Old pin does not match. Pin update failed. " );

    }



    //open account without setup pin

    public Mobile_banking(String name, String number)
    {
        super(name);
        this.number=number;

        System.out.println("Welcome you opened an account successfully");
    }
                // pin set up for new customer open an account without pin
    public void setup_pin_new_customer( int pin)
    {
        pin=this.pin;

        System.out.println("Pin set up successfully");
    }

}
