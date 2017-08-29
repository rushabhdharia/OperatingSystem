import java.util.*;

public class Fifo {

    public static void main(String[] args) {
        int n,i,j=0,size=0,x,k,miss=0,hits=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Frame size:");
        size=sc.nextInt();
        System.out.println("Enter Input Size:");
        n=sc.nextInt();
        int a[]=new int[n];
        char m[]=new char[n];
        Fifo f=new Fifo();
        for(i=0;i<n;i++)
        {   
            System.out.println("Enter "+i+"th Element:");
            x=sc.nextInt();
            if(f.search(a,size,x)==-1)
            {
                if(j<size)
                {
                    a[j]=x;
                    j++;
                    m[i]='M';
                }
                if(j>=size)
                    j=0;
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
    
    int search(int a[],int n,int x)
    {
        int i;
        for(i=0;i<n;i++)
        {
            if(a[i]==x)
                return 1;
        }
        return -1;
    }
}