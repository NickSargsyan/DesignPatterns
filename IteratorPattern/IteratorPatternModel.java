package IteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;


//Iterator allows as to go through structures nodes
//Here is an examople of usage

public class IteratorPatternModel
{
	public static void main(String[] args)
	{
		NodeArrayList list = new NodeArrayList();

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);

		list.insert(n1);
		list.insert(n2);
		list.insert(n3);

		Iterator iterator = list.get_Iterator();

		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}


//Node of our list

class Node
{
	int info;

	public Node(int info)
	{
		this.info = info;
	}

	public String toString()
	{
		return info + "";
	}
}


//List

class NodeArrayList
{
	ArrayList<Node> nodes;

	public NodeArrayList()
	{
		nodes = new ArrayList<Node>();
	}

	public void insert(Node node)
	{
		nodes.add(node);
	}

	public void remove(Node node)
	{
		nodes.remove(node);
	}

	public Iterator get_Iterator()
	{
		return new NodeIterator();
	}

	//Iterator is private inner class
	//This is done for other classes and client to get access to iterator
	//only via get_Iterator method
	//Our NodeIterator implements Iterator interface
	
	private class NodeIterator implements Iterator
	{
		int pos;

		public NodeIterator()
		{
			pos = 0;
		}

		public boolean hasNext()
		{
			return pos < nodes.size();
		}

		public Node next()
		{
			return nodes.get(pos++);
		}

		public void remove()
		{
			nodes.remove(pos--);
		}
	}
}