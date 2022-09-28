// John De Dios Project 4 
/*
 *
 *  BinarySearchTree.java
 *
 */

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;


public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> 
{
    private Vector<E> vector;
	
    private Node<E> findIOP(Node<E> curr) {
        curr = curr.left;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> curr) {
        if (curr == null) {
            return 0;
        }
        int left = height(curr.left) + 1;
        int right = height(curr.right) + 1;
        return left > right ? left : right;
    }
    
    public Iterator<E> iterator() {
        vector = new Vector<E>();
        traverse(root);
        return vector.iterator();
    }
    
    private void traverse(Node<E> curr) {
        if (curr != null) {
            traverse(curr.left);
            vector.add(curr.data);
            traverse(curr.right);
        }
    }
    
    public void insert(E data)
    { 	
    	root = recursiveInsert(root, data);
    }
    
   private Node<E> recursiveInsert (Node <E> recursiveCurr, E data)
    {
    	if (recursiveCurr == null)
    	{
    		Node<E> temp = new Node<E> (data);
    		recursiveCurr = temp;
    	}
    	
    	else if (data.compareTo(recursiveCurr.data) <= 0)
    	{
    		recursiveCurr.left = recursiveInsert(recursiveCurr.left, data);
    	}
    	
    	else 
    	{
    		recursiveCurr.right = recursiveInsert(recursiveCurr.right, data);
    	}
    	
    	return recursiveCurr;
    }
    
    public boolean search(E data)
    {
    	return recursiveSearch (root, data); 
    }
    
    
    private boolean recursiveSearch (Node<E> recursiveCurr, E data)
    {
    	if (recursiveCurr == null)
    	{
    		return false;
    	}
    	
    	else if (data.compareTo(recursiveCurr.data) == 0)
    	{
    		return true;
    	}
    	
    	else if (data.compareTo(recursiveCurr.data) < 0)
    	{
    		return recursiveSearch(recursiveCurr.left, data);
    	}
    	
    	else
    	{
    		return recursiveSearch(recursiveCurr.right, data);
    	}
    	
    }
    
    public void remove(E data)
    {
    	root = recursiveRemove(root, data);
    }
    
    private Node<E> recursiveRemove(Node<E> recursiveCurr, E data) 
    {
    	if (recursiveCurr != null)
    	{
    		if (data.compareTo(recursiveCurr.data) < 0)
        	{
        		recursiveCurr.left = recursiveRemove(recursiveCurr.left, data);
        	}
        	
    		else if (data.compareTo(recursiveCurr.data) > 0) 
        	{
        		recursiveCurr.right = recursiveRemove(recursiveCurr.right, data);
        	}
    		
    		else
    		{
    			if (recursiveCurr.left == null && recursiveCurr.right == null)
    			{
    				recursiveCurr = null;
    			}
    			
    			else if (recursiveCurr.left == null && recursiveCurr.right != null)
    			{
    				recursiveCurr = recursiveCurr.right;
    			}
    			
    			else if (recursiveCurr.left != null && recursiveCurr.right == null)
    			{
    				recursiveCurr = recursiveCurr.left;
    			}
    			
    			else
    			{    
   		    		recursiveCurr.data = getMinLeft(recursiveCurr.right);
    				
    				recursiveCurr.right = recursiveRemove(recursiveCurr.right, recursiveCurr.data);
    			}
    			
    			
    		}
    	}
    	
    	return recursiveCurr;
    }
    
    private E getMinLeft(Node<E> tempCurr)
    {
    	
    	E tempData = tempCurr.data;
    	
    	while (tempCurr.left != null)
        {
            tempData = tempCurr.left.data;
            tempCurr = tempCurr.left;
        }
    	
        return tempData; 
    }

}