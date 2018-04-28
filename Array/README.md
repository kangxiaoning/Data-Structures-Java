Array
=====

# 1. 数组基础

- 数组最大的优点： 快速查询
- 最好应用于“索引有语义”的情况
- 并非所有有语义的索引都是用于数组
    - 比如身份证号

# 2. 使用泛型

- 让我们的数据结构可以放置“任何”数据类型
    - 不可以是基本数据类型，只能是类对象
        - boolean byte char short int long float double
    - 每个基本数据类型都有对应的包装类
        - Boolean Byte Char Short Int Long Float Double

# 3. 动态数组

- 通过新建、copy实现

# 4. 简单的时间复杂度

- O(1), O(n), O(lgn), O(nlogn), O(n^2) 
- 简单的说大O描述的是算法的运行时间和输入数据之间的关系
```java
public static int sum(int[] nums){      // O(n)
    int sum = 0;
    for(in num: nums) sum += num;       // n是nums中元素个数
    return sum;                         // 算法和n呈线性关系
}
```
- 为什么要用大O，叫做O(n)?
    - 忽略常数，实际时间 T = c1*n + c2
    - 实际中c1和c2没必要求出来，甚至求不出来
    
    ```
      T = 2*n + 2             O(n)
      T = 2000*n + 10000      O(n)
      T = 1*n*n + 0           O(n^2)
      T = 2*n*n + 300n +10    O(n^2) n 无穷大时，低阶项可以忽略，因此是O(n^2)
    ```
    - 对于任意输入，并不代表O(n)都要快于O(n^2)的算法
    - 实际应该叫做“渐进时间复杂度”，描述n趋近于无穷的情况

# 5. 分析动态数组的时间复杂度

    严格计算需要一些概率论知识
    
- 添加操作  O(n)
    
    考虑resize O(n)
    
    - addLast(e)        O(1)
    - addFirst(e)       O(n)
    - add(index, e)     O(n/2) = O(n)    

- 删除操作  O(n)

    - removeLast(e)     O(1)
    - removeFirst(e)    O(n)
    - remove(index, e)  O(n/2) = O(n)

- 修改操作
    - set(index, e)     O(1)    // 数组最大的优势

- 查询操作  O(n)
    - get(index)        O(1)
    - contains(e)       O(n)
    - find(e)           O(n)        

- 总结
    - 增：    O(n)
    - 删：    O(n)
    - 改：    已知索引O(1); 未知索引O(n)
    - 查：    已知索引O(1); 未知索引O(n)
    
# 6. 均摊复杂度和防止复杂度震荡

前面知道对于添加操作，时间复杂度是O(n)，虽然对于addLast来说是O(1)，但是由于有resize方
法，由于resize是O(n)，所以整个添加是O(n)。但是我们不可能每次操作都触发resize。

假设每次添加都是用addLast，9次addLast触发resize，总共进行了17次基本操作，平均来讲，每
次addLast操作，进行约2次基本操作。

假设capacity=n，n+1次addLast，触发resize，总共进行2n+1次基本操作。

2n+1/n，平均每次addLast操作，进行2次基本操作。

这样均摊计算，意味着addLast操作的时间复杂度是O(1)。

这个例子里，因为最坏的情况不会每次出现，因此这样均摊计算比最坏情况有意义。

同理，removeLast操作，均摊复杂度也是O(1)。

但是当我们同时看addLast和removeLast操作，以当前n/2触发缩容来看，当size为n时，已经装满
元素，依次执行如下操作：

```
addLast     --> resize      O(n)
removeLast  --> resize      O(n)
addLast     --> resize      O(n)
removeLast  --> resize      O(n)
    ...
```

之前说addLast和removeLast都是每隔n次触发resizt，而不会每次触发resize，但是现在制造了
一个情景，存在某种情况，每一次都会耗费O(n)复杂度，这就是**复杂度震荡**。在均摊时，我们认为应该
是O(1)，但是在一些特殊情况下，复杂度窜到O(n)级别。

出现问题的原因： removeLast时resize过于着急（Eager）

解决方案：   Lazy

策略： 当 size == capacity / 4 时，才将capacity减半
