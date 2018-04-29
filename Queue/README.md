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


