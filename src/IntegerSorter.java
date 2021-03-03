import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Experienced travelers know that if small items are packed last, they can fit snugly in the odd gaps in nearly filled luggage.
//This motivates a smarter strategy:  process the items from biggest to smallest.
//The worst-fit decreasing heuristic is to do worst-fit, but first preprocess the file sizes so that they are in descending order.
//A modular way to implement this heuristic is to write a separate program IntegerSorter.java that reads in a sequence of integers and prints them out in descending order.
//Then you can pipe the results through your worst-fit heuristic.

public class IntegerSorter {
    File file = new File("input20.txt");
    ArrayList<Integer> arr = new ArrayList<>();
    
    public IntegerSorter() throws IOException{
        try{
            Scanner scan = new Scanner(file);
            while (scan.hasNext()){
                arr.add(scan.nextInt());
            }
            scan.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

    public ArrayList<Integer> sort(){
        Collections.sort(arr, Collections.reverseOrder()); //Sorts the arraylist in descending order
        return arr;
    }
}
