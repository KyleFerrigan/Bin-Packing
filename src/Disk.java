//First, implement a data type Disk.java that represents a 1GB disk, and contains a list of all of the files it is sorting.
//This data type should implement the Comparable<Disk> interface so that you can use it with a priority queue.
public class Disk implements Comparable<Disk>{
    private final int diskID;
    private int sizeRemaining;
    private int[] filesArray;
    private int curFileLoc;

    public Disk(int diskIDIn, int diskSize){ // input the DiskID & the max number of files so we can set the size of filesArray
        diskID = diskIDIn; //set diskID
        sizeRemaining = 1000000; //1GB
        int[] filesArray = new int[diskSize]; //set to largest size possible given the amount of input nums
    }

    @Override
    public int compareTo(Disk that) {
        if (this.sizeRemaining < that.sizeRemaining) return -1; //if the size remaining is less than that return -1
        else if (this.sizeRemaining == that.sizeRemaining) return 0; //if sizes are the same return 0
        else return 1; //if the size remaining is greater than that return 1
    }

    public int getDiskID(){//getter method
        return diskID;
    }

    public int getSizeRemaining(){//getter method
        return sizeRemaining;
    }

    public String getFileSizesString(){ //returns all individual files sizes as string
        String temp = "";
        for (int i=0; i < filesArray.length; i++){
            temp = temp + filesArray[i] + "\n";
        }
        return temp;
    }

    public void addFile(int fileSizeIn){
        filesArray[curFileLoc] = fileSizeIn;
        curFileLoc++;
        sizeRemaining = sizeRemaining - fileSizeIn;
    }
}