//@Author Yu Lin - CSCI 185 - SPRING 2015 - ATM Project
// coding and practicing the same project for learning purpose by @shnartho

package ATM_Machine;

import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;
import java.text.DecimalFormat;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        input x = 1;
        do {
            try {
                /*
                 * Accounts in a HashMap, key = customer number, value = pin
                 * number
                 */
                data.put(123456789, 1234);
                data.put(123456780, 1230);


                System.out.println("Welcome to the ATM Project!");

                System.out.print("Enter Your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());
                System.out.print("Enter Your Pin Number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
                x = 2;
            }
        }
    }


    public static void main(String[] args) {

    }
}
