import java.util.*; 
class FCFS {
    static void findTurnAroundTime(int processes[], int n,int bt[], int tat[]) {
        tat[0]=bt[0];
        for (int i = 1; i < n; i++) {
            tat[i] = bt[i] + tat[i-1];
            }
    }
    static void findWaitingTime(int processes[], int n,int bt[], int wt[],int tat[]) {
        for (int i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
            System.out.println(tat[i]);
        }
    }
    static void findavgTime(int processes[], int n, int bt[]) {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;
        findTurnAroundTime(processes, n, bt, tat);
        findWaitingTime(processes, n, bt, wt,tat);
        System.out.print("Processes   Burst time   Waiting time   Turn around time\n");
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.printf("  %d ", (i + 1));
            System.out.printf("\t    %d ", bt[i]);
            System.out.printf("\t\t  %d", wt[i]);
            System.out.printf("\t\t  %d\n", tat[i]);
        }
        float s = (float)total_wt /(float) n;
        int t = total_tat / n;
        System.out.printf("Average waiting time = %f", s);
        System.out.printf("\n");
        System.out.printf("Average turn around time = %d ", t);
    }
 
    public static void main(String[] args)  {
        Scanner input=  new Scanner(System.in);
        int processes[] =new int[10];
        System.out.print("enter number of processes");
        int num=input.nextInt();
        for(int i=0;i<num;i++) {
            System.out.println("processes " +i+"="+(processes[i]=i+1));    
        }
        System.out.println("enter the burst time"); 
        int burst_time[] = new int[10];
        for(int i=0;i<num;i++){
        burst_time[i]=input.nextInt();
        }
        findavgTime(processes, num, burst_time);
        input.close();
    }
}