集合和映射
========

Set and Map

集合(set)

- 每个元素只能存在一次
- 回忆上一小节实现的二分搜索树不能盛放重复元素
- 二分搜索树是实现集合非常好的底层数据结构
- 典型应用
    - 客户统计
    - 词汇量统计


集合定义的接口 

```
Set<E>

void add(E)             // 不能添加重复元素
void remove(E)
boolean contains(E)
int getSize()
boolean isEmpty() 
```

对于Set，设计的是一个接口，所以可以采用不同的底层数据结构来实现。上
一节用二分搜索树来实现了Set,这一节使用LinkedList来实现，叫做LinkedListSet。
为什么要单拿出来LinkedList来实现Set呢？这是因为BST和LinkedList都
属于动态数据结构，数据都是存储在Node中，只不过两个Node的定义不同。因此基于
这两种数据结构为底层实现Set后，可以相应比较性能，通过比较希望看到BST
的优势所在。


