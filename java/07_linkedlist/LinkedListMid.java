package LinkedList;

public class LinkedListMid {
    public static void main(String []args)
    {
        Node4 l1 = new Node4(0);
        Node4 node1 = new Node4(1);
        Node4 node2 = new Node4(2);
        Node4 Node4 = new Node4(3);
        Node4 node4 = new Node4(4);
        Node4 node5 = new Node4(5);
        //Node4 node6 = new Node4(6);
        l1.setNext(null);
        node1.setNext(null);
        node2.setNext(Node4);
        Node4.setNext(node4);
        node4.setNext(node5);
        node5.setNext(null);
        //node6.setNext(null);
        Node4 head = Mid(l1);
        System.out.print(head.getData());
    }
    //利用快慢指针
    public static Node4 Mid(Node4 head)
    {
        if(head == null)
            return head;
        Node4 fast = head;
        Node4 slow = head;
        while (fast.getNext()!=null && fast.getNext().getNext()!=null)
        {
            fast=fast.getNext().getNext();
            slow=slow.getNext();
        }
        return slow;

    }
}
class Node4
{
    private int data;
    private Node4 next;
    public  Node4(int data)
    {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node4 getNext() {
        return next;
    }

    public void setNext(Node4 next) {
        this.next = next;
    }
}

