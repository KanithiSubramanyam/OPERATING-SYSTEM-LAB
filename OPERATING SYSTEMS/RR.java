import java.util.Scanner;
public class RR
{
	static void findWaitingTime(int processes[], int n,int bt[], int wt[],int tat[], int quantum)
	{
		for (int i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
        }
	}
	static void findTurnAroundTime(int processes[], int n,int bt[], int tat[],int ct[]) {
        for (int i = 0; i < n; i++) {
            tat[i] = (ct[i]);
            }
    }

		static void CompilationTime(int processes[], int n,int bt[],int ct[],int quantum) {
			int rem_bt[] = new int[n];
			for (int i = 0 ; i < n ; i++){
				rem_bt[i] = bt[i];
				System.out.println(rem_bt[i]);
			}
			int temp=0;
			while(true){
				boolean done = true;
				for (int i = 0; i < n; i++){
					if(rem_bt[i]>0){
						done=false;
						if(rem_bt[i]>quantum){
							temp+=quantum;
							rem_bt[i] = rem_bt[i]-quantum;
							ct[i]=temp;
						}
						else{
							temp+=rem_bt[i];
							rem_bt[i]=0;
							ct[i]=temp;
						}
					}
				}
				if(done==true)
					break;
			}
		   
		}

	static void findavgTime(int processes[], int n, int bt[],int quantum)
	{
		int wt[] = new int[n], tat[] = new int[n],ct[]=new int[n];
		int total_wt = 0, total_tat = 0;
		    CompilationTime(processes,n,bt,ct,quantum);
			findTurnAroundTime(processes, n, bt, tat,ct);
			findWaitingTime(processes, n, bt, wt,tat, quantum);
		System.out.println("ProcessNumber " + "\tBurst time" +"\tWaitingTime " + "\tTurnAroundTime");
	
		for (int i=0; i<n; i++)
		{
			total_wt = total_wt + wt[i];
			total_tat = total_tat + tat[i];
			System.out.println(" " + (i+1) + "\t\t" + bt[i] +"   \t\t    " +wt[i] +"\t\t\t" + tat[i]);
		}
	
		System.out.println("Average waiting time = " +(float)total_wt / (float)n);
		System.out.println("Average turn around time = " +(float)total_tat / (float)n);
	}
	public static void main(String[] args)
	{
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

		System.out.println("Enter time quantum"); 
		int quantum=input.nextInt();

		findavgTime(processes, num, burst_time, quantum);
		input.close();
	}
	
}
