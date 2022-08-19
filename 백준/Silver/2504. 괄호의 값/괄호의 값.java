import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Stack<Character> bracStack = new Stack<>(); 
		Stack<Character> calcStack = new Stack<>();
		Stack<Integer> numStack = new Stack<>();
		// 0 이면 연산자 삽입x  1이면 x , 2이면 +
		int curCalc = 0 ;
		int result = 0;
		for(int i=0; i<str.length();i++) {
			char ch = str.charAt(i);
			
			if(bracStack.isEmpty()) curCalc = 0;
			if(ch == '(') {
				bracStack.add(ch);
				numStack.add(2);
				if(curCalc == 1) {
					calcStack.add('*');
				}else if(curCalc == 2) {
					calcStack.add('+');
				}else {}
				curCalc = 1;
			}else if(ch == '[') {
				bracStack.add(ch);
				numStack.add(3);
				if(curCalc == 1) {
					calcStack.add('*');
				}else if(curCalc == 2) {
					calcStack.add('+');
				}else {}
				curCalc = 1;
			}else if(ch == ')') {
				if(bracStack.isEmpty() || bracStack.peek() == '[') {
					result = 0;
					break;
				}else if(curCalc == 1) {
					bracStack.pop();
					if(calcStack.isEmpty()) result+=numStack.pop();
				}else if(curCalc == 2) {
						bracStack.pop();
						if(calcStack.isEmpty()) {
//							numStack.add(numStack.pop() * numStack.pop());
//							calcStack.pop();
							result += numStack.pop();
							
						}else if(calcStack.peek() == '*') {
							numStack.add(numStack.pop() * numStack.pop());
							calcStack.pop();
							if(calcStack.isEmpty()) result+=numStack.pop();
						}else {
							while(true) {
								if(calcStack.peek() == '+') {
									numStack.add(numStack.pop()+numStack.pop());
									calcStack.pop();
								}else {
									numStack.add(numStack.pop()*numStack.pop());
									calcStack.pop();
									break;
								}
								
							}
							if(calcStack.isEmpty()) result+=numStack.pop();
						}
					
				}
				
				
				
				curCalc = 2;
			}else {
				if(bracStack.isEmpty() || bracStack.peek() == '(') {
					result = 0;
					break;
				}else if(curCalc == 1) {
					bracStack.pop();
					if(calcStack.isEmpty()) result+=numStack.pop();
				}else if(curCalc == 2) {
						bracStack.pop();
						if(calcStack.isEmpty()) {
//							numStack.add(numStack.pop() * numStack.pop());
//							calcStack.pop();
							result += numStack.pop();
							
						}else if(calcStack.peek() == '*') {
							numStack.add(numStack.pop() * numStack.pop());
							calcStack.pop();
							if(calcStack.isEmpty()) result+=numStack.pop();
						}else {
							while(true) {
								if(calcStack.peek() == '+') {
									numStack.add(numStack.pop()+numStack.pop());
									calcStack.pop();
								}else {
									numStack.add(numStack.pop()*numStack.pop());
									calcStack.pop();
									break;
								}
								
							}
							if(calcStack.isEmpty()) result+=numStack.pop();
						}
					
				}
				
				
				
				curCalc = 2;
			}
			
			
		}
		if(!bracStack.isEmpty()) result = 0;
		System.out.println(result);
	}
}