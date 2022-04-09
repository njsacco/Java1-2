import javax.swing.JOptionPane;

public class HospitalBilling {
    public static void main(String []args){
        String patientID = GetData.getWord("What is the 5 digit patient ID: ");
        String patientName = GetData.getWord("Whats the patient name: ");
        int numDays = GetData.getInt("Number of days admitted in the hospital: ");
        char roomType =  GetData.getWord("What type of room used by patient?\n"
                + "(P/p means private, S/s means semi-private, and W/w means ward)").trim().charAt(0);

        Hospital hosObj = new Hospital(patientID, patientName, numDays, roomType);
        hosObj.calculate();
        String data = "The ABC Community Hospital\n";
        data += "  Patient Billing Statement\n";
        data += "Patient:                         "+hosObj.getName()+"\n";
        data += "Number of days:         "+hosObj.getNumDays()+"\n\n";
        if(hosObj.isValidRoomType()){
            switch(hosObj.getRoomType()){
                case 'p':
                case 'P':
                    data += "Type of room: Private\n";
                    break;
                case 's':
                case 'S':
                    data += "Type of room: Semi-private\n";
                    break;
                case 'w':
                case 'W':
                    data += "Type of room: Ward\n";
                    break;
            }
        }else{
            data += " Not a valid room type given.\n";
        }
        data += "Room charge .............         $"+String.format("%.2f\n", hosObj.getTotalRoom());
        data += "Telephone ...............           $"+String.format("%.2f\n", hosObj.getTotalPhone());
        data += "Television ...............            $"+String.format("%.2f\n", hosObj.getTotalTV());
        data += "Medication  ...............          $"+String.format("%.2f\n", hosObj.getTotalMedication());
        data += "Total amount due  .........     $"+String.format("%.2f\n", hosObj.getTotalAmount());
        JOptionPane.showMessageDialog(null, data);
    }
}
class Hospital {

    //Variables
    private String pid;
    private String name;
    private int numOfDays;
    private char roomType;
    private double totalRoom;
    private double totalPhone;
    private double totalTV;
    private double totalMedication;
    private double totalAmount;
    private boolean validRoomType;

    //Getters
    public double getTotalRoom() {return totalRoom;}
    public double getTotalPhone() {return totalPhone;}
    public double getTotalTV() {return totalTV;}
    public double getTotalMedication() {return totalMedication;}
    public double getTotalAmount() {return totalAmount;}

    //Constructor
    public Hospital(String pid, String name, int numDays, char roomType) {
        this.pid = pid;
        this.name = name;
        if(numDays>0){this.numOfDays = numDays;}
        else{this.numOfDays = 0;}
        this.roomType = roomType;}

    //More Getters
    public String getPid() {return pid;}
    public String getName() {return name;}
    public int getNumDays() {return numOfDays;}
    public char getRoomType() {return roomType;}

    //Calculation Method
    public void calculate() {
        validRoomType = true;
        switch (roomType) {
            case 'p':
            case 'P':
                totalRoom = numOfDays * 550;
                totalTV = 7.5;
                totalPhone = 4.5;
                totalMedication = 2 * 275;
                break;
            case 's':
            case 'S':
                totalRoom = numOfDays * 350;
                totalTV = 7.5;
                totalPhone = 0;
                totalMedication = 275;
                break;
            case 'w':
            case 'W':
                totalRoom = numOfDays * 105;
                totalTV = 0;
                totalPhone = 0;
                totalMedication = 275/2.0;
                break;
            default:
                validRoomType = false;
                break;
        }
        totalAmount = totalRoom + totalPhone + totalTV + totalMedication;
    }

    public boolean isValidRoomType() {
        return validRoomType;
    }


}

class GetData
{
    static double getDouble(String s)
    {
        return Double.parseDouble(getWord(s));
    }
    static int getInt(String s)
    {
        return Integer.parseInt(getWord(s));
    }
    static String getWord(String s)
    {
        return JOptionPane.showInputDialog(s);
    }
}