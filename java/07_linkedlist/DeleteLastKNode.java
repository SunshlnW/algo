package LinkedList;

public class DeleteLastKNode {
    public static void main(String[]args)
    {
        Node3 l1 = new Node3(0);
        Node3 node1 = new Node3(1);
        Node3 node2 = new Node3(2);
        Node3 node3 = new Node3(3);
        Node3 node4 = new Node3(4);
        Node3 node5 = new Node3(5);
        Node3 node6 = new Node3(6);
        l1.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(null);
        Node3 node = Delete1(l1,7);
        while (node!=null)
        {
            System.out.print(node.getData()+" ");
            node = node.getNext();
        }

        
    }
    /*
    思路：先统计链表结点个数
        1、链表长度小于k，则返回null
        2、链表长度大于k,则倒数第k个结点就是正数第N-k+1个结点，其前结点是第n-k
     */
    public static Node3 Delete(Node3 head,int n)
    {
        Node3 fast = head;
        Node3 slow = head;
        int num = 0;
        int i = 1;
        while (fast!=null)
        {
            if(fast.getNext()==null)
            {
                num = 2*num+1;
                break;
            }
            if(fast.getNext().getNext() ==null)
            {
                num = 2*(num +1);
                break;
            }
            fast = fast.getNext().getNext();
            num += 1;
        }
        if(num<n)
            return null;
        while (i!=num-n)
        {
             head = head.getNext();
             i++;
        }
        Node3 temp = head.getNext().getNext();
        head.setNext(temp);
        return slow;
    }
    /*先声明新指针，让其走到底K个结点
    声明头指针，将其与上述新指针一起往后移，这样当上述新指针到达尾节点，指向头指针的
    到达倒数第K个结点。
     */
    public static Node3 Delete1(Node3 head,int n)
    {
        Node3 fast = head;
        int i = 1;
        while (fast!=null && i<n)
        {
            fast = fast.getNext();
            i++;
        }
        if(fast == null)
            return null;
        Node3 pre = null;
        Node3 slow = head;
        //fast = fast.getNext();
        while (fast.getNext()!=null)
        {
            fast = fast.getNext();
            pre = slow;
            slow = slow.getNext();
        }
        if(pre == null)
        {
            head = head.getNext();
        }
        else
        {
            pre.setNext(slow.getNext());
        }
        return head;
    }
}
class Node3
{
    private int data;
    private Node3 next;
    public  Node3(int data)
    {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node3 getNext() {
        return next;
    }

    public void setNext(Node3 next) {
        this.next = next;
    }
}

