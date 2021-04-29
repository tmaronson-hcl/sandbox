package com.hcl.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*
 * Adapted from https://www.baeldung.com/java-binary-tree. Added
 * tests and some other features. Author used a lot of published
 * code found somewhere. This cannot change much from various
 * examples because binary tree code and other algorithms are common.
 */

public class BinaryTree {
	
	private Node root;
	private List<Integer> list = new ArrayList<>();
	
	class Node {
	    int value;
	    Node left;
	    Node right;

	    Node(int value) {
	        this.value = value;
	        right = null;
	        left = null;
	    }
	    
	    
	}
	
	
	
	public Node getRoot() {
		return root;
	}

	private Node addRecursive(Node current, int value) {
	    if (current == null) {
	        return new Node(value);
	    }

	    if (value < current.value) {
	        current.left = addRecursive(current.left, value);
	    } else if (value > current.value) {
	        current.right = addRecursive(current.right, value);
	    } else {
	        // value already exists
	        return current;
	    }

	    return current;
	}
	
	public void add(int value) {
	    root = addRecursive(root, value);
	}
	
	BinaryTree createBinaryTree() {
	    BinaryTree bt = new BinaryTree();

	    bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);

	    return bt;
	}
	
	private boolean containsNodeRecursive(Node current, int value) {
	    if (current == null) {
	        return false;
	    } 
	    if (value == current.value) {
	        return true;
	    } 
	    return value < current.value
	      ? containsNodeRecursive(current.left, value)
	      : containsNodeRecursive(current.right, value);
	}
	
	public boolean containsNode(int value) {
	    return containsNodeRecursive(root, value);
	}
	
	private Node deleteRecursive(Node current, int value) {
	    if (current == null) {
	        return null;
	    }

	    // Node to delete found
	    if (value == current.value) {
	        
	    	// no children
	        if (current.left == null && current.right == null) {
	    	    return null;
	    	}
	        
	        // 1 child
	    	if (current.right == null) {
	    	    return current.left;
	    	}

	    	if (current.left == null) {
	    	    return current.right;
	    	}
	    	
	    	// 2 children
	    	int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
	    	
	    } 
	    if (value < current.value) {
	        current.left = deleteRecursive(current.left, value);
	        return current;
	    }
	    current.right = deleteRecursive(current.right, value);
	    return current;
	}
	
	private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

	// Start delete process from root node.
	public void delete(int value) {
	    root = deleteRecursive(root, value);
	}
	
	// in-order traversal of tree  3 4 5 6 7 8 9
	public List<Integer> traverseInOrder(Node node) {
		
	    if (node != null) {
	    	traverseInOrder(node.left);
	        //System.out.print(" " + node.value);
	        list.add(node.value); // visit root
	        traverseInOrder(node.right);
	    }
	    return list;
	}
	
	// pre-order traversal of tree  6 4 3 5 8 7 9
	public List<Integer> traversePreOrder(Node node) {
	    if (node != null) {
	        //System.out.print(" " + node.value);
	    	list.add(node.value); // visit root
	        traversePreOrder(node.left);
	        traversePreOrder(node.right);
	    }
	    return list;
	}
	
	// post-order traversal of tree  3 5 4 7 9 8 6
	public List<Integer> traversePostOrder(Node node) {
	    if (node != null) {
	        traversePostOrder(node.left);
	        traversePostOrder(node.right);
	        //System.out.print(" " + node.value);
	        list.add(node.value); // visit root
	    }
	    return list;
	}
	
	public List<Node> traverseLevelOrder() {
	    if (root == null) {
	        return null;
	    }

	    Queue<Node> nodes = new LinkedList<>();  // Why a queue?
	    List<Node> lst = new ArrayList<>();  // Store nodes for testing.
	    nodes.add(root);

	    while (!nodes.isEmpty()) {

	        Node node = nodes.remove();

	        //System.out.print(" " + node.value);
	        lst.add(node);

	        if (node.left != null) {
	            nodes.add(node.left);
	        }

	        if (node.right != null) {
	            nodes.add(node.right);
	        }
	    }
		return lst;
	}
	
	public List<Node> traverseInOrderWithoutRecursion() {  // 3 4 5 6 7 8 9
        Stack<Node> stack = new Stack<>();
        List<Node> lst = new ArrayList<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            Node top = stack.pop();
            lst.add(top);
            current = top.right;
        }
		return lst;
    }
	
}

