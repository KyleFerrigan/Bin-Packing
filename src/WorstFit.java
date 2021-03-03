//TODO Sort biggest to smallest text file
//TODO Put into integer array
//TODO put into disks
//TODO sorts disks by size remaining using PQ
//TODO Start with single disk: Put biggest files into the disks until all current disks cant fit anymore then make a new disk
public class WorstFit {
    public static void main(String args[]){
        int[] sorted;//holds sorted integers
        int pos = 0; //current sorted position
        int diskNo = 1; //disknumber incrementer


        //Sort incoming integers
        IntegerSorter intSort = new IntegerSorter();
        sorted = intSort.sort(); //input sorted integers to sorted

        int size = sorted.length;//makes code look cleaner and more easily undersootd

        //Insert first number into Disk
        Object insertDisk = new Disk(diskNo,size);//TODO what does object do to the disk class?
        diskNo++;
        ((Disk) insertDisk).addFile(sorted[pos]);
        pos++;

        //Insert disk into Priority Queue
        MaxPQ priorQueue = new MaxPQ(size);
        priorQueue.insert(insertDisk); //TODO how does this work?
        //TODO Keep inserting number into the most filled disk possible, if not possible make a new disk
        while (pos < sorted.length){
            if (((Disk)(priorQueue.max())).getSizeRemaining() >= sorted[pos]){
                ((Disk)(priorQueue.max())).addFile(sorted[pos]);
            }


        }

    }
}
