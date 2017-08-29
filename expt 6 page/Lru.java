import java.util.Scanner;

public class Lru {

    public static void main(String[] args) {
        int n,i,j=0,size,x,k,index,count=0,z,temp,min,miss=0,hits=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Frame Size:");
        size=sc.nextInt();
        System.out.println("Enter Input Size:");
        n=sc.nextInt();
        int a[]=new int[size];
        int status[]=new int[size];
        char m[]=new char[n];
        Lru l=new Lru();
        for(i=0;i<n;i++)
        {   
            System.out.println("Enter "+i+"th Element:");
            x=sc.nextInt();
            
            index=l.search(a,size,x);
            if(index!=-1)                   //element already present
            {
            	//a[index]=x;                 //not reqd tho
                status[index]=++count;
            }
            else
           	{
                j=l.findmin(status,size);
                a[j]=x;
                status[j]=++count; 
                m[i]='M';
            }

            System.out.println("Result");
            for(k=0;k<size;k++)
                System.out.print(a[k]+" ");
            System.out.print(m[i]);
            System.out.println();  
        }
        
        for(i=0;i<n;i++)
        {
            if(m[i]=='M')
                miss++;
        }
       hits=n-miss;
       System.out.println(); 
       System.out.println("Page faults:"+miss+"\nFault %:"+(100.0*miss/n)+"%");
       System.out.println("Page hits:"+hits+"\nHit %:"+(100.0*hits/n)+"%");
    }
    
    
    int findmin(int status[],int size)
    {
        int temp=status[0];
        int min=0,z;
        for(z=1;z<n;z++) 
            if(status[z]<temp)
            {
                min=z;
                temp=status[z];
            }
        return min;
    }
    
    int search(int a[],int n,int x)
    {
        int i;
        for(i=0;i<n;i++)
        {
            if(a[i]==x)
                return i;
        }
        return -1;
    }
}
