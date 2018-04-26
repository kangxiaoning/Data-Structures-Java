public class Array {

    private int[] data;

    // 指向数组中第一个没有元素的位置，相当于数组末尾
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     *
     * @return
     */
    public boolean isEmpay() {
        return size == 0;
    }

    // 向数组末尾添加一个元素
    public void addLast(int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }
        data[size] = e;
        size++;
    }

    public void addFirst(int e) {
        add(0, e);
    }

    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed. Array is full.");
        }
        // index > size 说明元素不是紧密排列的，中间存在一些位置没有合法的元素，不是我们希望的
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 获取 index 索引位置的元素
    public int get(int index) {
        // 通过index的条件限制，保证用户无法查询没有使用的空间
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    // 删除指定位置元素，返回删除的元素
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        int ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    // 从数组中删除第一个元素，返回删除元素
    public int removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素，返回删除元素
    public int removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e，如果存在e，只删除一次
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    // 明确写 `@Override` 可以让IDE帮助检查是否覆盖正确
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
