Queue
=====

# 1. Queue

- 队列也是一种线性结构
- 相比数组，队列对应的操作是数组的子集
- 只能从一端（队尾）添加元素，只能从另一端（队首）取出元素
- 队列是先进先出的数据结构
- First In First Out（FIFO）

# 2. 队列的实现

```
Interface Queue<E>  <--------    ArrayQueue<E>
                    implement

void enqueue(E)
E dequeue()
E getFront()
int getSize()
boolean isEmpty()

```

# 3. 数组队列的复杂度分析

```
void enqueue(E)         O(1)均摊
E dequeue()             O(n)
E getFront()            O(1)
int getSize()           O(1)
boolean isEmpty()       O(1)
```

dequeue复杂度为O(n)，因为dequeue的时候每次把整个数组索引为0的
元素拿出后来，数组后面的元素都要向前挪一个一个位置，这是在动态数组
中removeFirst方法的逻辑，复杂度显然是O(n)的。

# 4. 循环队列

## 4.1 数组队列的问题

前面的数组队列，dequeue后，剩余元素都要移动导致时间复杂度不理想，
仔细想一下，即使dequeue后，队列中其它元素还是队列应有的样子，能
不能不移动元素呢？这样就可以降低复杂度。

基于这样的想法，我们可以在数组中记录队首是谁，队尾（size）指的是
下一次入队时应该存储的位置。这样的话，当元素a移出数据组后，只需要
维护front的指向，而不需要所有元素都向前移动一个位置，基于这样的
想法，有了循环队列这样的实现。

```

 front  tail
   ^     ^
   |     |
   b c d e
   
 0 1 2 3 4 5 6 7
 

# 循环队列

    front
     ^
     |
 i   c d e f g h
 0 1 2 3 4 5 6 7
   ^
   |
  tail
 
 
```

## 4.2 循环队列原理

- 把数组看成一个环（以上面为例，index=7的下一个位置是index=0）
- 循环队列的情况下，到了数组末端，还可以返回到数组前端，这个过程靠求余操作实现
- front == tail 时队列为空
- (tail + 1) % c == front 时队列满
- capacity 中浪费一个空间（不然无法区分队列空和满）