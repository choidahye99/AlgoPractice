

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int M; //연산의 수
	static List<Integer> list; //원소 담을 리스트
	static int num;
	static int size;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		list = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) { //명령을 받아봅시다
		
			String cmd = sc.next();
			
			if(cmd.equals("all") | cmd.equals("empty")) {
				num = -1;
			} else {
				num = sc.nextInt();
			}
			
			switch(cmd) {
			case "add":
				add(num);
				break;
			case "check":
				if(check(num)) {
				sb.append(1).append("\n");
				} else {
				sb.append(0).append("\n");
				}
				break;
			case "remove":
				remove(num);
				break;
			case "toggle":
				toggle(num);
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			} //switch
		} //반복문
		
		System.out.println(sb);
	} //main

	
	public static boolean check(int num) {
		//있는 수인지 없는 수인지 확인
		
		size= list.size();
			for(int j=0; j<size; j++) { //원소 탐색
				if(((1<<num) & (1<<list.get(j)))>0) { //원소가 있으면
					return true;
				}
			}
		
		
		return false;		
	}
	
	public static void add(int num) {
		if(!check(num)) list.add(num);
	}
	
	public static void remove(int num) {
		size = list.size();
			for(int i=0; i<size; i++) {
				if(list.get(i)==num) {
					list.remove(i);
					break;
				}
			}
	}
	
	public static void toggle(int num) {
		if(check(num)) remove(num);
		else list.add(num);
	} 

	
	public static void all() {
		
		empty();
		
		for(int i=1; i<=20; i++) {
			list.add(i);
		}

	}
	
	public static void empty() {

		size = list.size();
		for(int i=0; i<size; i++) {
			list.remove(0);
		}
		
	}
}

