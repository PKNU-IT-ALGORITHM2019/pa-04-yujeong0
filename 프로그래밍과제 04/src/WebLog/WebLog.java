package WebLog;

import java.util.Comparator;

public class WebLog {
	public String IP,Time,URL,Status;
	
	public WebLog(String IP, String Time, String URL, String Status) {
		this.IP = IP;	this.Time = Time;
		this.URL = URL;	this.Status = Status;
	}
	
	public static Comparator<WebLog> timeComparator = new Comparator<WebLog>() {
		public int compare(WebLog l1, WebLog l2) {
			try {
				String[] st1 = l1.Time.substring(1).split("/|:");
				String[] st2 = l2.Time.substring(1).split("/|:");

				int y1 = Integer.parseInt(st1[2]),  y2 = Integer.parseInt(st2[2]);
				if(y1 != y2) return y1 - y2; // 년

				int m1 = change(st1[1]), m2 = change(st2[1]);
				if(m1 != m2) return m1 - m2;	// 월

				int d1 = Integer.parseInt(st1[0]),  d2 = Integer.parseInt(st2[0]);
				if(d1 != d2) return d1 - d2; // 일

				int h1 = Integer.parseInt(st1[3]),  h2 = Integer.parseInt(st2[3]);
				if(h1 != h2) return h1 - h2; // 시

				int mi1 = Integer.parseInt(st1[4]),  mi2 = Integer.parseInt(st2[4]);
				if(mi1 != mi2) return mi1 - mi2; // 분

				int s1 = Integer.parseInt(st1[5]),  s2 = Integer.parseInt(st2[5]);
				return s1 - s2; // 초
			} catch(NullPointerException npe) {
				return 0;
			}
		}
		public int change(String s) {
			if(s.equals("Jan")) return 1;
			else if(s.equals("Feb")) return 2;
			else if(s.equals("Mar")) return 3;
			else if(s.equals("Apr")) return 4;
			else if(s.equals("May")) return 5;
			else if(s.equals("Jun")) return 6;
			else if(s.equals("Jul")) return 7;
			else if(s.equals("Aug")) return 8;
			else if(s.equals("Sep")) return 9;
			else if(s.equals("Oct")) return 10;
			else if(s.equals("Nov")) return 11;
			else return 12;
		}
	};
	public static Comparator<WebLog> ipComparator = new Comparator<WebLog>(){
		public int compare(WebLog l1, WebLog l2) {
			try {
				String[] st1 = l1.IP.split("\\.");
				String[] st2 = l2.IP.split("\\.");

				int i = 0;
				while(i < 4) {
					int n1 = Integer.parseInt(st1[i]);
					int n2 = Integer.parseInt(st2[i]);
					if(n1 != n2) return n1 - n2;
					i++;
				}}
			catch(NullPointerException npe) {
				return 0;
			}
			
			return timeComparator.compare(l1, l2);
		}
	};
	
}
