import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Experienced travelers know that if small items are packed last, they can fit snugly in the odd gaps in nearly filled luggage.
//This motivates a smarter strategy:  process the items from biggest to smallest.
//The worst-fit decreasing heuristic is to do worst-fit, but first preprocess the file sizes so that they are in descending order.
//A modular way to implement this heuristic is to write a separate program IntegerSorter.java that reads in a sequence of integers and prints them out in descending order.
//Then you can pipe the results through your worst-fit heuristic.
public class IntegerSorter { //TODO sort incoming integers biggest to smallest
    File file = new File("input20.txt");
    int fSize = (int)file.length();
    int[] inputFile = new int[fSize];

    public void Integersorter(){
        try{
            Scanner scan = new Scanner(file);
            for (int i = 0; scan.hasNextLine(); i++){
                inputFile[i] = scan.nextInt();
            }
            scan.close();
        }
        catch (
                FileNotFoundException e){
            System.out.println(e);
        }
    }

    public int[] sort(){
        return inputFile;
    }

}
