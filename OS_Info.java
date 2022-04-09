import java.text.NumberFormat;

public class OS_Info {
    public static void main(String[] args)
    {
        System.out.println("\n----------------------------------------------------");
        System.out.print("OS Name: \t\t\t" + System.getProperty("os.name") +"\n");
        System.out.println("OS Version: \t\t\t"  + System.getProperty("os.version"));
        System.out.println("Open Processors: \t\t" + Runtime.getRuntime().availableProcessors());
        System.out.println("Free memory (bytes): \t\t"+ NumberFormat.getInstance().format(Runtime.getRuntime().freeMemory()));
        System.out.println("Total memory avail.(bytes): \t" + NumberFormat.getInstance().format(Runtime.getRuntime().totalMemory()));
        System.out.println("----------------------------------------------------");
    }
}

