package bst;

public class Node<T> {
	private Node<T> left;
	private Node<T> right;
	private T data;
	
	public Node(T data) {
		this.setData(data);
		setLeft(null);
		setRight(null);
	}
	
	public void printValue() {
		System.out.println(data);
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
