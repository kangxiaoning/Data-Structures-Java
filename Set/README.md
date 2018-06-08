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

