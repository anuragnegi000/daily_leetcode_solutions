import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    private Stack<Iterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.peek().next().getInteger();
        }
        return null; // You can handle this case based on your requirements.
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else {
                NestedInteger current = stack.peek().next();
                if (current.isInteger()) {
                    // If the current element is an integer, push it back to the stack.
                    stack.push(List.of(current).iterator());
                    return true;
                } else {
                    // If it's a nested list, push its iterator onto the stack.
                    stack.push(current.getList().iterator());
                }
            }
        }
        return false;
    }
}
