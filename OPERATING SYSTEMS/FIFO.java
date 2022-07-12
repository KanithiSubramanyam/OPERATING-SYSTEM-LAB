import java.util.*;


class FIFO
{

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("ENter size of refernce string");
        int num=input.nextInt();
        System.out.println("ENter  refernce string");
        int IS[]=new int[num];
        for(int i=0;i<num; i++)
            IS[i]=input.nextInt();
        input.close();

        int pageFaults = 0;
        int frames = 4;
        int m, n, s, pages;

        pages = num;

        System.out.println("Incoming \t Frame 1 \t Frame 2 \t Frame 3\t Frame 4");
        int temp[] = new int[frames];
        
        for(m = 0; m < frames; m++)
        {
            temp[m] = -1;
        }

        for(m = 0; m < pages; m++)
        {
            s = 0;

            for(n = 0; n < frames; n++)
            {
                if(IS[m] == temp[n])
                {
                    s++;
                    pageFaults--;
                }
            }
            pageFaults++;

            if((pageFaults <= frames) && (s == 0))
            {
                temp[m] = IS[m];
            }
            else if(s == 0)
            {
                temp[(pageFaults - 1) % frames] = IS[m];
            }

            System.out.println();
            System.out.print(IS[m] + " \t\t");
            for(n = 0; n < frames; n++)
            {
                if(temp[n] != -1)
                    System.out.print(temp[n] + " \t\t");
                else
                    System.out.print(" -1  \t\t");
            }
        }

        System.out.println("\n\nTotal Page Faults:\t" + pageFaults);
    }
}