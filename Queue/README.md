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