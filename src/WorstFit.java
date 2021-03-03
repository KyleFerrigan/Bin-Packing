import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WorstFit {
    public static void main(String args[]) throws FileNotFoundException{
        File file = new File("input20.txt");
        try{
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()){
                int digit = scan.nextInt();
                System.out.println(digit);
            }
            scan.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
        //TODO Sort biggest to smallest text file
        //TODO Start with single disk: Put biggest files into the disks until all current disks cant fit anymore then make a new disk
    }
}
