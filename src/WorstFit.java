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

        //Insert first number into Disk
        Object insertDisk = new Disk(diskNo);//TODO what does object do to the disk class?
        diskNo++;
        ((Disk) insertDisk).addFile((Integer) sorted.get(pos));
        pos++;

        //Insert disk into Priority Queue
        MaxPQ priorQueue = new MaxPQ(size);
        priorQueue.insert(insertDisk);

        MaxPQ tempQueue = new MaxPQ(size);

        //TODO Keep inserting number into the most filled disk possible, if not possible make a new disk
        while (pos < size){
            if(priorQueue.isEmpty()){//if main Queue is empty make new disk as it means no disks were big enough
                Object newDisk = new Disk(diskNo);
                diskNo++;
                ((Disk) newDisk).addFile((Integer) sorted.get(pos));
                pos++;
                priorQueue.insert(newDisk);
                while (tempQueue.isEmpty()==false){
                    priorQueue.insert(tempQueue.delMax());//flush tempQueue back into mainQueue
                }
            }
            if (((Disk)(priorQueue.max())).getSizeRemaining() >= (Integer) sorted.get(pos)){
                ((Disk)(priorQueue.max())).addFile((Integer) sorted.get(pos));
                pos++;
                while (!tempQueue.isEmpty()){
                    priorQueue.insert(tempQueue.delMax());//flush tempQueue back into mainQueue
                }
            }
            else{
                tempQueue.insert(priorQueue.delMax());
            }
        }
    }
}
