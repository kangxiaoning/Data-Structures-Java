Linked List
==========


# 1. 线性数据结构

- 动态数组
- 栈
- 队列

如上数据结构都是底层依托静态数组，靠resize解决固定容量问题。

- 链表
    - 真正的动态数据结构
    - 最简单的动态数据结构
    - 更深入的理解引用（或者指针）
    - 更深入地理解递归
    - 辅助组成其他数据结构
    

# 2. Linked List

- 数据存储在“节点”中
    ```java
    class Node {
        E e;
        Node next;
    }

    ```
- 1-->2-->3-->NULL
- 优点：真正的动态，不需要处理固定容量的问题
    - 一下new一片空间
    - 空间浪费
    - 不够用等问题
- 缺点：丧失了随机访问能力
    - 不能通过index访问
    - 底层机制上，数组开辟的空间在内存里是连续分布的，可以直接寻找索引对应的偏移，计算相应数据的内存地址，直接用O(1)的复杂度把数据拿出来
    - 链表是靠next一层一层链接的，每一个节点所在内存地址是不同的，必须靠next一点一点找到需要的元素


# 3. 数组和链表对比

- 数组
    - 数组最好用于索引有语义的情况
    - 最大的优点：快速查询

- 链表
    - 不适合于索引有语义的情况
    - 最大优点：动态

        
# 4. 在链表头添加元素

- 对于数组，由于有size变量，直接指向数组尾部，直接添加非常容易
- 对于链表，有head跟组链表头，所以在链表头添加元素很方便

```
// 将node元素添加到链表

node.next = head
head = node
```

为链表设立虚拟头结点

××问题××：之前在链表任意位置添加元素的时候，在链表头添加元素和在其他地方添加元素有区别，原
因是因为需要找到前一个节点，而链表头没有前一个节点，所以在逻辑上会特殊一些


```

null --> 0 --> 1 --> 2 --> 3 --> 4 --> NULL
 ^       ^
 |       |
 |      head
 |
dummyHead

```

# 5. 链表的时间复杂度

- 添加操作  O(n)

```
addLast(e)          O(n)
addFirst(e)         O(1)
add(index, e)       O(n) 
```

- 删除操作  O(n)

``` 
removeLast()        O(n)
removeFirst()       O(1)
remove(index, e)    O(n)
```

- 修改操作  O(n)

``` 
set(index, e)       O(n)
```

- 查找操作  O(n)

``` 
get(index)          O(n)
contains(e)         O(n)
```

如果只对链表头进行操作：    O(1)


# 6. 使用链表实现栈

通过上面时间复杂度分析可知，对链表的头进行增删查，时间复杂度都是O(1)。满足这些条件相应的数据结构就是栈。

``` 
Interface Stack<E>  <--------- LinkedStack<E>
void push(E)         implement
E pop()
E peek()
int getSize()
boolean isEmpty()

```

# 6. 带有尾指针的链表

为什么对于链表来说，在头部添加、删除都是O(1)呢？这是因为有一个head标记链表的头在哪儿。现在希望
在链表的尾部进行相应的操作也是容易的，应该怎么做呢？再设立一个Node型的变量，来标记链表的尾部在
哪。


``` 
    0--> 1--> 2--> 3--> 4--> Null
    ^                   ^
    |                   |
   head                tail

```

即使在结尾标记了tail，从tail删除依然不容易。

- tail添加容易
- head删除容易

因此，从head端删除元素，从tail端插入元素，实现如下。

[使用带有尾指针的链表实现队列](https://github.com/kangxiaoning/Data-Structures-Java/blob/master/Queue/src/LinkedListQueue.java)

``` 
Interface Queue<E>  <--------- LinkedListQueue<E>
int getSize();       implement
boolean isEmpty();
void enqueue(E e);
E dequeue();
E getFront();

```
