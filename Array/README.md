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