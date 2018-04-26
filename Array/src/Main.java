public class Main {

    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[] scores = new int[]{100, 99, 66};
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }

        // foreach
        System.out.println();
        for (int score : scores) {
            System.out.println(score);
        }

        // modify
        System.out.println();
        scores[0] = 98;
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }

        // 验证
        Array arr1 = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr1.addLast(i);
        }
        System.out.println(arr1);

        arr1.add(1, 100);
        System.out.println(arr1);

        arr1.addFirst(-1);
        System.out.println(arr1);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr1.remove(2);
        System.out.println(arr1);

        arr1.removeElement(4);
        System.out.println(arr1);

        arr1.removeFirst();
        System.out.println(arr1);
    }
}


