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
    File file = new File("input20.txt"); //Change file name for testing
    ArrayList<Integer> arr = new ArrayList<>();
    
    public IntegerSorter() throws IOException { //Scan in the file as an arraylist
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

    public ArrayList<Integer> sortDecrease(){ //Sorts the arraylist in descending order
        Collections.sort(arr, Collections.reverseOrder()); 
        return arr;
    }

    public ArrayList getUnsorted(){//getter for array
        return arr;
    }

    public int sumArray(){
        int sum = 0;
        for (int i = 0; i < arr.size(); i++){
            sum += arr.get(i);
        }
        return sum;
    }
}
