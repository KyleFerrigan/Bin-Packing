import java.io.IOException;
import java.util.ArrayList;

//TODO sorts disks by size remaining using PQ
//TODO Start with single disk: Put biggest files into the disks until all current disks cant fit anymore then make a new disk
public class WorstFit {
    public static void main(String args[]) throws IOException {
        ArrayList sorted;//holds sorted integers
        int pos = 0; //current sorted position
        int diskNo = 1; //disknumber incrementer


        //Sort incoming integers
        IntegerSorter intSort = new IntegerSorter();
        sorted = intSort.sort();
        
        int size = sorted.size();//makes code look cleaner and more easily understood

        //Insert first number into Disk
        Object insertDisk = new Disk(diskNo,size);//TODO what does object do to the disk class?
        diskNo++;
        ((Disk) insertDisk).addFile((Integer) sorted.get(pos));
        pos++;

        //Insert disk into Priority Queue
        MaxPQ priorQueue = new MaxPQ(size);
        priorQueue.insert(insertDisk);

        //TODO Keep inserting number into the most filled disk possible, if not possible make a new disk
        while (pos < size){
            if (((Disk)(priorQueue.max())).getSizeRemaining() >= (Integer) sorted.get(pos)){
                ((Disk)(priorQueue.max())).addFile((Integer) sorted.get(pos));
            }

        }
    }
}
