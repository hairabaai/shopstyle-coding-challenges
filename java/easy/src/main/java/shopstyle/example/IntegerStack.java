package shopstyle.example;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.lang.Integer;


/**
 * An {@link Integer} implementation of {@link Stack}.
 *
 * <p>Instances of this class are not thread-safe.</p>
 */
final class IntegerStack implements Stack{
	private static final int MAX_SIZE_DEFAULT = 10;

	private final int maxSize;
	private int currentSize;
	private List<Integer> stack;


	public IntegerStack(int maxSize) {
		this.maxSize = maxSize;
		this.currentSize = 0;
		stack = new LinkedList<>();
	}

	public IntegerStack() {
		this.maxSize = MAX_SIZE_DEFAULT;
		this.currentSize = 0;
		stack = new LinkedList<>();
	}

	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	@Override
	public Optional peek() {
		if (currentSize == 0) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(stack.get(currentSize-1));
		}
	}

	@Override
	public Optional pop() {
		if (currentSize == 0) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(stack.remove(--currentSize));
		}
	}

	@Override
	public void push(Object val) {
		if (!(val instanceof Integer)) {
			System.out.println("Wrong data type!");
			return;
		} else if(currentSize == maxSize) {
			System.out.println("Stack is full!");
			return;
		}
		stack.add((Integer) val);
		currentSize++;
	}
}
