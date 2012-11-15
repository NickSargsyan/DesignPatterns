package DecoratorPattern;


//DecoratPatternModel shows example of Decorator Pattern usage
//Decorator Pattern adds new abilities to cuurent object

public class DecoratorPatternModel
{
	public static void main(String[] args)
	{
		//Creating SomeClass object and decorating it

		SomeInterface some_object = new SomeClass();

		some_object.respond();

		some_object = new FirstDecorator(some_object);

		some_object.respond();

		some_object = new SecondDecorator(some_object);

		some_object.respond();
	}
}


//Some Interface

interface SomeInterface
{
	public void respond();
}


//Some Class

class SomeClass implements SomeInterface
{
	@Override
	public void respond()
	{
		System.out.println("I'm some class.");
	}
}


//Decorator

abstract class Decorator implements SomeInterface
{
	abstract public void respond();
}


//Here are two decorators with following structure - they have referance to SomeInterface object
//which they get in constructor
//Idea is that we are referencing to old object some new object that contains it's old method code
//via object field and also has some new abilities, this all done via new operation

class FirstDecorator extends Decorator
{
	SomeInterface object;

	public FirstDecorator(SomeInterface object)
	{
		this.object = object;
	}

	@Override
	public void respond()
	{
		object.respond();

		System.out.println("First Decorator decorates me.");
	}
}


class SecondDecorator extends Decorator
{
	SomeInterface object;

	public SecondDecorator(SomeInterface object)
	{
		this.object = object;
	}

	@Override
	public void respond()
	{
		object.respond();

		System.out.println("Second Decorator decorates me.");

		new_ability();
	}

	public void new_ability()
	{
		System.out.println("I have new ability!!");
	}
}