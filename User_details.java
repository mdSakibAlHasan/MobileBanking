package new_banking;

public class User_details {
    public void user_details_programe()
    {
        Bkash Saimum = new Bkash("Saimum","01521786812",1234);
        Bkash Jishan = new  Bkash( "Jishan","01521786812", 4321);

        Saimum.add_money(2500 );
        Saimum.add_money(250000);
        Saimum.cash_out(1500,1234);
        Saimum.cash_out(1000,3456);
        Saimum.send_money(500,1234);
        Saimum.send_money(1000,1234);
        Saimum.send_money(100,456);
        System.out.println(Saimum);

        Saimum.pin_update(1234,0123);

        Saimum.cash_out(1200, 1234);
        Saimum.cash_out(100,433321);

        Roket hasan= new Roket("hasan","0192097745148777");
        hasan.setup_pin_new_customer(1209);
        hasan.add_money(1200);
        System.out.println(hasan);

        Roket Sakib = new Roket("Saimum","01521786812",1234);
        Nagod Sheam = new  Nagod( "Jishan","01521786812", 4321);

        Sakib.add_money(2500 );
        Sheam.add_money(250000);

        Sakib.cash_out(1200, 1234);
        Sheam.cash_out(100,4321);

        Sakib.send_money(1000,1234);

        System.out.println("print details");
        System.out.println(Sakib);




    }
}
