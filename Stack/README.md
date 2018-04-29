Stack
=====

# 1. Stack

- 栈也是一种线性结构
- 相比数组，栈对应的操作是数组的子集
- 只能从一端添加元素，也只能从一端取出元素
- 这一端称为栈顶
- 栈是一种后进先出的数据结构
- Last In First Out(LIFO)

# 2. 栈相关应用

- word/IDE等编辑器中的Undo操作（撤销）
- 程序调用的系统栈（记录每次中断调用的点）
- 括号匹配（编译器）


# 3. 栈的实现

```
Stack<E>

void push(E)
E pop()
E peek()
int getSize()
boolean isEmpty()
```

- 从用户角度看，支持这些操作就好
- 具体底层实现，用户不关心
- 实际底层有多种实现方式

本实例使用如下设计方式，实现基于上面学习动态数组来实现，叫ArrayStack。

```
Interface Stack<E>  <--------- ArrayStack<E>
void push(E)        implement
E pop()
E peek()
int getSize()
boolean isEmpty()

```

# 4. 栈的时间复杂度分析


```
ArrayStack<E>

- void push(E)          O(1) 均摊
- E pop()               O(1) 均摊
- E peek()              O(1)
- int getSize()         O(1)
- boolean isEmpty()     O(1)

```

# 5. leetcode题目练习

[有效的括号](https://leetcode-cn.com/problems/valid-parentheses/description/)



