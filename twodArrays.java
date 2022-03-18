
    //Purpose    : The purpose of this program is to create a 15x15 2 dimension array with indexes equaling to (row + column)*3 location.
                 //Secondly, the program sums all of the indexes together and provides and output.
     
public class twodArrays
{
    public static void arrays(int[][] arr)//From the main method passing the 2d array call a method named arrays 
    {
        for (int x = 0; x < arr.length; x ++)// Process rows
        {
            for (int y = 0; y < arr[x].length; y ++)// Process columns
            {
                arr[x][y] = ((x + y) * 3);// Loading up the array indexes with specified values 
            }
        }
        System.out.printf("\n");// New line before the array is printed
        display(arr);// Printing the array
        sum(arr);// Gives the sum value of all the indexes
    }


    public static void display(int[][] arr)// Displaying the array 
    {
        for (int x = 0; x < arr.length; x ++)//Creating a for loop for the array
        {
            for (int y = 0; y < arr[x].length; y ++)
            {

                int value = arr[x][y];
                String valueAsString = String.valueOf(value);// Converting the indexes to strings for alignment
                valueAsString = value + " ";

                if (valueAsString.length() == 2)// Creating an if loop to properly align the numbers
				{
                    valueAsString = " " + valueAsString;
                }
			    System.out.printf(valueAsString);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }


    public static void sum(int[][] arr)// Method to sum all of the indexes in the array and total them up 
    {
        int sum = 0;

        for (int x = 0; x < arr.length; x ++)// for loop
        {
            for (int y = 0; y < arr[x].length; y ++)
            {
                sum = sum + arr[x][y];// equation to add up the indexes
            }
        }

        System.out.printf("Sum: " + sum + "\n");
    }
    
    public static void main(String[] args)
    {

        int[][] arr = new int[15][15];//Declaring a 2d array 
        arrays(arr);

    }// End of public static void main ( String arg [])
}// End of public class 