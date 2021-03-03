/******************************************************************************
 *  Name: Kyle Ferrigan
 *  NetID: kbferrigan
 *  Precept:  N/A
 *
 *  Partner Name: Patrick Galati
 *  Partner NetID: pagalati
 *  Partner Precept: N/A
 * 
 *  Operating system: Kyle: MacOS; Patrick: Win10
 *  Compiler: Kyle: JetBrains IntelliJ IDEA; Patrick: Netbeans
 *  Text editor / IDE: Kyle: JetBrains IntelliJ IDEA; Patrick: Netbeans
 *
 *  Have you taken (part of) this course before:
 *  Kyle: No; Patrick: No
 *  Hours to complete assignment (optional):
 *  6 hours each
 ******************************************************************************/

Programming Assignment 2
/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
If a file bigger than 1GB is inserted, will cause the Disk to say it has negative size remaining.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including
 *  classmates and friends) and attribute them by name.
 *****************************************************************************/
N/A

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
 How to properly implement MaxPQ

/******************************************************************************
 *  Unsorted vs Sorted Performance
 *****************************************************************************/
SORTED
Sum of all files: 7.288108 GB
Disks Used: 8
7 301705: 213357 137913 123456 112358 111211
6 192458: 304266 261260 242016
5 61989: 469101 468910
1 55925: 708364 235711
0 54452: 721082 224466
4 21926: 621283 356791
3 19779: 628496 351725
2 3658: 654321 342021

UNSORTED
Sum of all files: 7.288108 GB
Disks Used: 9
8 657979: 342021
7 278918: 721082
3 269639: 469101 261260
1 207766: 654321 137913
4 115613: 468910 111211 304266
0 90652: 123456 224466 112358 235711 213357
5 49620: 708364 242016
6 21926: 621283 356791
2 19779: 351725 628496

With the unsorted files using the worst fit heuristic our results show it uses more files than the sorted decreasing worst fit heuristic. You can notice that it follows the insert schema when the earliest disk IDs used in the Unsorted method is reading the text file from top to bottom. With the Sorted method, we can avoid the unnessary wasted space by properly inserting the file sizes to appropiate disk IDs to maximize disk usage.



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
The difference of disk space usage was interesting to visually see.

