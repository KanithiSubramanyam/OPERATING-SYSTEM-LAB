import java.util.*;
class BankersAlgorithm
{
   
static int P = 2;

static int R = 2;

static void calculateNeed(int need[][], int maxm[][],int allot[][])
{
	for (int i = 0 ; i < P ; i++)
		for (int j = 0 ; j < R ; j++)

			need[i][j] = maxm[i][j] - allot[i][j];
    for(int i=0; i<P; i++){
        for(int j=0; j<R; j++){
            System.out.println("need"+i+" "+j+"="+need[i][j]);
        }
    }
}

static boolean isSafe(int processes[], int avail[], int maxm[][],int allot[][])
{
	int [][]need = new int[P][R];

	calculateNeed(need, maxm, allot);

	boolean []finish = new boolean[P];

	int []safeSeq = new int[P];

	int []work = new int[R];
	for (int i = 0; i < R ; i++)
		work[i] = avail[i];

	int count = 0;
    boolean found;
	while (count < P)
	{
		 found = false;
		for (int p = 0; p < P; p++)
		{
			if (finish[p] == false)
			{
				int j;
				for (j = 0; j < R; j++)
					if (need[p][j] > work[j])
						break;

				if (j == R)
				{
					for (int k = 0 ; k < R ; k++)
						work[k] += allot[p][k];

					safeSeq[count++] = p;

					finish[p] = true;

					
				}
                found = true;
			}
		}
        for (int i = 0; i < P; i++){
            for(int j=0; j<R; j++){
        if (found == false && need[i][j]<0)
        {
            System.out.print("System is not in safe state");
            return false;
        }
    }
    }
    return found;
	}


    for (int i = 0; i < P; i++){
        for(int j=0; j<R; j++){
             if (found == false && need[i][j]<0)
            {

	            System.out.print("System is in safe state.\nSafe"+" sequence is: ");
		        System.out.print(safeSeq[i] + " ");
             }
        }
	
    }
    return true;
}

public static void main(String[] args)
{

    Scanner input = new Scanner(System.in);
                    int processes[]=new int[P];
                    for(int i=0; i<P; i++){
                        processes[i]=i;
                    }
                    int avail[] = new int[P];
                    for(int i=0; i<R; i++){
            
                        System.out.print("Resoures =");
                        avail[i]=input.nextInt();
            
                    }
                    int maxm[][]= new int[P][R];
                    for(int i=0; i<P; i++){
                        for(int j=0; j<R; j++){
                            System.out.print("maximum "+i+" "+j+ "=");
                            maxm[i][j]=input.nextInt();
                        }    
                    }
                    int allot[][] = new int[P][R];
                    for(int i=0; i<P; i++){ 
                        for(int j=0; j<R; j++){
                            System.out.print("allocation "+i+" "+j+ "=");
                            allot[i][j] = input.nextInt();
                        }
                    }
	isSafe(processes, avail, maxm, allot);
}
}
