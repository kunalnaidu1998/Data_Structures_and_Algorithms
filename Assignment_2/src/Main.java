import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Implementation test of CS319Stack");

        // Question 1
        // create an instance
        CS319Stack<Integer> test = new CS319Stack<>();

        // check if the stack is empty
        System.out.println("Check if stack is empty:" + test.is_empty());

        // push from 0 to 100
        for (int i=0; i < 101; i++){
            test.push(i);
        }

        // pop 10 elements
        for (int i=0; i<10; i++){
            test.pop();
        }


        //  peek
        System.out.println("Peek at stack after push and pop: " + test.peek());

        System.out.println("Implementation test of DLList");
        // question 2
        DLList<Integer> test2 = new DLList<>(new Integer[]{1, 2, 3, 2, 1, 2, 3, 4}, 5);
        System.out.println("Checking size of DLList after construction: " + test2.size());

        int frequencyTest = test2.frequency(1);
        System.out.println("Testing the frequency: " +frequencyTest);

        boolean palindromeTest = test2.palindrome();
        System.out.println("Testing for palindrome: " + palindromeTest);


        // Question 3

        // Create a binary tree
        BinaryNode<Integer> root = new BinaryNode<>(1);
        root.setLeft(new BinaryNode<>(2));
        root.setRight(new BinaryNode<>(3));
        root.getLeft().setLeft(new BinaryNode<>(4));
        root.getLeft().setRight(new BinaryNode<>(5));
        root.getRight().setLeft(new BinaryNode<>(6));
        root.getRight().setRight(new BinaryNode<>(7));

        // Count the number of leaves in the tree
        int numLeaves = BinaryNode.numLeaves(root);

        // Print the result
        System.out.println("The binary tree has " + numLeaves + " leaves.");
    }
}