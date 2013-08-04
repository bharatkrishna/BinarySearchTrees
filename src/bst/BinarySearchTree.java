package bst;

import java.util.Stack;

/**
 * Generic Binary Search Tree class. Implements Comparable Interface. 
 * @author Bharat
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {
	private Node<T> root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	/***************** Public Interfaces *****************/
	/**
	 * Recursive insert
	 * @param data
	 */
	public void insert(T data) {
		root = insert(root, data);
	}

	public void printPreOrder() {
		printPreOrder(root);
	}

	public void printPostOrder() {
		printPostOrder(root);
	}
	
	public void printInOrder() {
		printInOrder(root);
	}

	public void printPreOrderIterative() {
		printPreOrderIterative(root);
	}

	public void printInOrderIterative() {
		printInOrderIterative(root);
	}
	
	public void printPostOrderIterative() {
		printPostOrderIterative(root);
	}
	/***************** Private Implementations *****************/
	
	private Node<T> insert(Node<T> node, T data) {
		if (node == null) {
			node = new Node<T>(data);
		}
		
		int compareResult = data.compareTo(node.getData());
		
		if (compareResult < 0) { 		// If data < node's data
			Node<T> newNode = insert(node.getLeft(), data);
			node.setLeft(newNode);
		}
			
		else if (compareResult > 0) { 	// If data > node's data
			Node<T> newNode = insert(node.getRight(), data);
			node.setRight(newNode);
		}
		
		return node;
	}
	
	private void printPreOrder(Node<T> root) {
		if (root == null) return;
		
		root.printValue();
		printPreOrder(root.getLeft());
		printPreOrder(root.getRight());
	}
	
	private void printPostOrder(Node<T> root) {
		if (root == null) return;
		
		printPostOrder(root.getLeft());
		printPostOrder(root.getRight());
		root.printValue();
	}
	
	private void printInOrder(Node<T> root) {
		if (root == null) return;
		
		printInOrder(root.getLeft());
		root.printValue();
		printInOrder(root.getRight());
	}
	
	private void printPreOrderIterative(Node<T> root) {
		Stack<Node<T>> stack = new Stack<Node<T>>();
		
		stack.push(root);
		while (!stack.isEmpty()) {
			Node<T> current = stack.pop();
			current.printValue();
			// Push the right node first since stack is LIFO. 
			// We want left node to come out first.
			if (current.getRight() != null)
				stack.push(current.getRight());
			
			if (current.getLeft() != null)
				stack.push(current.getLeft());
		}
	}
	
	private void printInOrderIterative(Node<T> root) {
		Stack<Node<T>> stack = new Stack<Node<T>>();
		Node<T> current = root;
		
		while (true) {
			// Keep pushing left node till hitting a null leaf
			if (current != null) {
				stack.push(current);
				current = current.getLeft();
			} 
			// Pop, print and go to right node
			else {
				if (stack.isEmpty()) 
					return;
				current = stack.pop();
				current.printValue();
				current = current.getRight();
			}
		}
	}
	
	private void printPostOrderIterative(Node<T> root) {
		// Using 2 Stacks.
		Stack<Node<T>> stack1 = new Stack<Node<T>>();
		Stack<Node<T>> stack2 = new Stack<Node<T>>();
		
		Node<T> current = root;
		stack1.push(current);
		
		while (!stack1.isEmpty()) {
			current = stack1.pop();
			stack2.push(current);
			
			if (current.getLeft() != null) 
				stack1.push(current.getLeft());
			
			if (current.getRight() != null) 
				stack1.push(current.getRight());
			
		}

		while (!stack2.isEmpty()) {
			current = stack2.pop();
			current.printValue();
		}
	}
	
}
