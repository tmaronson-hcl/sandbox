package com.hcl.tree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hcl.tree.BinaryTree.Node;

class DataStructuresTests {

	private BinaryTree bt;

	@BeforeEach
	void setUp() throws Exception {
		bt = new BinaryTree().createBinaryTree();
	}

	@AfterEach
	void tearDown() throws Exception {
		bt = null;
	}

	@Test
	public void givenABinaryTreeWhenAddingElementsTestForThoseElements() {
	    
		assertTrue(bt.containsNode(6));
	    assertTrue(bt.containsNode(4));
	    assertFalse(bt.containsNode(1));
	}
	
	@Test
	public void testInOrderTraversalOfTree() {
		
		assertEquals(bt.traverseInOrder(bt.getRoot()).get(1), 4);
		assertEquals(bt.traverseInOrder(bt.getRoot()).get(4), 7);
		assertEquals(bt.traverseInOrder(bt.getRoot()).get(6), 9);
	}
	
	@Test
	public void testPreOrderTraversalOfTree() {  // 6 4 3 5 8 7 9
		
		assertEquals(bt.traversePreOrder(bt.getRoot()).get(1), 4);
		assertEquals(bt.traversePreOrder(bt.getRoot()).get(3), 5);
		assertEquals(bt.traversePreOrder(bt.getRoot()).get(6), 9);
	}
	
	@Test
	public void testPostOrderTraversalOfTree() {  // 3 5 4 7 9 8 6
		
		assertEquals(bt.traversePostOrder(bt.getRoot()).get(2), 4);
		assertEquals(bt.traversePostOrder(bt.getRoot()).get(4), 9);
		assertEquals(bt.traversePostOrder(bt.getRoot()).get(6), 6);
	}
	
	@Test
	public void testBreadthFirstTraversalOfTree() {
		
		List<Node> lst = bt.traverseLevelOrder();
		assertEquals(lst.get(2).value, 8);
		assertEquals(lst.get(5).value, 7);
	}
	
	@Test
	public void testInOrderTraversalOfTreeWithoutRecursion() {
		
		assertEquals(bt.traverseInOrder(bt.getRoot()).get(1), 4);
		assertEquals(bt.traverseInOrder(bt.getRoot()).get(4), 7);
		assertEquals(bt.traverseInOrder(bt.getRoot()).get(6), 9);
	}

}
