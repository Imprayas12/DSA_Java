import java.util.Scanner;

class DNode{
    int data;
    DNode next;
    DNode prev;
    public DNode(int data){
        this.data = data;
    }
}

public class CircularDoublyLinkedList {
    DNode head;
    DNode tail;
    static Scanner sc;
    public void createList(){
        sc =  new Scanner(System.in);
        System.out.print("Enter a number to create a circular doubly linked list : ");
        int n = sc.nextInt();
        DNode temp = new DNode(n);
        head = temp;
        head.next = head;
        tail = temp;
        tail.next = head;
        head.prev = tail;
    }
    public void addAtLast(int data){
        DNode t = new DNode(data);
        if(isEmpty()){
            head = t;
            head.next = head;
            tail = t;
            tail.next = head;
            head.prev = tail;
        }
        else{
            DNode temp = head;
            while(temp.next!=head){
                temp = temp.next;
            }
            temp.next = t;
            t.next = head;
            t.prev = temp;
            head.prev = t;
            tail = t;
        }
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void display(){
        System.out.print("List starting from head will be :");
        DNode temp = head;
        System.out.print(temp.data +"->");
        temp = temp.next;
        while(temp!=head){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print(head.data);
        System.out.println();
    }
    public void revDisplay(){
        System.out.print("List starting from tail will be :");
        DNode temp = tail;
        System.out.print(temp.data+"<-");
        temp = temp.prev;
        while (temp!=tail){
         System.out.print(temp.data+"<-");
         temp = temp.prev;
        }
        System.out.print(tail.data);
        System.out.println();
    }
    public void insert(int pos,int data){
    int c=1;
    DNode temp = head;
    DNode t = new DNode(data);
    if(pos==1){
        tail.next = t;
        t.next = head;
        head.prev = t;
        t.prev = tail;
        head = t;
    }
    while (c<pos-1){
        temp = temp.next;
        c++;
        }
        t.next = temp.next;
        temp.next.prev = t;
        temp.next = t;
        t.prev = temp;
    }
    public void delete(int data) {
        boolean f = false;
        DNode temp = head;
        while (temp.next.data != data) {
            temp = temp.next;
            if (temp == tail) {
                f = true;
                break;
            }
        }
        if (f) System.out.println("Element not found.");
        else {
            temp.next.next.prev = temp;
            temp.next = temp.next.next;

        }
    }
    public static void main(String[] args) {
        CircularDoublyLinkedList list1 = new CircularDoublyLinkedList();
        list1.createList();
        list1.addAtLast(5);
        list1.addAtLast(6);
        list1.addAtLast(7);
        list1.addAtLast(8);
        list1.insert(2,75);
        list1.display();
        list1.delete(75);
        list1.addAtLast(89);
        list1.revDisplay();
        /*
          Output :-
          Enter a number to create a circular doubly linked list : 4
          List starting from head will be :4->75->5->6->7->8->4
          List starting from tail will be :89<-8<-7<-6<-5<-4<-89
        */
    }
}
