package LinkedList;
//单向链表就地转置
public class SingleLinkedListReverse {
    public static void main(String [] args)
    {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        head.setNext(node1);
        node1.setNext(node2);
        //node2.setNext(null);
        Node h = head;
        Node h1 = head;

        while (h!= null)
        {
            System.out.print(h.getData()+" ");
            h = h.getNext();
        }
        System.out.println("\n----反转----");
        Node rehead = Reverse1_(head);
        while (rehead!= null)
        {
            System.out.print(rehead.getData()+" ");
            rehead=rehead.getNext();
        }
        //结点发生改变，指向该结点的引用（指针）信息均会发生改变
        //System.out.println(h1.getNext());null

    }
    //递归反转法，反转当前结点前，先反转后继节点，先从尾节点开始反转
    public static Node Reverse(Node head)
    {
        if(head == null || head.getNext() == null) {
            return head;
        }
        //注意理解递归
        Node rehead = Reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return rehead;
    }
    //遍历反转法，
    public static Node Reverse1(Node head)
    {
        if (head == null||head.getNext()==null)
        {
            return head;
        }
        Node pre = null;
        Node cur = head;
        Node temp;
        while (cur!=null)
        {
            temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    /*
    遍历，将当前结点的下一个结点缓存后，更改当前指针
     */
    public static Node Reverse1_(Node head)
    {
        if(head == null)
        {
            return head;
        }
        Node pre = head;
        Node cur = head.getNext();
        Node tmp;
        while (cur!=null)
        {
            tmp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = tmp;

        }head.setNext(null);
        return pre;
    }
}
class Node{
    private int Data;//数据域
    private Node Next;//指针域
    public Node(int Data)
    {
        this.Data = Data;
    }

    public int getData() {
        return Data;
    }

    public void setData(int data) {
        this.Data = data;
    }

    public Node getNext() {
        return Next;
    }

    public void setNext(Node next) {
        this.Next = next;
    }
}
