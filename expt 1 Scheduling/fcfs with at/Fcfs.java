import java.util.*;

class Job{
	/*
		Job class contains three fields...
		jobid , arrivaltime and bursttime
	 */
	public int job_id;
	public int arrival_time;
	public int burst_time;

	// constructor
	public Job(int job_id, int arrival_time, int burst_time){
		this.job_id = job_id;
		this.arrival_time = arrival_time;
		this.burst_time = burst_time;
	}
}

public class Fcfs{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of jobs:");
		int n = sc.nextInt();

		ArrayList<Job> JobArray = new ArrayList<Job>();

		for(int i=0;i<n;i++)
		{
			System.out.println("Enter job id, arrival time and burst time");
			int job_id=sc.nextInt();
			int arrival_time=sc.nextInt();
			int burst_time=sc.nextInt();
			JobArray.add(new Job(job_id,arrival_time,burst_time));
		}

		Collections.sort(JobArray, new Comparator<Job>(){
			@Override
			public int compare(Job job1, Job job2){
				return Integer.compare(job1.arrival_time, job2.arrival_time);
			}
		});

		System.out.println("Final FCFS Sequence is:");
		int sum=0,avg_wait_time=0,turn_around_time=0;
		for (int i=0;i<JobArray.size(); i++){
			Job temp = JobArray.get(i);
			int tjob_id = temp.job_id;
			int tservice = sum + temp.burst_time;
			System.out.println("Process : "+tjob_id+"\t ======\t Service time : "+tservice);
			avg_wait_time += sum - temp.arrival_time;
			sum += temp.burst_time;
			turn_around_time += sum - temp.arrival_time;
		}
		System.out.println("Average Waiting Time "+avg_wait_time/(n*1.0)+" And Average turn_around_time : "+turn_around_time/(n*1.0));
	}
}