/**
 * Write a complete Java program that prompts the user for two non-negative 
 * integer numbers. 
 * Your program should handle bad input data from keyboard.
 */
package icplab;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Aileen Akpalu and Kobby Koranteng
 *
 */
public class EssentialShop {
// these are the instance variables
	private final String item;
	private final int quantity;
	private final float price;


	/**
	 * Constructor
	 *
	 * @param item
	 * @param quantity
	 * @param price
	 */
	public EssentialShop(String item, int quantity, float price) {


		// TODO Auto-generated constructor stub
		this.item = item;
		this.quantity = quantity;
		this.price = price;
	}

	//this function returns the string value of parameter item.
	public String getItem() {
		return item;
	}

	//this function returns the int value of parameter quantity.
	public int getQuantity() {
		return quantity;
	}

	//this function returns the float value of parameter price.
	public float getPrice() {
		return price;
	}


	/**
	 * This function prints the headings for the text file.
	 * @throws FileNotFoundException
	 */
	public void writingTextToFiles() throws FileNotFoundException {

		PrintWriter printWriter = null;

		try {
			//Note that we are able to append to the file because of the "true" parameter
			printWriter = new PrintWriter(new FileOutputStream("essentials_stock.txt", true));
		} catch (FileNotFoundException fnfe) {
			fnfe.getMessage();
		}

//prints the headings to the text file
		printWriter.print("Item" + "    " + "Quantity" + "    " + " Price(GHc)");
		printWriter.println();

		printWriter.close();



		try {
			//Note that we are able to append to the file because of the "true" parameter
			printWriter = new PrintWriter(new FileOutputStream("backup_essentials_stock.txt", true));
		} catch (FileNotFoundException fnfe) {
			fnfe.getMessage();
		}


		printWriter.print("Item" + "    " + "Quantity" + "    " + " Price(GHc)");
		printWriter.println();

		printWriter.close();
	}


	/**\
	 * This function prints the user inputs of the item,quantity and price to the text file.
	 * @throws FileNotFoundException
	 */
	public void writingTextToFile() throws FileNotFoundException {

		PrintWriter printWriter = null;

		try {
			//Note that we are able to append to the file because of the "true" parameter
			printWriter = new PrintWriter(new FileOutputStream("essentials_stock.txt", true));
		} catch (FileNotFoundException fnfe) {
			fnfe.getMessage();
		}


		//gets the values of the getters and prints them in the text file
		printWriter.print(getItem() + "    " + getQuantity() + "    " + getPrice());
		printWriter.println();

		//Close Writer
		printWriter.close();


		try {
			//Note that we are able to append to the file because of the "true" parameter
			printWriter = new PrintWriter(new FileOutputStream("backup_essentials_stock.txt", true));
		}catch(FileNotFoundException fnfe) {
			fnfe.getMessage();
		}

		//gets the values of the getters and prints them in the text file
		printWriter.print(getItem() + "    " + getQuantity() + "    " + getPrice());
		printWriter.println();

		//Close Writer
		printWriter.close();
	}

	/**
	 * This function asks the user input for the inventory.
	 * The items are then passed to the file.
	 */
	public static void Do(){
		Scanner stdin = new Scanner(System.in);
		System.out.print("Enter the first item in the stock: ");
		String item = stdin.next();
		System.out.println("Enter the quantity: ");
		int quant = stdin.nextInt();
		System.out.println("Enter the price: ");
		float price = stdin.nextFloat();

		EssentialShop store = new EssentialShop(item, quant, price);


		try {
			store.writingTextToFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void Read() throws FileNotFoundException {
		File file= new File("essentials_stock.txt");
		Scanner read= new Scanner(file);
		while(read.hasNext()){
			System.out.println(read.nextLine());
		}

	}



	/**
	 * This function re-asks the user for their input. It breaks when the user selects a particular option
	 * @return logo
	 */
	public static int Cont(){
		System.out.println("Essentials Inventory Stock" + "\n Is there another item on the list" + "\n1.Yes" + "\n2.No");
		Scanner log = new Scanner(System.in);
		int logo = log.nextInt();
		while (true) {
			if (logo == 1 || logo == 2) {
				break;
			} else {
				System.out.println("Option not available");
				System.out.println("Essentials Inventory Stock" + "\n Is there another item on the list" + "\n1.Yes" + "\n2.No)");
				logo = log.nextInt();
			}
		}
		if (logo == 1) {
			Do();
			Cont();

		} else if (logo == 2) {
			System.out.println("Ending inventory....................");

		}
		return logo;
	}



	}

