import java.util.ArrayList;

public class Disk implements Comparable<Disk>{
    private final int diskID;
    private int sizeRemaining;
    private ArrayList filesArray;

    public Disk(int diskIDIn){ // input the DiskID & the max number of files so we can set the size of filesArray
        diskID = diskIDIn; //set diskID
        sizeRemaining = 1000000; //1GB
        filesArray = new ArrayList(); //initialize arrayList

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

    public String getFileSizesString(){ //returns all individual files sizes as string for easy printout
        String temp = "";
        for (int i=0; i < filesArray.size(); i++){
            temp = temp + filesArray.get(i) + " ";
        }
        return temp;
    }

    public void addFile(int fileSizeIn){
        filesArray.add(fileSizeIn); //adds in the integer "file"
        sizeRemaining = sizeRemaining - fileSizeIn; //removes the filesize from the size remaining so it stays accurate
    }
}