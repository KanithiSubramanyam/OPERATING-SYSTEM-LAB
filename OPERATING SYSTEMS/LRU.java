import java.util.*;

public class LRU {
	
	public static void main(String[] args) {
		int capacity = 4;
        Scanner input = new Scanner(System.in);
        System.out.println("ENter size of refernce string");
        int num=input.nextInt();
        System.out.println("ENter  refernce string");
        int IS[]=new int[num];
        for(int i=0;i<num; i++)
            IS[i]=input.nextInt();		
		ArrayList<Integer> s=new ArrayList<>(capacity);
		int count=0;
		int page_faults=0;
		for(int i:IS)
		{
			if(!s.contains(i))
			{
			
          
			    if(s.size()==capacity)
			    {
				    s.remove(0);
				    s.add(capacity-1,i);
			    }
			    else
				    s.add(count,i);
				    page_faults++;
				    ++count;		
			    }
			else
			{
				s.remove((Object)i);
				s.add(s.size(),i);		
			}
		
		}
		System.out.println("Page Faults = "+page_faults);
        input.close();

	}
}
