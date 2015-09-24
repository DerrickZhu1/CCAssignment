package ch3;

import java.util.ArrayList;
import java.util.Stack;

//Stack of Plates
public class Solution03 {
	public static class StackPlates{

		private static int capacity = 0;
		private static final int DEFAULT_CAPACITY = 3;
		private ArrayList<Stack<Integer>> plates = new ArrayList<Stack<Integer>>();
		
		public StackPlates(){
			capacity = DEFAULT_CAPACITY;
			Stack<Integer>  s = new Stack<Integer>();
			plates.add(s);
		}
		
		public StackPlates(int capacity){
			this.capacity = capacity;
			Stack<Integer>  s = new Stack<Integer>();
			plates.add(s);
		}

		public boolean isEmpty(){
			return plates.size()==0||plates.get(0).isEmpty();
		}

		public void push(int value){
			if(plates.size()==0){
				plates.add(new Stack<Integer>());
			}
			Stack<Integer> s = plates.get(plates.size()-1);
			// last stack is at full capacity.
			if(s.size()>=capacity){
				Stack<Integer> newStack = new Stack<Integer>();
				plates.add(newStack);
				newStack.push(value);
			}else{
				s.push(value);
			}
		}

		public int pop(){
			Stack<Integer> last = plates.get(plates.size()-1);
			int value = last.pop();
			if(last.size()==0){
				plates.remove(plates.size()-1);
			}
			return value;			
		}

		public int peek(){
			Stack<Integer> last = plates.get(plates.size()-1);
			int value = last.peek();
			return value;
		}

		public int size(){
			return plates.size();
		}

		public int popAt(int index){
			if(plates.size()-1<index){
				System.out.println("Wrong index.");
				return -1;
			}
			Stack<Integer> s = plates.get(index);
			int value = s.pop();

			balance(index, index+1);
			
			return value;

		}
		
		private void balance(int first, int second){
			if(first>plates.size()-1||second>plates.size()-1){
				return;
			}
			Stack<Integer> s1 = plates.get(first);
			Stack<Integer> s2 = plates.get(second);
			s1.push(s2.remove(0));
			balance(second, second+1);
		}
		
		public void inspect(){
			StringBuffer sb = new StringBuffer();
			sb.append("===Insepecting stack of plates===\n");
			for(int i = 0; i<plates.size(); i++){
				sb.append("Stack "+i+" elements: ");
				Stack<Integer> s = plates.get(i);
				for(int value:s ){
					sb.append(value+",");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}	
	}
	public static void main(String[] args){
		StackPlates ins = new StackPlates();

		for(int i = 0; i<90; i++){
			ins.push(i);
		}
		ins.popAt(3);
		ins.popAt(1);
     	ins.plates.get(2).pop();
		ins.inspect();
     	System.out.println(ins.plates.get(2).get(0));
	}

}
