package com.linearlist;

public class LinkList {
	
	private Node head;
	
	public LinkList(Object obj){
		this.head = new Node(obj,null);
	}
	
	public int size(){
		int i =1;
		Node tmp=head;
		if(head==null){
			return 0;
		}
		while(tmp.next==null){
			tmp=tmp.next;
			i++;
		}
		return i;
	}
	
	
	
	private class Node{
		private Object data;
		private Node next;
		
		public Node(Object obj,Node node){
			this.data=obj;
			this.next=node;
		}
		
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}		
	}

}
