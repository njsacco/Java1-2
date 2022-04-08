import javax.swing.*;
import java.text.NumberFormat;

public class pointOfSaleSystem {

    public static void main(String[] args) {
        //Object Creation
        Cashier c = new Cashier();

        //Item 1
        String name = GetData.getWord("Enter name of item");
        double price = GetData.getDouble("Enter price of item");
        c.add(name, price);
        //Item 2
        name = GetData.getWord("Enter name of item");
        price = GetData.getDouble("Enter price of item");
        c.add(name, price);
        //Item 3
        name = GetData.getWord("Enter name of item");
        price = GetData.getDouble("Enter price of item");
        c.add(name, price);
        //Item 4
        name = GetData.getWord("Enter name of item");
        price = GetData.getDouble("Enter price of item");
        c.add(name, price);

        // Now average the price of the items
        c.average();
        // Make payment
        double amount = GetData.getDouble("Enter amount used for payment");
        c.tendered(amount); // For example twenty dollars were tendered
        c.makeChange();
        generateReceipt(c);
    }

    static void generateReceipt(Cashier c) {
        // Write the necessary code that will generate a customer’s receipt.

        NumberFormat f = NumberFormat.getCurrencyInstance();
        String newLine = "\n";

        String listMessage = c.list + "\n";
        String divider = "----------------\n";
        String totalPriceMessage = "Total........" + f.format(c.totalPrice) + "\n";

        String totalItemsMessage = "The number of items purchased is " + c.itemCount + " items\n";
        String averagePriceMessage = "The average price per item is " + f.format(c.average) + "\n";

        String tenderedMessage = "Amount tendered is " + f.format(c.tendered) + "\n";
        String changeMessage = "The change is " + f.format(c.change) + "\n";

        String changeIncludesMessage = "The change includes\n";
        String dollarsMessage = c.dollars + " dollars\n";
        String quartersMessage = c.quarters + " quarters\n";
        String dimesMessage = c.dimes + " dimes\n";
        String nickelsMessage = c.nickels + " nickels\n";
        String penniesMessage = c.pennies + " cents\n";

        String receiptText = ""
                .concat(listMessage)
                .concat(divider)
                .concat(totalPriceMessage)
                .concat(totalItemsMessage)
                .concat(averagePriceMessage)
                .concat(newLine)
                .concat(tenderedMessage)
                .concat(changeMessage)
                .concat(newLine)
                .concat(changeIncludesMessage)
                .concat(dollarsMessage)
                .concat(quartersMessage)
                .concat(dimesMessage)
                .concat(nickelsMessage)
                .concat(penniesMessage);

        // The output must be displayed in a scrollable pane
        JTextArea text = new JTextArea(receiptText, 15, 30);
        JScrollPane pane = new JScrollPane(text);
        JOptionPane.showMessageDialog(null, pane, "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }

}

class Cashier {

    public String list = "";
    public int itemCount = 0;
    public double totalPrice = 0;
    public double average;
    public double tendered;
    public double change;

    public int quarters;
    public int dimes;
    public int nickels;
    public int pennies;
    public int dollars;


    //Add function
    public void add(String itemName, double price) {
        NumberFormat f = NumberFormat.getCurrencyInstance();
        this.list += itemName + "........" + f.format(price) + "\n";
        this.totalPrice += price;
        this.itemCount += 1;
    }

    public void average() {
        this.average = totalPrice / itemCount;
    }

    public void tendered(double tendered) {
        this.tendered = tendered;
    }

    public void makeChange() {
        this.change = this.tendered - this.totalPrice;
        double change = this.change;

        // get dollars
        this.dollars = (int) (change);
        change %= this.dollars;

        // convert to 100 pennies, so we can use ints to round down our change
        change *= 100;

        // get quarters
        this.quarters = (int) change / 25;
        change %= 25;

        // get dimes
        this.dimes = (int) change / 10;
        change %= 10;

        // get nickels
        this.nickels = (int) change / 5;
        change %= 5;

        // get pennies
        this.pennies = (int) Math.round(change);
    }
}

class GetData {
    //Input Window
    static double getDouble(String s) {
        return Double.parseDouble(getWord(s));
    }

    static int getInt(String s) {
        return Integer.parseInt(getWord(s));
    }

    static String getWord(String s) {
        return JOptionPane.showInputDialog(s);
    }
}
