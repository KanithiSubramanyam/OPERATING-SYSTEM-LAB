import java.util.*;
class DeadLockAvoidance{
    int p;
    int r;
    public void isSafe(int pr[] ,int avail[],int max[][] ,int allocated[][]){
        int need[][]=new int[p][r];
        calculateNeed(pr, avail, max);
    }
    public void calculateNeed(int pr[] ,int avail[],int max[][]){

    }
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
   
    
    System.out.println("Number of process=");
    p=input.nextInt();
    System.out.println("Number of resources=");
    r=input.nextInt();

        int prs[]=new int[p];
        for(int i=0; i<p; i++){
            prs[i]=i;
        }
        int available[] = new int[r];
        for(int i=0; i<r; i++){

            System.out.print("Resoures %d =");
            available[i]=input.nextInt();

        }
        int Maximum[][]= new int[p][r];
        for(int i=0; i<p; i++){
            for(int j=0; j<r; j++){
                Maximum[i][j]=input.nextInt();
            }    
        }
        int allocated[][] = new int[p][r];
        for(int i=0; i<p; i++){ 
            for(int j=0; j<r; j++){
                allocated[i][j] = input.nextInt();
            }
        }
        DeadLockAvoidance da= new   DeadLockAvoidance();
        da.isSafe(prs,available,Maximum,allocated);
        input.close();
}

   

}