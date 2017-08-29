import java.util.*;

class Job{
	public int job_id;
	public int burst_time;

	public Job(int job_id, int burst_time){
		this.job_id = job_id;
		this.burst_time = burst_time;
	} 
}

class Fcfs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Jobs:");
		int n = sc.nextInt();
		ArrayList<Job> JobArray = new ArrayList<Job>();

		for(int i=0;i<n;i++){
			System.out.println("Enter Job id and burst time");
			int job_id = sc.nextInt();
			int burst_time = sc.nextInt();
			JobArray.add(new Job(job_id,burst_time));
		}

		System.out.println("Final FCFS Sequence is : ");
		int sum=0,avg_wait_time=0,turn_around_time=0;
		for(int i=0;i<JobArray.size();i++){
			Job temp = JobArray.get(i);
			int tjob_id = temp.job_id;
			int tservice = sum + temp.burst_time;
			System.out.println("Process : "+tjob_id+"\t ======\t Service time : "+tservice);
			avg_wait_time += sum;
			sum += temp.burst_time;
			turn_around_time += sum;
		}
		System.out.println("Average Waiting Time "+avg_wait_time/(n*1.0)+" And Average turn_around_time : "+turn_around_time/(n*1.0));
		}
	}
	