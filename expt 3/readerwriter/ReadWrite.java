import java.util.*;
import java.util.concurrent.Semaphore;

public class ReadWrite implements Runnable {
    static Semaphore mutex=new Semaphore(5);
    static Semaphore wrt=new Semaphore(1);
    static int readcount=0;
    static int readcheck=0;

    public static void main(String[] args)
    {   
       
      ReadWrite p=new ReadWrite();
     
       for(int i=1;i<=5;i++)
       {
       Thread w=new Thread(p);
       w.setName("Writer "+i);
       Thread r=new Thread(p);
        r.setName("Reader "+i);
       w.start();
       r.start();
       }
       
    }
     @Override public void run()
        {
        System.out.println(Thread.currentThread().getName()+" is waiting...");
            
         synchronized(this)
         {   
            if(Thread.currentThread().getName().contains("Writer"))
            {   
                   try 
                        {
                        wrt.acquire(); 
                        count();
                        System.out.println(Thread.currentThread().getName()+" is writing...value written="+getCount());                        

                        System.out.println("Critical section is free...");
                        wrt.release();
                        } catch (InterruptedException ex) {}
            }
            
                if(Thread.currentThread().getName().contains("Reader"))
            {                          
                    try 
                    {
                        mutex.acquire();
                        readcheck++;
                        if(readcheck==1)
                        {
                            wrt.acquire();
                            mutex.release();

                            System.out.println(Thread.currentThread().getName()+" is reading...value read="+getCount());                      
                        }
                        else
                        {
                             System.out.println(Thread.currentThread().getName()+" is reading...value read="+getCount()); 
                        }
                        mutex.acquire();
                        readcheck--;
                        System.out.println("Critical section is free...");
                        if(readcheck==0)
                            wrt.release();
                        mutex.release();
                    } catch (InterruptedException ex) {}
               
            }
        }
        }

    static void count()
    {
         readcount++;
    }
    static int getCount()
    {
        return readcount;
    }
    
}