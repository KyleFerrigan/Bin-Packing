import java.io.IOException;
import java.util.ArrayList;

//TODO sorts disks by size remaining using PQ
//TODO Start with single disk: Put biggest files into the disks until all current disks cant fit anymore then make a new disk
public class WorstFit {


    public static void main(String args[]) throws IOException {
        ArrayList sorted;//holds sorted integers
        int pos = 0; //current position within the sorted number to distribute into disks
        int diskNo = 1; //disk number incrementer

        //Sort incoming integers
        IntegerSorter intSort = new IntegerSorter();
        sorted = intSort.sortDecrease();
        int size = sorted.size();//makes code look cleaner and more easily understood

        //Init Priority Queue's
        MaxPQ mainQueue = new MaxPQ(size);
        MaxPQ tempQueue = new MaxPQ(size);

        //TODO Keep inserting number into the most filled disk possible, if not possible make a new disk
        while (pos < size){
            if(mainQueue.isEmpty()){//if main Queue is empty make new disk as it means no disks were big enough
                Object newDisk = new Disk(diskNo);
                diskNo++;
                ((Disk) newDisk).addFile((Integer) sorted.get(pos));
                pos++;
                mainQueue.insert(newDisk);
                while (!tempQueue.isEmpty()){
                    mainQueue.insert(tempQueue.delMax());//flush tempQueue back into mainQueue
                }
            }
            if (((Disk)(mainQueue.max())).getSizeRemaining() >= (Integer) sorted.get(pos)){ //check the top entry prior queue and sees if we can insert it
                ((Disk)(mainQueue.max())).addFile((Integer) sorted.get(pos));
                pos++;
                while (!tempQueue.isEmpty()){
                    mainQueue.insert(tempQueue.delMax());//flush tempQueue back into mainQueue
                }
            }
            else{ //if we cant insert our file into the max size of
                tempQueue.insert(mainQueue.delMax());
            }
        }
        System.out.println("Sum of all files: " + (intSort.sumArray()/1000000.0) + "GB");
        System.out.println("Disks Used: " + (diskNo-1));
        while (!mainQueue.isEmpty()) {
            System.out.println(((Disk) mainQueue.max()).getDiskID() + " " + ((Disk) mainQueue.max()).getSizeRemaining() + ": " + ((Disk) mainQueue.delMax()).getFileSizesString());
        }
    }
}
