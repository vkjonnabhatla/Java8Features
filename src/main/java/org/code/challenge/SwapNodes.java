package org.code.challenge;

public class SwapNodes {
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		listNode6.next = null;
		
		ListNode node = swapPairs(listNode1);
		System.out.print(node.val);
		
		while(node.next != null) {
			System.out.print("->");
			ListNode temp = node.next;
			node = node.next;
			System.out.print(temp.val);
		}
	}
	
	public static ListNode swapPairs(ListNode node) {
		if(node != null && node.next != null) {
			ListNode temp = node;
			ListNode nextAdjacentPair = node.next.next;
			node = node.next;
			node.next = temp;
			temp.next = nextAdjacentPair;
			node.next.next = swapPairs(nextAdjacentPair);
		}
		return node;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		this.val = x;
	}
}
