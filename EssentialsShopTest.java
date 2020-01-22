package icplab;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static icplab.EssentialShop.Cont;
import static icplab.EssentialShop.Read;

public class EssentialsShopTest {
    /**
     * @param args
     * @throws InputMismatchException
     */
    public static void main(String args[]) throws InputMismatchException, FileNotFoundException {
        System.out.println("These are the current items in the stock");
        Read();
        Scanner stdin = new Scanner(System.in);
        System.out.print("Enter the first item in the stock: ");
        String item = stdin.next();
        System.out.println("Enter the quantity: ");
        int quant = stdin.nextInt();
        System.out.println("Enter the price: ");
        float price = stdin.nextFloat();

        EssentialShop store = new EssentialShop(item, quant, price);
//this captures any error that could occur
        try {
            store.writingTextToFiles();
            store.writingTextToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //this re-asks for user inputs
        Cont();



    }
}
