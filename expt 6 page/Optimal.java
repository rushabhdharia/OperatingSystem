import java.util.Scanner;

public class Optimal {

    public static void main(String[] args) {
        int n,i,j=0,size,k,miss=0,hits;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Frame Size:");
        size=sc.nextInt();
        System.out.println("Enter Input Size:");
        n=sc.nextInt();
        int a[]=new int[size];
        int x[]=new int[n];
        int status[]=new int[size];
        char m[]=new char[n];
        Optimal o=new Optimal();
        for(i=0;i<n;i++)
        {
            System.out.println("Enter "+i+"th Element:");
            x[i]=sc.nextInt();
        }
        
        for(i=0;i<n;i++)
        {
            
            if(o.search(a,size,x[i],0)==999)
            {
                if(j<size)
                {
                    for(k=0;k<size;k++)
                    {
                        status[k]=o.search(x,n,a[k],i+1);
                    }
                    j=o.findmax(status,size);
                    a[j]=x[i];
                    m[i]='M';
                }
            }

            System.out.println("Element:"+x[i]);
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
     
    int findmax(int status[],int n)
    {
        int temp=0,max=0,z;
        for(z=0;z<n;z++) 
            if(status[z]>temp)
            {
                max=z;
                temp=status[z];
            }
        return max;
    }
    
    int search(int a[],int size,int x,int startpos)
    {
        int i;
        for(i=startpos;i<size;i++)
        {
            if(a[i]==x)
                return i;
        }
        return 999;
    }
}