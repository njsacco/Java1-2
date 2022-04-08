import java.util.Date;
        import java.text.DateFormat;
        import java.text.NumberFormat;

class TestHotel2 {
    public static void main(String[] arg)
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance();

// Create customer objects, calculate amounts, display receipts
        Hotel customer1 = new Hotel("10 - M", 2, 2);
        customer1.calculate();
        display(customer1, nf);

        Hotel customer2 = new Hotel("12 - B");


        Hotel customer3 = new Hotel("12 - C", 2);
        customer3.calculate();

        customer2.addNights(1);
        customer2.calculate();
        display(customer2, nf);

        customer3.addGuest(1);
        customer3.calculate();
        display(customer3, nf);

//Official Use only Totals everything up
        display2(customer1, customer2, customer3, nf);
    }
    public static class Hotel {

        //Class Variables (Constants) Same for every object
        private static final double roomRate = 79.95,
                taxRate = 6.5,
                telephone = 5.75,
                mealCost = 12.95,
                tipRate = .075;

        //Instance Variables
        private int noOfNights,
                noOfGuests;
        private double amountDue,
                meal,
                tax,
                subtotal,
                total,
                tip,
                telephoneTotal;
        private String roomNumber;

        //Overloaded Constructors (decoupled)
        public Hotel(String room){
            this.roomNumber = room;
            noOfGuests = 1;
            noOfNights = 1;
        }
        public Hotel(String room, int nights){
            this.roomNumber = room;
            this.noOfNights = nights;
            this.noOfGuests = 1;
        }
        public Hotel(String room, int nights, int guests){
            this.roomNumber = room;
            this.noOfNights = nights;
            this.noOfGuests = guests;
        }

        //Getters / Accessor Methods for Constant class variables (I know some aren't used, but its good convention)
        public static final double getRoomRate(){return roomRate;}
        public static final double getTaxRate(){return taxRate;}
        public static final double getTelephone(){return telephone;}
        public static final double getMealCost(){return mealCost;}
        public static final double getTipRate(){return tipRate;}

        //Getters / Accessor Methods for Instance variables
        public int getNoOfNights(){return noOfNights;}
        public int getNoOfGuests(){return noOfGuests;}
        public double getAmountDue(){return amountDue;}
        public double getMeal(){return meal;}
        public double getTax(){return tax;}
        public double getSubtotal(){return subtotal;}
        public double getTotal(){return total;}
        public double getTip(){return tip;}
        public double getTelephoneTotal(){return telephoneTotal;}
        public String getRoomNumber(){return roomNumber;}

        //Setters / Methods for calculation
        public void addNights(int nights){
            this.noOfNights += nights;
        }
        public void addGuest(int guests){
            this.noOfGuests += guests;
        }

        public void calculate(){
            amountDue = roomRate * noOfNights * noOfGuests;
            tax = amountDue * taxRate/100;
            subtotal = amountDue + tax;
            meal = mealCost * noOfNights * noOfGuests;
            tip = tipRate *(subtotal + meal + telephone);
            //line 70 is needed in order to calculate total telephone as you can't add them together on line 68 in test class
            telephoneTotal = telephone;
            total = subtotal + telephone + meal + tip;
        }


    }
    static void display(Hotel hotel, NumberFormat nf) {
// Set up and display heading and date for each receipt
        System.out.println();
        System.out.println("\tThe ABC Cheap Lodging, Inc");
        Date d = new Date();
        DateFormat df = DateFormat.getDateInstance();
        System.out.println("\tDate: \t" + df.format(d));
// Display expenses line by line including subtotal as shown in the output
        System.out.println("Room #:\t\t\t\t" + hotel.getRoomNumber());
        System.out.println("Room Rate:\t\t\t" + nf.format(Hotel.getRoomRate()));
        System.out.println("Length of Stay:\t\t" + hotel.getNoOfNights());
        System.out.println("No. of Guests:\t\t" + hotel.getNoOfGuests());
        System.out.println("Room Cost:\t\t\t" + nf.format(Hotel.getRoomRate()));
        System.out.println("Tax of 6.5%:\t\t" + nf.format(hotel.getTax()));
        System.out.println("\t Subtotal:\t\t\t" + nf.format(hotel.getSubtotal()));
        System.out.println("Telephone:\t\t\t" + nf.format(Hotel.getTelephone()));
        System.out.println("Meal Charges:\t\t" + nf.format(hotel.getMeal()));
        System.out.println("Tip:\t\t\t\t" + nf.format(hotel.getTip()));
        System.out.println("TOTAL AMOUNT DUE:\t......." + nf.format(hotel.getTotal()));
        System.out.println("Thanks for Staying at XYZ Cheap Lodging Inc.");
        System.out.println("\t\t Please Come Again!!!");
//Display to total
        System.out.println("\nTOTAL AMOUNT DUE\t.........." + nf.format(hotel.getTotal()));
// Display thank you message
        System.out.println("\nThanks for staying at The ABC Cheap Lodging, Inc" );
        System.out.println("\tPlease come again !!!");
        System.out.println("\n");
    }
    //Official Use only Totals everything up
    static void display2(Hotel customer1, Hotel customer2,Hotel customer3, NumberFormat nf) {
// Complete this method so that it displays the summary amounts as shown in the output
        System.out.println();
        System.out.println("\tOFFICIAL USE ONLY");
        System.out.println("\tToday's Summary");
        System.out.println("Room\t\t\t\t...." + nf.format(customer1.getAmountDue() + customer2.getAmountDue() + customer3.getAmountDue()));
        System.out.println("Telephone\t\t\t...." + nf.format(customer1.getTelephoneTotal()+customer2.getTelephoneTotal()+customer3.getTelephoneTotal()));
        System.out.println("Meal\t\t\t\t...." + nf.format(customer1.getMeal() + customer2.getMeal() + customer3.getMeal()));
        System.out.println("Tips\t\t\t\t...." + nf.format(customer1.getTip() + customer2.getTip() + customer3.getTip()));
        System.out.println("Tax\t\t\t\t\t...." + nf.format(customer1.getTax() + customer2.getTax() + customer3.getTax()));
        System.out.println("-----------------------------");
        System.out.println("Gross Transaction\t...." + nf.format(customer1.getTotal() + customer2.getTotal() + customer3.getTotal()));
    }

}
