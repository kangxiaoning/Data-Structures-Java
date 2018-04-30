import java.util.Random;

public class Main {

    public static double[] testEnqueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        long enqueueEndTime = System.nanoTime();

        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long dequeueEndTime = System.nanoTime();

        double enqueueTime = (enqueueEndTime - startTime) / 1000000000.0;
        double dequeueTime = (dequeueEndTime - startTime) / 1000000000.0;

        return new double[]{enqueueTime, dequeueTime};
    }

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double[] time1 = testEnqueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, enqueue time: " + time1[0]
                + " s, dequeue time: " + time1[1] + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double[] time2 = testEnqueue(loopQueue, opCount);
        System.out.println("LoopQueue,  enqueue time: " + time2[0]
                + " s, dequeue time: " + time2[1] + " s");
    }
}

// MAC Air + java 9 上结果如下
// 主要差距在 dequeue 操作上
// 对于ArrayQueue而言，每一次dequeue时间复杂度是O(n)，而testQueue用for循环dequeue了n次，
// 所以对ArrayQueue而言，testQueue的复杂度是O(n^2)
//
// 对于LoopQueue而言，enqueue和dequeue都是O(1)的复杂度，所以testQueue是O(n)的复杂度

// ArrayQueue, enqueue time: 0.037746523 s, dequeue time: 48.849298087 s
// LoopQueue,  enqueue time: 0.015242599 s, dequeue time: 0.02549619 s