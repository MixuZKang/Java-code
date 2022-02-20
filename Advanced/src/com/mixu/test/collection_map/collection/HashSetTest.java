package com.mixu.test.collection_map.collection;

/*模拟一个HashSet的底层（实际上就是HashMap的底层）
    HashMap底层是一个数组，数组的每个索引位置上都是一条链表（如果直接把数据放到数组中效率很低，为了高效的存储效率使用链表），
    如果随着数据增多导致数组过大、链表过长，则会把链表变为红黑树（比链表更高效的存储效率）。
*/
@SuppressWarnings("all")
public class HashSetTest {
    public static void main(String[] args) {
        //创建一个数组，数组的类型是 Node[]
        Node[] table = new Node[16];
        //创建节点并指向索引为2的位置
        Node john = new Node("john", null);
        table[2] = john;
        Node tom = new Node("tom", null);
        //用next指向了下一个节点tom，将tom节点挂载到john的后面
        john.next = tom;
        Node rose = new Node("rose", null);
        //用next指向了下一个节点rose，将rose节点挂载到tom的后面
        tom.next = rose;
        //这时在数组中索引为2的位置就形成了一个链表  john-->tom-->rose-->null
        System.out.println(table);
    }

}

//定义一个节点对象
class Node {
    Object item;//用于存放数据
    Node next;//指针，用于指向下一个节点

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}
