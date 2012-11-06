package com.algorithm.turtlehare;

public class TurtleHareAlgorithm {

	Node start;
	
	public static void main(String[] args){
		TurtleHareAlgorithm algo = new TurtleHareAlgorithm();
		algo.add("Alan");
		algo.add("Bob");
		algo.add("Alice");
		algo.add("Mark");
		algo.add("John");
		algo.printList();
		
		algo.createLoop("Alice");
		//algo.printList();
		
		System.out.println(algo.hasCycle());
	}
	
	public void add(String value){
		if(start == null){
			start = new Node();
			start.value = value;
		}
		else{
			Node temp = start;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = new Node();
			temp.next.value = value;
		}
	}
	
	public void printList(){
		Node temp = start;
		while(temp != null){
			System.out.print(temp.value + "->");
			temp = temp.next;
		}
	}
	
	private Node find(String value){
		Node element = null;
		Node temp = start;
		while(temp != null){
			if(temp.value.equals(value)){
				element = temp;
				break;
			}
			temp = temp.next;
		}
		return element;
	}
	
	public void createLoop(String value){
		Node temp = start;
		while(temp.next != null)
			temp = temp.next;
		temp.next = find(value);
	}
	
	public boolean hasCycle() {
		Node first = start;
	    if(first == null) // list does not exist..so no loop either.
	        return false;

	    Node tortoise, hare; // create two references.

	    tortoise = hare = first; // make both refer to the start of the list.

	    while(true) {
	        tortoise = tortoise.next;          // 1 hop.

	        if(hare.next != null)
	            hare = hare.next.next; // 2 hops.
	        else
	            return false;          // next node null => no loop.

	        if(tortoise == null || hare == null) // if either hits null..no loop.
	            return false;

	        if(tortoise.equals(hare)) // if the two ever meet...we must have a loop.{
	        {
	        	return true;
	        }
	        
	    }
	}
	
	class Node{
		String value;
		Node next;
		
		@Override
		public boolean equals(Object obj){
			if(obj instanceof Node){
				return this.value.equals(((Node)obj).value);
			}
			return false;
		}
	}
}
