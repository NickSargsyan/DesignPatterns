package CompositePattern;

import java.util.ArrayList;


//CompositePatternModel is an example of Composite Pattern
//For me, Composite Pattern is loocks like Observer Pattern,
//but here we call related methods of Composite's children if someone call method of
//Composite itself.

public class CompositePatternModel
{
	public static void main(String[] args)
	{
		//Creating two composite nodes and three leafes
		//Tree is:
		//				/>fist_leaf
		//fist_composite->second_composite->thirth_leaf
		//				\>second_leaf

		Composite first_composite = new Composite("Fist Composite");
		Composite second_composite = new Composite("Second Composite");

		Leaf first_leaf = new Leaf("Fist Leaf");
		Leaf second_leaf = new Leaf("Second Leaf");
		Leaf thirth_leaf = new Leaf("Thisth Leaf");

		first_composite.add_child(first_leaf);
		second_composite.add_child(thirth_leaf);
		first_composite.add_child(second_composite);
		first_composite.add_child(second_leaf);

		first_composite.respond();
	}
}


//interface Component is same as Node structures for Tree data structure

interface Component
{
	public void respond();
}


//Leaf, a Component without children

class Leaf implements Component
{
	String name;

	public Leaf(String name)
	{
		this.name = name;
	}

	@Override
	public void respond()
	{
		System.out.println("I'm leave and I'm the " + this.name);
	}
}


//Composite, it has children, other Composites and Leafes

class Composite implements Component
{
	String name;

	ArrayList<Component> children;

	public Composite(String name)
	{
		this.name = name;

		children = new ArrayList();
	}

	public void respond()
	{
		System.out.println("I'm node and I'm the " + this.name);

		//Calling respond method for children
		
		for (Component child : children)
		{
			child.respond();
		}
	}

	public void add_child(Component child)
	{
		children.add(child);
	}

	public void remove_child(Component child)
	{
		children.remove(child);
	}
}