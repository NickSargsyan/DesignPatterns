package VisitorPattern;


//VisitorPattern model will introduce usage of Visitor Pattern

public class VisitorPatternModel
{
	public static void main(String[] args)
	{
		//Creating objects to visit
		SumPare sumpare = new SumPare(4 , 7);
		MultyPare multypare = new MultyPare(5 , 11);

		//Creating visitor
		SetVisitor visitor = new SetVisitor();

		//operation method passes request to visitor's visit method
		sumpare.operation(visitor);
		multypare.operation(visitor);
	}
}


//NumberPare, our elements to visit

interface NumberPare
{
	//operation method. It's real realization will be written in SetVisitor class
	public void operation(SetVisitor visitor);
}


//SumPare class
class SumPare implements NumberPare
{
	int x;
	int y;

	public SumPare(int x , int y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public void operation(SetVisitor visitor)
	{
		//Idea of operation method of this class is to print sum of it's x and y fields
		//Work is passed to visitor object

		visitor.visit(this);
	}
}


//MultyPare class

class MultyPare implements NumberPare
{
	int x;
	int y;

	public MultyPare(int x , int y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public void operation(SetVisitor visitor)
	{
		//Idea of operation method of this class is to print multyplication of it's x and y fields
		//Work is passed to visitor object

		visitor.visit(this);
	}
}


//SetVisitor, visitor class

class SetVisitor
{
	public void visit(SumPare sumpare)
	{
		//visit method for SumPare objects

		int sum = sumpare.x + sumpare.y;

		System.out.println(sumpare.x + " + " + sumpare.y + " = " + sum);
	}

	public void visit(MultyPare multypare)
	{
		//visit method for MultyPare objects
		
		int multy = multypare.x * multypare.y;

		System.out.println(multypare.x + " * " + multypare.y + " = " + multy);
	}
}