package stackqueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Nowshad Hasan
 * @since 30/1/22 11:50 pm
 */
public class TaleOfTwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    static class MyQueue<E> {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        MyQueue() {

        }

        public void enqueue(int n) {
            if (stack1.isEmpty())
                stack1.push(n);
        }

        public int dequeue() {
            if (stack1.isEmpty() && stack2.isEmpty())
                throw new IllegalStateException();
            if (stack2.isEmpty()) {
                copyElements(stack1, stack2);
            }
            return (int) stack2.pop();
        }

        public int peek() {
            if (stack1.isEmpty() && stack2.isEmpty())
                throw new IllegalStateException();
            if (stack2.isEmpty()) {
                copyElements(stack1, stack2);
            }
            return (int) stack2.peek();
        }

        public void copyElements(Stack<Integer> stack1, Stack<Integer> stack2) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
