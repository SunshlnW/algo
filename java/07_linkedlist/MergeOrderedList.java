package LinkedList;

public class MergeOrderedList {
    public static void main(String[]args)
    {
        Node2 l1 = new Node2(0);
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(3);
        Node2 node4 = new Node2(4);
        l1.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(null);

        Node2 l2 = new Node2(1);
        Node2 node12 = new Node2(2);
        Node2 node22 = new Node2(4);
        Node2 node32 = new Node2(5);
        Node2 node42 = new Node2(6);
        l2.setNext(node12);
        node12.setNext(node22);
        node22.setNext(node32);
        node32.setNext(node42);
        node42.setNext(null);

        Node2 l = mergeTwoLists(l1,l2);
        while (l!=null)
        {
            System.out.print(l.getData()+" ");
            l = l.getNext();
        }
    }
    //正确解法
    public static Node2 Merge(Node2 l1,Node2 l2)
    {
        if(l1 == null)
        {
            return l2;
        }
        if(l2 == null)
        {
            return l1;
        }
        Node2 p = l1;
        Node2 q = l2;
        Node2 head;
        if(l1.getData()<l2.getData())
        {
            head = p;
            p = p.getNext();
        }
        else
        {
            head = q;
            q = q.getNext();
        }
        Node2 l = head;
        while (p != null && q!= null)
        {
            if(p.getData()<q.getData())
            {
                head.setNext(p);
                p = p.getNext();
                head = head.getNext();
            }
            else
            {
                head.setNext(q);
                q = q.getNext();
                head = head.getNext();
            }
        }
        if(p == null)
        {
            head.setNext(q);
        }
        else 
        {
            head.setNext(p);
        }
        return l;
    }
    
    //递归解法
    public static Node2 mergeTwoLists(Node2 l1, Node2 l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        Node2 l0 = l1.getData() > l2.getData() ? l2 : l1;
        //分治思想，每次拿一个小的出来，每次的动作相同
        l0.setNext(l1.getData() > l2.getData() ? mergeTwoLists(l1, l2.getNext()) : mergeTwoLists(l1.getNext(), l2));
        return l0;
    }

}
class Node2
{
    private int data;
    private Node2 next;
    public  Node2(int data)
    {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node2 getNext() {
        return next;
    }

    public void setNext(Node2 next) {
        this.next = next;
    }
}

