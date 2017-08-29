import java.util.*;

public class prio_pre {

    public static void main(String[] args) 
    {
        int n,i,j,s=0,total=0,temp,swt,stt,jobNo=0;
        float avgwt=0f,avgtt=0f;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of jobs:");
        n=sc.nextInt();
        int p[]=new int[n];
        int in[]=new int[n];
        int w[]=new int[n];
        int t[]=new int[n];
        int a[]=new int[n];
        int pr[]=new int[n];
        int finished[]=new int[n];
        for(i=0;i<n;i++)
        {
            System.out.println("Enter index, time of job, priority and arrival time of "+i+":");
            in[i]=sc.nextInt();
            p[i]=sc.nextInt();
            pr[i]=sc.nextInt();
            a[i]=sc.nextInt();
            total+=p[i];
        }
        int chart[]=new int[total];

            for(i=0;i<n;i++)
        {
		System.out.println(in[i]+":"+p[i]);
        }
         
        for(i=0;i<n;i++)
            for(j=0;j<n-i-1;j++)
        {
            if(pr[j] > pr[j+1])
            { 
                temp=p[j];
                p[j]=p[j+1];
                p[j+1]=temp;
                
                temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
                
                temp=in[j];
                in[j]=in[j+1];
                in[j+1]=temp;
                
                temp=pr[j];
                pr[j]=pr[j+1];
                pr[j+1]=temp;
            }
        }
           
 //        System.out.println("After Sorting acc. to priority");
 //        for(i=0;i<n;i++)
 //        {
	// System.out.println(in[i]+"\t"+a[i]+"\t"+p[i]+"("+pr[i]+")");
 //        }
        
 //        System.out.println();
        System.out.println("CHART");
        System.out.println("Interval \t Job No");
        for(i=0;i<total;i++)
        {
        for(j=0;j<n;j++)
         {
            if(a[j]<=i && p[j]!=0)
            {
               jobNo=in[j];
               p[j]-=1;
               if(p[j]==0)
                    finished[j]=i+1;
               break;
            }
            
         }
         System.out.println(i+"-"+(i+1)+"\t\t   "+jobNo);
         chart[i]=jobNo;
        } 
       //System.out.println();
       System.out.println("Waiting Time"); 
       for(i=0;i<n;i++)
        {
            swt=0;
        for(j=0;j<total;j++) 
         {
             if(chart[j]!=in[i])
             swt++;
         }
        System.out.println(in[i]+":"+(swt-a[i]-total+finished[i])); 
        avgwt+=(swt-a[i]-total+finished[i]);
       }
      
       
        System.out.println("Turn around time");
        
        for(i=0;i<n;i++)
       {
        System.out.println(in[i]+":"+(finished[i]-a[i]));
        avgtt+=(finished[i]-a[i]);
       }
        
	System.out.println("Average waiting time:"+(avgwt/n));
	System.out.println("Average turn around time:"+(avgtt/n));

    }

}