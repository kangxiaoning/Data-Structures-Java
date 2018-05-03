import java.util.Random;

public class Main {

    public static double[] testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        long pushEndTime = System.nanoTime();

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long popEndTime = System.nanoTime();

        double pushTime = (pushEndTime - startTime) / 1000000000.0;
        double popTime = (popEndTime - pushEndTime) / 1000000000.0;
        double totalTime = (popEndTime - startTime) / 1000000000.0;

        return new double[]{pushTime, popTime, totalTime};
    }

    public static void main(String[] args) {

        int opCount = 10000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double[] time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack,      total time: " + time1[0] +
                " s, push time: " + time1[1]
                + " s, pop time: " + time1[2] + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double[] time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, total time: " + time2[0] +
                " s, push time: " + time2[1]
                + " s, pop time: " + time2[2] + " s");

        // 其实这个时间比较很复杂， 因为LinkedListStac中包含更多new操作

        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
