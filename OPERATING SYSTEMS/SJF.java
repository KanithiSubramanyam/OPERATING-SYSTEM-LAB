import java.util.*; 
class SJF {
    static void sorting(int p[],int n,int bt[],int at[],int s[]){
        for(int i=0;i<n-1;i++)
        {
          for(int j=i+1;j<n;j++)
          {
            if(bt[i]>bt[j])
            {
                int x;
                x=bt[i];
                bt[i]=bt[j];
                bt[j]=x;
                x=at[i];
                at[i]=at[j];
                at[j]=x;
                x=p[i];
                p[i]=p[j];
                p[j]=x;
          
           }
        }
     }
    }
    static void findTurnAroundTime(int processes[], int n,int bt[], int tat[],int at[]) {
        int ct[] = new int[n];
       ct[0]=bt[0];
       tat[0]=ct[0];
        for (int i = 1; i < n; i++) {
            ct[i] = bt[i]+ct[i-1];
            tat[i] = (ct[i])-at[i];
            }
    }
    static void findWaitingTime(int processes[], int n,int bt[], int wt[],int tat[]) {
        for (int i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
        }
    }
    static void findavgTime(int processes[], int n, int bt[],int at[]) {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;
        findTurnAroundTime(processes, n, bt, tat,at);
        findWaitingTime(processes, n, bt, wt,tat);
        System.out.print("Processes   Burst time  arrival time   Waiting time   Turn around time\n");
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.printf("  %d ", processes[i]);
            System.out.printf("\t    %d ", bt[i]);
            System.out.printf("\t\t   %d ", at[i]);
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
        System.out.println("enter the Arrival time"); 
        int arrival_time[] = new int[10];
        for(int i=0;i<num;i++){
        arrival_time[i]=input.nextInt();
        }
        int sort[] = new int[num];
        sorting(processes, num, burst_time,arrival_time,sort);
        
        findavgTime(processes, num, burst_time,arrival_time);
        input.close();
    }
}
