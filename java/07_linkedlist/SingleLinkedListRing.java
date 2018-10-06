package LinkedList;
//单链表中检测环，常用方法为快慢指针法，如果快慢指针相遇，说明存在环，
public class SingleLinkedListRing {
    public static void main(String [] args)
    {
        Node1 head = new Node1(0);
        Node1 node1 = new Node1(1);
        Node1 node2 = new Node1(2);
        Node1 node3 = new Node1(3);
        Node1 node4 = new Node1(4);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(null);
        int result = Ring(head);
        System.out.println(result);
    }
    public static int Ring(Node1 head)
    {
        if(head == null|| head.getNext()==null)
        {
            return -1;
        }
        Node1 fast=head;
        Node1 slow=head;
        while (fast != null && fast.getNext()!=null )
        {
            slow =slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast)
            {
                return 1;
            }
        }
        return -1;

    }
}
class Node1
{
    private int data;
    private Node1 next;
    public  Node1(int data)
    {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node1 getNext() {
        return next;
    }

    public void setNext(Node1 next) {
        this.next = next;
    }
}
