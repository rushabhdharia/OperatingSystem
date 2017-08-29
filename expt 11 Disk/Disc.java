import java.util.*;

class Disc{
	public static void main(String[] args) {
		int i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of tracks:");
		int n = sc.nextInt();
		int tracks[] = new int [n];
		System.out.println("Enter tracks:");
		for(i = 0; i < n; i++)
			tracks[i] = sc.nextInt();
		System.out.println("Enter starting track:");
		int start = sc.nextInt();
		System.out.println("Enter option:");
		System.out.println("1. FIFO \n2. SSTF\n3. SCAN \n4. C-SCAN\n5. LOOK\n6. C-LOOK");
		int op = sc.nextInt();
		switch(op){
			case 1:	fifo(tracks, start, n);break;
			case 2: sstf(tracks,start, n);break;
			case 3: scan(tracks,start,n);break;
			case 4: cscantracks,start,n);break;
			 case 5: look(tracks,start,n);break;
			 case 6: clook(tracks,start,n);break;
		}
	}

	static void fifo(int[] tracks,int start, int n){
		int i, previous = start, diff;
		float sum = 0, avg;
		System.out.println("Track\tNo of tracks traversed");
		for(i = 0; i < n; i++){			
			diff = tracks[i] - previous;
			diff = diff > 0?diff: - diff;
			System.out.println(tracks[i]+"\t"+diff);
			sum += diff;
			previous = tracks[i];
		}
		avg = sum/n;
		System.out.println("Total number of tracks traversed: "+sum+
				"\nAverage: number of tracks traversed: "+avg);
	}

	static void sstf(int[] tracks,int start, int n) {
		int i, j, previous = start, min, diff, pos = -1, k = -1;
		boolean visited[] = new boolean[n];
		float sum = 0, avg;
		System.out.println("Track\tNo of tracks traversed");
		for(i = 0; i < n; i++){
			min = 999;
			for(j = 0; j < n; j++){
				if (j == k || visited[j])	continue;
				diff = tracks[j] - previous;
				diff = diff > 0?diff: - diff;
				if(diff < min){
					min = diff;
					pos = j;
				}
			}
			visited[pos] = true;		
			System.out.println(tracks[pos]+"\t"+min);
			sum += min;
			previous = tracks[pos];
			k = pos;
		}
		avg = sum/n;
		System.out.println("Total number of tracks traversed: "+sum+
				"\nAverage: number of tracks traversed: "+avg);		
	}

	static void scan(int[] tracks,int start, int n) {
		n+=1;
		Scanner sc = new Scanner(System.in);
		int a=tracks.length;
		System.out.println("Enter Total disc length:");
		int total = sc.nextInt();
		int tracks1[] = new int[a+1];
		for(int i=0;i<a;i++)
			tracks1[i]=tracks[i];
		tracks1[a]=total-1;
		Arrays.sort(tracks1);
		int i, j, previous = start, min, diff, pos = -1;
		boolean visited[] = new boolean[n];
		float sum = 0, avg;
		for(i = 0; i < n; i++)
			if(tracks1[i] > start)	
				break;
		pos = i;
		System.out.println("Track\tNo of tracks traversed");
		for(;i < n; i++)
		{
			diff = tracks1[i] - previous;
			diff = diff > 0?diff: - diff;
			System.out.println(tracks1[i]+"\t"+diff);
			sum += diff;
			previous = tracks1[i];
		}
		for(i = pos - 1; i >= 0; i-- )
		{
				diff = tracks1[i] - previous;
			diff = diff > 0?diff: - diff;
			System.out.println(tracks1[i]+"\t"+diff);
			sum += diff;
			previous = tracks1[i];
		}
		
		avg = sum/(n-1);
		System.out.println("Total number of tracks traversed: "+sum+
				"\nAverage: number of tracks traversed: "+avg);		
	}

	static void cscan(int[] tracks,int start, int n) {
		n+=1;
		Scanner sc = new Scanner(System.in);
		int a=tracks.length;
		int tracks1[] = new int[a+1];
		for(int i=0;i<a;i++)
		tracks1[i]=tracks[i];
		tracks1[a]=0;
		Arrays.sort(tracks1);
		int i, j, previous = start, min, diff, pos = -1;
		boolean visited[] = new boolean[n];
		float sum = 0, avg;
		for(i = n-1; i >= 0; i--)
			if(tracks1[i] < start)	
				break;
		pos = i;
		System.out.println("Track\tNo of tracks traversed");
		for(;i >=0 ; i--)
		{
			diff = tracks1[i] - previous;
			diff = diff > 0?diff: - diff;
			System.out.println(tracks1[i]+"\t"+diff);
			sum += diff;
			previous = tracks1[i];
		}
		for(i = n-1; i >= pos + 1; i--)
		{
				diff = tracks1[i] - previous;
			diff = diff > 0?diff: - diff;
			System.out.println(tracks1[i]+"\t"+diff);
			sum += diff;
			previous = tracks1[i];
		}
		
		avg = sum/n;
		System.out.println("Total number of tracks traversed: "+sum+
				"\nAverage: number of tracks traversed: "+avg);
		
	}

	static void look(int[] tracks,int start, int n) {
		Arrays.sort(tracks);
		int i, j, previous = start, min, diff, pos = -1;
		boolean visited[] = new boolean[n];
		float sum = 0, avg;
		for(i = n-1; i >= 0; i--)
			if(tracks[i] < start)	
				break;
		pos = i;
		System.out.println("Track\tNo of tracks traversed");
		for(;i >=0 ; i--)
		{
			diff = tracks[i] - previous;
			diff = diff > 0?diff: - diff;
			System.out.println(tracks[i]+"\t"+diff);
			sum += diff;
			previous = tracks[i];
		}
		for(i = pos + 1; i < n; i++)
		{
				diff = tracks[i] - previous;
			diff = diff > 0?diff: - diff;
			System.out.println(tracks[i]+"\t"+diff);
			sum += diff;
			previous = tracks[i];
		}
		
		avg = sum/n;
		System.out.println("Total number of tracks traversed: "+sum+
				"\nAverage: number of tracks traversed: "+avg);		
	}

	static void clook(int[] tracks,int start, int n) {
		Arrays.sort(tracks);
		int i, j, previous = start, min, diff, pos = -1;
		boolean visited[] = new boolean[n];
		float sum = 0, avg;
		for(i = 0; i < n; i++)
			if(tracks[i] > start)	
				break;
		pos = i;
		System.out.println("Track\tNo of tracks traversed");
		for(;i < n; i++)
		{
			diff = tracks[i] - previous;
			diff = diff > 0?diff: - diff;
			System.out.println(tracks[i]+"\t"+diff);
			sum += diff;
			previous = tracks[i];
		}
		for(i = 0; i < pos; i++ )
		{
				diff = tracks[i] - previous;
			diff = diff > 0?diff: - diff;
			System.out.println(tracks[i]+"\t"+diff);
			sum += diff;
			previous = tracks[i];
		}
		
		avg = sum/n;
		System.out.println("Total number of tracks traversed: "+sum+
				"\nAverage: number of tracks traversed: "+avg);		
	}
}