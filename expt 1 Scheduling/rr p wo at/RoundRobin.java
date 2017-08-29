import java.util.*;
class RoundRobin{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int sum,i,k,n,j,q;
        System.out.println("Ënter the number of processes:");
        n=sc.nextInt();
        int bt[]=new int[n];
        int a[]=new int[n];
        int wt[]=new int[n];
        int tat[]=new int[n];
        
        System.out.println("enter the Time Slice(in micro seconds):");
        q=sc.nextInt();
        for(i=0;i<n;i++)
        {
            System.out.println("Enter the Burst Time of p[i]"+(i+1)+":");
            bt[i]=sc.nextInt();
            
        }
       // System.out.println("Gantt Chart:");
        for(i=0;i<n;i++)
            a[i]=bt[i];
     
        do
        {
            for(i=0;i<n;i++)
            {   
                
                if(bt[i]>q)
                {
                bt[i]-=q;
                for(j=0;j<n;j++)
                    {
                    if((j!=i)&&(bt[j]!=0))
                    wt[j]=wt[j]+q;
                    }
                }
                else
                {       
                    for(j=0;j<n;j++)
                    {
                        if((j!=i)&&(bt[j]!=0))
                        wt[j]+=bt[i];
                    }
                bt[i]=0;
                }
              //  System.out.print(""+(i+1)+"->");
                
            }
              
    sum=0;
    for(k=0;k<n;k++)
        sum=sum+bt[k];
        }while(sum!=0);
        
    for(i=0;i<n;i++)
        tat[i]=wt[i]+a[i];
    System.out.println("\nprocess\t\tBT\tWT\tTAT");
    for(i=0;i<n;i++)
    {
        System.out.println("process"+(i+1)+"\t"+a[i]+"\t"+wt[i]+"\t"+tat[i]);
    }
    float avg_wt=0;
    float avg_tat=0;
    for(j=0;j<n;j++)
    {
        avg_wt+=wt[j];
    }
    for(j=0;j<n;j++)
    {
        avg_tat+=tat[j];
    }
    System.out.println("average wating time"+(avg_wt/n)+"\tAverage turn around time"+(avg_tat/n));
}
}