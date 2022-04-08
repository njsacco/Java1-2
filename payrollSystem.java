import java.util.Date;
import java.text.DateFormat;
import java.text.NumberFormat;

public class payrollSystem {
    public static void main(String[] args) {

        Date d = new Date();
        DateFormat df = DateFormat.getDateInstance();
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        Payroll employee1 = new Payroll("222-2222", 30.0, 11.50);
        Payroll employee2 = new Payroll("888-8888", 20.0, 9.00);
        System.out.println();
        System.out.println("Payroll For Week Ending " + df.format(d));
        System.out.println("-----------------------------------");
        System.out.println("Employee #:..........." + employee1.getEmployeeNumber());
        System.out.println("Hours Worked:........." + employee1.getHoursWorked() + " Hours");
        System.out.println("Hourly Rate:.........." + nf.format(employee1.getHourlyPay()) + "/Hour");
        employee1.calculateEmployeeSalary();
        System.out.println("Your salary is:......." + nf.format(employee1.getSalary()));
        System.out.println("-----------------------------------");
        System.out.println();
        System.out.println("Employee #:..........." + employee2.getEmployeeNumber());
        System.out.println("Hours Worked:........." + employee2.getHoursWorked() + " Hours");
        System.out.println("Hourly Rate:.........." + nf.format(employee2.getHourlyPay()) + "/Hour");
        employee2.calculateEmployeeSalary();
        System.out.println("Your salary is:......." + nf.format(employee2.getSalary()));
        System.out.println("-----------------------------------");
        System.out.println();

        System.out.println("Increase " + employee1.getEmployeeNumber() + " by 20 hours");
        employee1.increaseHours(20);

        System.out.println("Employee #:..........." + employee1.getEmployeeNumber());
        System.out.println("Hours Worked:........." + employee1.getHoursWorked() + " Hours");
        System.out.println("Hourly Rate:.........." + nf.format(employee1.getHourlyPay()) + "/Hour");
        System.out.println("Your salary is:......." + nf.format(employee1.getSalary()));
        System.out.println("-----------------------------------");
        System.out.println("                                   ");
        System.out.println("Total payout amount...." + nf.format(Payroll.getWeeklyPayroll()));
        System.out.println("---------- End of report ----------");

    }

}

class Payroll {

    //Instance Variable 
    String employeeNumber;
    double hoursWorked;
    double hourlyPay;
    double salary;

    //Class Variable  Is the same for all objects
    static double weeklyPayroll;

    //Constructor 
    public Payroll(String employeeNumber, double hoursWorked, double hourlyPay) {
        this.employeeNumber = employeeNumber;
        this.hoursWorked = hoursWorked;
        this.hourlyPay = hourlyPay;
    }

    //Getters Accessor Methods
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyPay() {return hourlyPay;}

    public double getSalary() {return salary;}

    public static double getWeeklyPayroll() {return weeklyPayroll;}

    //Setters Mutator Method 
    public void calculateEmployeeSalary() {
        this.salary = this.hourlyPay * this.hoursWorked;
        weeklyPayroll += this.salary;
    }

    //Setters Mutator Method 
    public void increaseHours(double hours) {
        this.hoursWorked += hours;
        this.salary += this.hourlyPay * hours;
        weeklyPayroll += this.hourlyPay * hours;

    }

}
