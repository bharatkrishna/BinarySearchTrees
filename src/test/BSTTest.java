package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import bst.BinarySearchTree;

public class BSTTest {
	BinarySearchTree<Integer> intBST;
	BinarySearchTree<Float> floatBST;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	
	private void insertItems() {
		int[] intArray = new int[] {4,5,2,1,3};
		float[] floatArray = new float[] {4f,5f,2f,1f,3f};
		int n = intArray.length;
		
		for (int i=0; i<n; i++) {
			intBST.insert(intArray[i]);
			floatBST.insert(floatArray[i]);
		}
	}
	
	@Before
	public void setUp() throws Exception {
		intBST = new BinarySearchTree<Integer>();
		floatBST = new BinarySearchTree<Float>();
		
		insertItems();
		System.setOut(new PrintStream(outContent));
	}

	/*** Recursive ***/
	@Test
	public void preOrderTest() {		
		intBST.printPreOrder();
		assertEquals("4\n2\n1\n3\n5\n", outContent.toString());
	}
	
	@Test
	public void preOrderTestFloat() {
		
		floatBST.printPreOrder();
		assertEquals("4.0\n2.0\n1.0\n3.0\n5.0\n", outContent.toString());
	}
	
	@Test
	public void inOrderTest() {		
		intBST.printInOrder();
		assertEquals("1\n2\n3\n4\n5\n", outContent.toString());
	}
	
	@Test
	public void inOrderTestFloat() {		
		floatBST.printInOrder();
		assertEquals("1.0\n2.0\n3.0\n4.0\n5.0\n", outContent.toString());
	}
	
	@Test
	public void postOrderTest() {		
		intBST.printPostOrder();
		assertEquals("1\n3\n2\n5\n4\n", outContent.toString());
	}
	
	@Test
	public void postOrderTestFloat() {		
		floatBST.printPostOrder();
		assertEquals("1.0\n3.0\n2.0\n5.0\n4.0\n", outContent.toString());
	}
	
	/*** Iterative **/
	@Test
	public void preOrderIterativeTest() {		
		intBST.printPreOrderIterative();
		assertEquals("4\n2\n1\n3\n5\n", outContent.toString());
	}
	
	@Test
	public void inOrderIterativeTest() {		
		intBST.printInOrderIterative();
		assertEquals("1\n2\n3\n4\n5\n", outContent.toString());
	}
	
	@Test
	public void postOrderIterativeTest() {		
		intBST.printPostOrderIterative();
		assertEquals("1\n3\n2\n5\n4\n", outContent.toString());
	}
	
	
	


}
