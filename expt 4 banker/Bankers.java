import java.util.*;
class Bankers
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of processes:");
		int p=sc.nextInt();//p=number of processes
		System.out.println("Enter number of resources:");
		int r=sc.nextInt();//r=number of resources
		int a[][]=new int[p][r];//allocation matrix
		int m[][]=new int[p][r];//maximum matrix
		int n[][]=new int[p][r];//need matrix
		int total[]=new int[r];//total instances or resources
		int avail[]=new int[r];//available instances array
		System.out.println("Enter the total number of instances for the following resources:");
		int i,j,deadlock=0,counter=0,finishall=0;
		//take total number of instances of each resource from user
		for(i=0;i<r;i++)
		{
			System.out.print("\nR"+(i+1)+": ");
			total[i]=sc.nextInt();
		}
		System.out.println("Enter allocation matrix:");
		for(i=0;i<p;i++)
		{
			for(j=0;j<r;j++)
			{
				a[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter maximum matrix:");
		for(i=0;i<p;i++)
		{
			for(j=0;j<r;j++)
			{
				m[i][j]=sc.nextInt();
			}
		}
		//calculation of need matrix
		for(i=0;i<p;i++)
		{
			for(j=0;j<r;j++)
			{
				n[i][j]=m[i][j]-a[i][j];
			}
		}
		//displaying need matrix
		System.out.print("\nneed matrix=\n");
		for(i=0;i<p;i++)
		{
			for(j=0;j<r;j++)
			{
				System.out.print(" "+n[i][j]);
			}
			System.out.println();
		}
		//calculation of available array
		for(j=0;j<r;j++)
		{	
			avail[j]=0;
			for(i=0;i<p;i++)
			{
				avail[j]+=a[i][j];
			}
			avail[j]=total[j]-avail[j];
		}
		//displaying available matrix
		System.out.print("\navailable matrix=\n");
		for(j=0;j<r;j++)
		{
			System.out.print(" "+avail[j]);
		}
		
		
		int finish[]=new int[p];//flag to indicate if process has terminated(1) or not(0)
		for(i=0;i<p;i++)
			finish[i]=0;//initializing
		//finding safe sequence
		do
		{	
			counter=0;
			for(i=0;i<p;i++)
			{
				if(finish[i]==0)
				{
					for(j=0;j<r;j++)
					{
						if(n[i][j]>avail[j])
							break;
					}
					if(j==r)
					{
						//add process to sequence
						System.out.print("\nprocess "+(i+1));
						for(j=0;j<r;j++)
						{
							avail[j]=avail[j]+a[i][j];
						}
						finish[i]=1;
						System.out.println();
						for(j=0;j<r;j++)
						{
							System.out.print(avail[j]+" ");
						}
					}
					else
					{
						counter++;
					}
				}
				else
				{
					counter++;
				}
			}
			for(j=0;j<p;j++)
			{
				if(finish[j]==0)
					break;
			}
			if(j==p)
				finishall=1;
			else if(counter==p)
					deadlock=1;
			
		}while(deadlock!=1 && finishall!=1);
		if(deadlock==1)
			System.out.print("\nThe system has entered deadlock");
		else
			System.out.print("\nnThe system is in safe state");		
	}
}	