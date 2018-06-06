import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////

        bst.levelOrder();
        System.out.println();

        bst.preOrder();
        System.out.println();

        bst.preOrderNR();
        System.out.println();

        bst.inOrder();
        System.out.println();

        bst.postOrder();
        System.out.println();

//        System.out.println(bst);

        // test removeMin
        BST<Integer> bst1 = new BST<>();
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst1.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums1 = new ArrayList<>();
        while (!bst1.isEmpty()) {
            nums1.add(bst1.removeMin());
        }
        System.out.println(nums1);
        for (int i = 1; i < nums1.size(); i++) {
            if (nums1.get(i - 1) > nums1.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin test completed.");

        // test removeMax
        for (int i = 0; i < n; i++) {
            bst1.add(random.nextInt(10000));
        }
        nums1 = new ArrayList<>();
        while (!bst1.isEmpty()) {
            nums1.add(bst1.removeMax());
        }
        System.out.println(nums1);
        for (int i = 1; i < nums1.size(); i++) {
            if (nums1.get(i - 1) < nums1.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMax test completed.");
    }
}
