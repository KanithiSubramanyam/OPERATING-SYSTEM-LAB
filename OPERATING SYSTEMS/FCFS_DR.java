import java.util.Scanner;
class FCFS_DR{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int seek=0,diff=0,head=0;
        float avg;
        System.out.println("Enter queue size");
        int queueSize = input.nextInt();
        System.out.println("Enter queue");
        int queue[]=new int[queueSize+1];
        for(int i=1; i<queueSize; i++){
            queue[i] = input.nextInt();
        }
        System.out.println("Enter the head Position");
        head = input.nextInt();
        queue[0]=head;
        for(int j=0; j<queueSize; j++){
            diff = Math.abs(queue[j+1]-queue[j]);
            seek += diff;
            System.out.println("Move " +queue[j] + " to " + queue[j+1] + " with seek " + diff);
            System.out.println("Total Seek time is " + seek);
            avg = seek/(float)queueSize;
            System.out.println("Average seek time is " +avg);
    
        }
    }
}