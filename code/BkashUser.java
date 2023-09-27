package new_banking.code;

import java.io.*;
import java.util.*;

public class BkashUser {

    // Function to write account details to a file
    public static void writeAccountDetailsToFile(String phoneNumber, double amount, int pin) {
        try (FileWriter fileWriter = new FileWriter("code/accountDetails.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            // Format the account details and write them to the file
            String accountDetails = phoneNumber + " " + amount + " " + pin;
            printWriter.println(accountDetails);
            System.out.println("Account details written to file successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to read account details from a file
    public static List<String> readAccountDetailsFromFile() {
        List<String> accountDetailsList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("code/accountDetails.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into components and add it to the list
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    accountDetailsList.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return accountDetailsList;
    }

    public boolean createBkashAccount(String name, String number, int pin){
        List<String> accountDetails = readAccountDetailsFromFile();
        for (String details : accountDetails) {
            String[] parts = details.split(" ");
            String phoneNumber = parts[0];
            if(Objects.equals(phoneNumber, number)){
                return false;
            }
        }
        writeAccountDetailsToFile(number, 0.0, pin);
        return true;
    }

    public Bkash enterBkash(String phn_number){
        List<String> accountDetails = readAccountDetailsFromFile();
        for (String details : accountDetails) {
            String[] parts = details.split(" ");
            String phoneNumber = parts[0];
            //System.out.println(phoneNumber.length()+" "+phn_number.length());
            if(phoneNumber.equals(phn_number)){
                double amount = Double.parseDouble(parts[1]);
                int pin = Integer.parseInt(parts[2]);
                Bkash bkash = new Bkash(" ",phoneNumber,pin,amount);
                return bkash;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Example usage:
        // Writing account details to the file
//        writeAccountDetailsToFile("1234567890", 1000.0, 1234);
//        writeAccountDetailsToFile("9876543210", 500.0, 5678);

        // Reading account details from the file
        BkashUser bkashUser = new BkashUser();
        //bkashUser.createBkashAccount("sa","012345",1234);
        Bkash bkash = bkashUser.enterBkash("012345");
        System.out.println(bkash.balance_check(1234));

    }
}

