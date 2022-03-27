import java.util.Objects;

/* Assume that a singly linked list is implemented with a header node but no tail node. write a class that includes methods to perform
1) Return the size of the linked list.
2) Print the linked list.
3) Test if the value X is contained in the list or not.
4) Add a value X if it is not contained, at the end.
5) Remove the value X if it is contained in the linked list.
6) Implement this by using the generics concept.
7) Can contain byte, short, integer, double, float.*/
class Node <T>{
    T data;
    Node<T> next;
    public Node(T data){
        this.data = data;
    }
}

public class LinkedList <T extends Integer,Float,Byte,Short,Double> {
    Node<T> head;
    public void add(T data){
        Node<T> newNode = new Node(data);
        Node<T> temp = head;
        while(temp.next!=null){
            if(Objects.equals(temp.data, data)){
                System.out.println("Value found in the list");
                return;
            }
        }
        temp.next = newNode;
    }
    public int size(){
        Node<T> temp =head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        return size;
    }
    public void printList(){
        Node<T> temp = head;
        while(temp.next!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
    public void remove(T data) {
        Node<T> temp = head;
        while (temp.next != null && !Objects.equals(temp.data, data)) {
            temp = temp.next;
        }
        if (temp.next == null) System.out.println("Data not found");
        else if(Objects.equals(temp.data, data)){
            temp= temp.next;
        }
    }
}
