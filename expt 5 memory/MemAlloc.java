import java.util.*;

public class MemAlloc {

    public static void main(String[] args) 
    {
        MemAlloc m=new MemAlloc();
        int i,j,k,l,nh,np,op,intfrag=0,extfrag=0,left_process=0,left_sum=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of holes:");
        nh=sc.nextInt();
        int hole[]=new int[nh];
        int alloc[][]=new int[2][nh];
        boolean check_hole[]=new boolean[nh];
            for(i=0;i<nh;i++)
            {
                System.out.println("Enter size of hole "+i+":");
                hole[i]=sc.nextInt();
            }
        System.out.println("Enter no. of processes:");
        np=sc.nextInt();
        left_process=np;
        int process[]=new int[np];
        boolean check_process[]=new boolean[np];
        for(i=0;i<np;i++)
            {
                System.out.println("Enter size of process "+i+":");
                process[i]=sc.nextInt();
            }
        System.out.println("Size of processes:");
        for(i=0;i<np;i++)
                System.out.println(process[i]);
        
        System.out.println("Size of holes");
        for(i=0;i<nh;i++)
                System.out.println(hole[i]);
       
       do
       { 
        System.out.println("\n1.First Fit\n2.Best Fit\n3.Worst Fit\n4.Exit\nChoose an option:");
        op=sc.nextInt();
         
        switch(op)
        {
            case 1: System.out.println("***First Fit***");
                    for(i=0;i<np;i++)
                    for(j=0;j<nh;j++)
                    {
                        if(process[i]<=hole[j]&&check_hole[j]==false)
                        {
                            check_hole[j]=true;
                            System.out.println("P"+process[i]+"-->H"+hole[j]); 
                            check_process[i]=true;
                            left_process--;
                            intfrag+=(hole[j]-process[i]);
                            break;
                        } 
                    } 
  
                    
                     for(i=0;i<np;i++)
                        if(check_process[i]==false)
                            System.out.println("P"+process[i]+" Not executed");
                    System.out.println("Internal Fragmentation="+intfrag); 
                                   
                    break; 
                
            case 2: System.out.println("***Best Fit***");
                    for(i=0;i<nh;i++)                               //size of hole
                        alloc[1][i]=hole[i];
                    for(i=0;i<nh;i++)                               //index
                        alloc[0][i]=i;
    
                    Arrays.fill(check_hole,false);                  //re-initialize check_hole to false
                    Arrays.fill(check_process,false);               //re-initialize check_process to false
                    intfrag=0;
                    extfrag=0;
                    for(i=0;i<nh-1;i++)                             //sort acc to hole size
                    for(j=0;j<nh-1;j++)
                    {
                        if(alloc[1][j+1] < alloc[1][j])
                        {
                            k=alloc[1][j+1];
                            alloc[1][j+1]=alloc[1][j];
                            alloc[1][j]=k;
                            
                            l=alloc[0][j+1];
                            alloc[0][j+1]=alloc[0][j];
                            alloc[0][j]=l;   
                        }
                    }
    
                    for(i=0;i<np;i++)
                    for(j=0;j<nh;j++)
                    {
                        if(process[i]<=alloc[1][j] && check_hole[alloc[0][j]]==false)
                        {
                            check_hole[alloc[0][j]]=true;
                            System.out.println("P"+process[i]+"-->H"+alloc[1][j]); 
                            check_process[i]=true;
                            left_process--;
                            intfrag+=(alloc[1][j]-process[i]);
                            break;
                        } 
                    } 
  
                   for(i=0;i<nh-1;i++)                             //sort acc to index
                   for(j=0;j<nh-1;j++)
                    {
                        if(alloc[0][j+1] < alloc[0][j])
                        {
                            k=alloc[1][j+1];
                            alloc[1][j+1]=alloc[1][j];
                            alloc[1][j]=k;
                            
                            l=alloc[0][j+1];
                            alloc[0][j+1]=alloc[0][j];
                            alloc[0][j]=l;   
                        }
                    }      
                  
 
                    for(i=0;i<np;i++)
                        if(check_process[i]==false)
                            System.out.println("P"+process[i]+" Not executed");
                    System.out.println("Internal Fragmentation="+intfrag); 
                          
                    break; 
                
            
           case 3:  System.out.println("***Worse Fit***");
                    for(i=0;i<nh;i++)                               //size of hole
                        alloc[1][i]=hole[i];
                    for(i=0;i<nh;i++)                               //index
                        alloc[0][i]=i;
                            
                    Arrays.fill(check_hole,false);                  //re-initialize check_hole to false
                    Arrays.fill(check_process,false);               //re-initialize check_process to false
                    intfrag=0;
                    extfrag=0;
                    for(i=0;i<nh-1;i++)                             //sort acc to hole size
                    for(j=0;j<nh-1;j++)
                    {
                        if(alloc[1][j+1] > alloc[1][j])
                        {
                            k=alloc[1][j+1];
                            alloc[1][j+1]=alloc[1][j];
                            alloc[1][j]=k;
                            
                            l=alloc[0][j+1];
                            alloc[0][j+1]=alloc[0][j];
                            alloc[0][j]=l;   
                        }
                    }
     
                    for(i=0;i<np;i++)
                    for(j=0;j<nh;j++)
                    {
                        if(process[i]<=alloc[1][j] && check_hole[alloc[0][j]]==false)
                        {
                            check_hole[alloc[0][j]]=true;
                            System.out.println("P"+process[i]+"-->H"+alloc[1][j]); 
                            check_process[i]=true;
                            left_process--;
                            intfrag+=(alloc[1][j]-process[i]);
                            break;
                        } 
                    } 
  
                   for(i=0;i<nh-1;i++)                             //sort acc to index
                   for(j=0;j<nh-1;j++)
                    {
                        if(alloc[0][j+1] < alloc[0][j])
                        {
                            k=alloc[1][j+1];
                            alloc[1][j+1]=alloc[1][j];
                            alloc[1][j]=k;
                            
                            l=alloc[0][j+1];
                            alloc[0][j+1]=alloc[0][j];
                            alloc[0][j]=l;   
                        }
                    }      
                  
 
                    for(i=0;i<np;i++)
                        if(check_process[i]==false)
                            System.out.println("P"+process[i]+" Not executed");
                    System.out.println("Internal Fragmentation="+intfrag); 
                          break;
             
            case 4: break;
            
            default: break;
             
        }
       }while(op!=4);
    }
    
}
