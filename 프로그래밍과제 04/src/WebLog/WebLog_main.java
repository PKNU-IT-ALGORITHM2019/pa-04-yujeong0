package WebLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class WebLog_main {
	static int num = 10000000;
	static WebLog[] weblogs = new WebLog[num];
	static int n = 0;	// number of weblogs
	static int flag = 0;	// when flag == -1 , sort by time. when flag == 1, sort by IP.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("$ ");
			String command = sc.next();
			if(command.compareToIgnoreCase("read") == 0) {
				String filename = sc.next();
				read(filename);
			}
			else if(command.compareToIgnoreCase("sort") == 0) {
				String str = sc.next();
				str = str.replace("-", "");
				sort(str);
			}
			else if(command.compareToIgnoreCase("print") == 0) {
				print();
			}
			else if(command.compareToIgnoreCase("exit") == 0) {
				break;
			}
		}
		sc.close();
	}
	static void read(String filename) {
		try {
			Scanner sc = new Scanner(new File(filename));
			String[] tmp = new String[4];
			
			String str = sc.nextLine();
			while(sc.hasNext()) {
				str = sc.nextLine();
				tmp = str.split(",");
				weblogs[n++] = new WebLog(tmp[0], tmp[1], tmp[2], tmp[3]);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("No File");
		}
	}
	static void sort(String str) {
		if(str.compareToIgnoreCase("t") == 0) {
			flag = -1;
			Arrays.sort(weblogs, WebLog.timeComparator);
		}
		else if(str.compareToIgnoreCase("ip") == 0) {
			flag = 1;
			Arrays.sort(weblogs, WebLog.ipComparator);
		}
	}
	static void print() {
		if(flag == 0) {
			for(int i = 0; i < n; i++) {
				System.out.println("IP : " + weblogs[i].IP);
				System.out.println("Time : " + weblogs[i].Time);
				System.out.println("URL : " + weblogs[i].URL);
				System.out.println("Status : " + weblogs[i].Status);
				System.out.println();
			}
		}
		else if(flag == -1) {
			for(int i = 0; i < n; i++) {
				System.out.println(weblogs[i].Time);
				System.out.println("	IP : " + weblogs[i].IP);
				System.out.println("	URL : " + weblogs[i].URL);
				System.out.println("	Status : " + weblogs[i].Status);
				System.out.println();
			}
		}
		else { // flag == 1
			for(int i = 0; i < n; i++) {
				System.out.println(weblogs[i].IP);
				System.out.println("	Time : " + weblogs[i].Time);
				System.out.println("	URL : " + weblogs[i].URL);
				System.out.println("	Status : " + weblogs[i].Status);
				System.out.println();
			}
		}
		
		
	}
}
