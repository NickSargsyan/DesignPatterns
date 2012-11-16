package SingletonePattern;


//Idea of Singletone Pattern is to create class(Singletone),
//which can be instatntiated only once

public class SingletonePatternModel
{
	public static void main(String[] args)
	{
		//Creating two singletone objects
		//new operation is impossible,
		//they are initialized via static get_instance method

		Singletone singletone1;

		singletone1 = Singletone.get_instance();
		singletone1.respond();

		Singletone singletone2;

		singletone2 = Singletone.get_instance();
		singletone2.respond();
	}
}


//Our Singletone class

class Singletone
{
	//Private Static Singletone object, where only instatniated singletone object
	//will be stored

	private static Singletone singletone;

	private Singletone()
	{
		//Private constructor to avoid outdoor instantiation

		System.out.println("Singletone created!");
	}

	public static Singletone get_instance()
	{
		//get_instance method returns static singletone object
		//If this object is not instantiated, method instantiates it,
		//otherwise returning already excisting object

		if (singletone == null)
		{
			System.out.println("There is no singletone instantiated.");

			singletone = new Singletone();
		}
		else
		{
			System.out.println("Singletone already instantiated!");
		}

		System.out.println("Getting instatnce of singletone");

		return singletone;
	}

	public void respond()
	{
		//some method of singletone
		
		System.out.println("Hello, I'm singletone!");
	}
}