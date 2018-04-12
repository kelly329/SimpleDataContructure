import java.util.Stack;

/**
 * 问题描述：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 * 解题思路：
 * 1.入队时，把所有的元素入栈stack1
 * 2.出队时，当stack2为空时把stack1所有的元素入栈到stack2 当stack2不为空时，stack1的元素已全部push到stack2，pop元素的时候从stack2出即可
 */

public class StackAndQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        //判断是否元素已全部pop
        if(stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Queue is empty");
        }

        //把stack1所有元素push到stack2
        if(stack2.empty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
