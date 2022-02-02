import java.util.Scanner;

class Node {
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}
public class CircularSinglyLinkedList {
    Node head;
    static Scanner sc;
    public void createList(){
        sc = new Scanner(System.in);
        System.out.println("Enter a number to create a head for circular linked list ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        head = newNode;
        newNode.next = head;
    }
    public void add(int data){
        Node newNode = new Node(data);
        if(!isEmpty()) {
            Node temp = head;
            while (temp.next.data != head.data) {
                temp = temp.next;
            }
            temp.next = newNode;
        } else {
            head = newNode;
        }
        newNode.next = head;
    }
    public void delete(int data){
        Node temp = head;
        if(!isEmpty()){
            if(head.data == data){
                while (temp.next!=head){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                head = temp.next;
            }
            while(temp.next!=head){
                if(temp.next.data==data){
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
        }
        else {
            System.out.println("List is Empty");
        }
    }
    public void insert(int pos,int data){
        Node newNode = new Node(data);
        if(!isEmpty()) {
            int c = 1;
            Node temp = head;
            while (temp.next != head && c < pos - 1) {
                temp = temp.next;
                c++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            System.out.println("List is empty, entered data made head");
            head = newNode;
            newNode.next = head;
        }
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void display(){
        if(isEmpty()){
            System.out.println("List is empty");
        }
        else{
            Node temp = head;
            System.out.print(temp.data+"->");
            temp=temp.next;
            while (temp!=head){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.print(head.data+"\n");
        }
    }
    public static void main(String[] args) {
        CircularSinglyLinkedList List1 = new CircularSinglyLinkedList();
        List1.createList();

        List1.add(5);
        List1.add(6);
        List1.add(7);
        List1.add(8);
        System.out.print("List formed :");
        List1.display();
        List1.insert(3,65);
        System.out.print("After insertion :");
        List1.display();
        List1.delete(65);
        System.out.print("After deletion :");
        List1.display();
        /*
        Output-
        Enter a number to create a head for circular linked list
        4
        List formed :4->5->6->7->8->4
        After insertion :4->5->65->6->7->8->4
        After deletion :4->5->6->7->8->4
         */
    }
}
