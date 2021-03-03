import java.io.IOException;
import java.util.ArrayList;

public class WorstFit {


    public static void main(String args[]) throws IOException {
        ArrayList fileInts;//holds file integers
        int pos = 0; //current position within the fileInts to distribute into disks
        int diskNo = 0; //disk number incrementer

        //Sort incoming integers
        IntegerSorter intSort = new IntegerSorter(); //Constructs IntegerSorter
        //fileInts = intSort.getUnsorted(); //Use this for having an unsorted Array, comment out line below
        fileInts = intSort.sortDecrease();//Use this for having a sorted Array, comment out line above

        int size = fileInts.size();//makes code look cleaner and more easily understood

        //Initialize Priority Queue's
        MaxPQ mainQueue = new MaxPQ(size);
        MaxPQ tempQueue = new MaxPQ(size);//used as a temporary cache as things are taken off the main queue if the current file doesnt fit on the main queue

        //Keep inserting number into the most filled disk possible, if not possible make a new disk
        while (pos < size){
            if(mainQueue.isEmpty()){//if main queue is empty make new disk as it means no disks were big enough
                Object newDisk = new Disk(diskNo);
                diskNo++;

                ((Disk)newDisk).addFile((Integer)fileInts.get(pos));
                pos++;//increment pos as we have added the "file" into a Disk

                mainQueue.insert(newDisk);//insert the new disk into the main Queue

                while (!tempQueue.isEmpty()){//since we added a file we must merge the queues to check the next file against all of the disks
                    mainQueue.insert(tempQueue.delMax());//flush tempQueue back into mainQueue
                }
            }
            else if (((Disk)(mainQueue.max())).getSizeRemaining() >= (Integer)fileInts.get(pos)){ //check the top entry in the main queue and sees if we can insert it without going over size limit
                ((Disk)(mainQueue.max())).addFile((Integer)fileInts.get(pos));//insert into disk currently on top of main queue
                pos++;//increment pos as we have added the "file" into a Disk

                while (!tempQueue.isEmpty()){//since we added a file we must merge the queues to check the next file against all of the disks
                    mainQueue.insert(tempQueue.delMax());//flush tempQueue back into mainQueue
                }
            }
            else{ //if we cant insert our file into the top of the main queue
                tempQueue.insert(mainQueue.delMax()); //delete the top of the main queue exposing the next item, store temporarily in tempQueue
            }
        }

        //Print out Data
        System.out.println("Sum of all files: " + (intSort.sumArray()/1000000.0) + " GB");
        System.out.println("Disks Used: " + (diskNo));
        while (!mainQueue.isEmpty()) {
            System.out.println(((Disk) mainQueue.max()).getDiskID() + " " + ((Disk) mainQueue.max()).getSizeRemaining() + ": " + ((Disk) mainQueue.delMax()).getFileSizesString()); //Diles deleted off the main queue after fetching all needed information to print
        }
    }
}
