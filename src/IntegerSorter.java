import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IntegerSorter {
    File file = new File("input20.txt"); //Change file name for testing purposes
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

    public ArrayList getUnsorted(){ //getter for array
        return arr;
    }

    public int sumArray(){ //sums the array
        int sum = 0;
        for (int i = 0; i < arr.size(); i++){
            sum += arr.get(i);
        }
        return sum;
    }
}
