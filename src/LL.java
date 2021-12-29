import java.util.Collections.*;
import java.util.LinkedList;

public class LL {
    private int size;
    Node head;
    LL(){
       this.size =0;
    }
    public int getSize(){
        return size;
    }
    class Node{
        String data;
        Node next;

        Node (String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }
    //add - first, last
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }
    //printlist
    public void printList(){
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.print(" NULL");
        System.out.println();
    }
    //delete first
    public void deleteFirst(){
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        size--;
        head = head.next;
    }
    public void deleteLast(){
        if(head==null){
            System.out.println("List empty");
            return;
        }
        size--;
        if(head.next == null){
            head = null;
            return;
        }
        Node secondLast = head;
        Node last = head.next;
        while(last.next != null){
            last = last.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }
    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst("a");
        list.addFirst("is");
        list.addLast("List");
        list.addFirst("This");
        list.printList();
        System.out.println(list.size);
        list.deleteFirst();
        list.printList();
        System.out.println(list.size);
        list.deleteLast();
        System.out.println(list.size);
        list.printList();
        LinkedList<String> ListC = new LinkedList<String>();
        ListC.addFirst("a");
        ListC.addFirst("is");
        ListC.addLast("List");
       ListC.addFirst("This");
        System.out.println(ListC);
        System.out.println(ListC.size());
        for( String i : ListC){
            System.out.print(i + " -> ");
        }
        System.out.println("NULL");
    }
}
