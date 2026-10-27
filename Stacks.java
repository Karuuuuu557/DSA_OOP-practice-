import java.util.Scanner;
public class Stacks {
    private static int top = -1;
    private static int[] stack;

    public static void main(String[] args) {
        Scanner stackElements = new Scanner(System.in);

        System.out.print("Enter the maximum capacity of the stack: ");
        int capacity = stackElements.nextInt();
        if (capacity <= 0) {
            System.out.println("The stack capacity must be greater than 0.");
            return;
        }

        stack = new int[capacity];
        int[] values = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            values[i] = stackElements.nextInt();
        }

        System.out.print("Starting stack: ");
        printStack();

        System.out.print("Array elements to push: ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < values.length; i++) {
            push(values[i]);
            System.out.print("Iteration " + (i + 1) + ": push " + values[i] + " -> ");
            printStack();
        }

        for (int i = 0; i < values.length; i++) {
            int removed = pop();
            System.out.print("Iteration " + (i + 1) + ": pop " + removed + " -> ");
            printStack();
        }

        System.out.print("Final stack: ");
        printStack();
    }
//HOIII STREAK YAAAAAA YOOOO
    private static void push(int value) {
        if (top == stack.length - 1) {
            System.out.println("Cannot push " + value + ": stack is full.");
            return;
        }
        top++;
        stack[top] = value;
    }

    private static int pop() {
        if (top == -1) {
            System.out.println("Cannot pop: stack is empty.");
            return -1;
        }

        int removed = stack[top];
        top--;
        return removed;
    }

    private static void printStack() {
        System.out.print("TOP -> [");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println("] <- BOTTOM");
    }
}
