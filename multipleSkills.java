
 //Purpose    : A program that showcases that I can efficiently create and display parallel arrays, enhanced for loops, string tokenizers, array lists, and array lists of objects


import java.util.ArrayList;

public class multipleSkills
{

    public static void parallel(int carsWeight[], String owner [], double totalMiles [])//New method named parallel that receives the arrays made in the main method
    {
        System.out.printf("\n");// Print a new line before parallel array is displayed
        for (int i = 0; i<carsWeight.length;i++)
        {
            System.out.printf(carsWeight[i] + "\t"+ owner[i]+ "\t" + totalMiles[i] + "\n");// accepting and displaying the data received
        }
        System.out.printf("\n");//print a new line after the parallel array so the question parts are easily identifiable
    }


    public static void theEnhanceForLoop(String objectArray [])//New method named theEnhancedForLoop that is passed objectArray made in the main method 
    {
        for (String j : objectArray)
        {
            System.out.printf("%s\n", j);//Search and display all data in the objectArray using an enhanced for loop
        }
        System.out.printf("\n");//print a new line after the enhancedforloop so the question parts are easily identifiable
    }


    public static void tokens()//New method named tokens 
    {
        String str1 = "Jill$Billy%Becky*Tara&Mary";// Creating string
        System.out.printf("Splitting %s delimited by [$%%*&]",str1);//Display 
        System.out.printf("%s", str1);//Display 
        String[] tokens1 = str1.split ("[$%*&]");//tokenizing the string
        for ( String s1: tokens1)//for loop
        {
            System.out.printf("\n\t " + s1);//Display 
        }
        System.out.printf("\n\n");//Creating a new line to separate the tokenizers

        String str2 ="http://gaddisbooks.com";//Create string
        System.out.printf("Splitting %s delimited by [//.}",str2);//Display 
        System.out.printf("%s",str2);//Display 
        String[] tokens2 = str2.split ("[//.]");//tokenizing the string
        for ( String s2: tokens2)//for loop
        {
            System.out.printf("\n\t"+ s2);//Display 
        }
        System.out.printf("\n");//Creating a new line to separate the tokenizers

        String str3 = "blue one red three yellow";//Creating string
        System.out.printf("\nSplitting %s delimited by ' '", str3);//Display 
        System.out.printf("%s",str3);//Display 
        String[] tokens3 = str3.split (" ");//tokenizing the string
        for ( String s3: tokens3)// for loop
        {
            System.out.printf("\n\t " + s3);//Display 
        }
        System.out.printf("\n\n");//print a new line after the string tokenizers so the question parts are easily identifiable
    }


    public static void theArrayList(int a, String java, double grade, String sem, int year)//New method named theArrayList 
    {
        ArrayList <Object> theList = new ArrayList <Object>();//Create an ArrayList of Object data type named theList 
        theList.add(a);//Adding the data that was instructed 
        theList.add(java);//Adding the data that was instructed 
        theList.add(grade);//Adding the data that was instructed 
        theList.add(sem);//Adding the data that was instructed 
        theList.add(year);//Adding the data that was instructed 
       for (int i = 0; i<theList.size(); i++)
        {
            System.out.printf("\n" + theList.get(i));//Display all data in the theList data structure 
        }
        System.out.printf("\n");//adds a line after the first display
        theList.remove(4);//Delete second and fifth records from the theList data structure 
        theList.remove(1);//Delete second and fifth records from the theList data structure 
        for (int i = 0; i<theList.size(); i++)
        {
            System.out.printf("\n" + theList.get(i));//Display all data left in the theList data structure 
        }
        System.out.printf("\n\n");
    }


    public static void theObjects(int w, String one, double x, double y, String cop3804)// New method named theObjects that accepts the data passed from the main method 
    {
        ArrayList <Object> theObjectList = new ArrayList <Object>();//Create arraylist named theObjectList 
        theObjectList.add(w);//loading the data 
        theObjectList.add(one);//loading the data 
        theObjectList.add(x);//loading the data 
        theObjectList.add(y);//loading the data 
        theObjectList.add(cop3804);//loading the data 
        System.out.printf(theObjectList.toString());//Using printf display/print the data inside the theObjectList 
        System.out.printf("\n");//Creating a new line after the entire program is displayed
    }


    public static void main(String args [])
    {
        int carsWeight[] = 
            {50102, 23908, 12098}; //Declaration/Initialization of array used in question 
        String owner[] = 
            {"Michael Hall", "Maria Lopez ", "Mo Freeman  " }; //Declaration/Initialization of array used in question 
        double totalMiles []= 
            { 104.45, 232.78, 153.07 }; //Declaration/Initialization of array used in question 
        String objectArray [] =
            {"Cats","Dogs","Fish","Bunnies","Monkeys"};//Declaration/Initialization of array used in question 

        parallel(carsWeight,owner,totalMiles);//Method for question 
        theEnhanceForLoop(objectArray);//Method for question 
        tokens();//Method for question 
        theArrayList(123,"JAVA",3.75, "Fall C",2099);//Method for question 
        theObjects(1,"one",1.4,0.25,"COP3804");//Method for passing the data
    }
}
