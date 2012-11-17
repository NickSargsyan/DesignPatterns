package FlyweightPattern;

import java.util.Map;
import java.util.HashMap;


//This is an example of Fluweight Pattern
//Idea of this pattern is to have Singleton Factory,
//that will instantiate and store instantiated objects of relative classes,
//wich are expensive to instantiate several times

public class FlyweightPatternModel
{
	public static void main(String[] args)
	{
		//Creating two archers via factory

		FlyweightFactory factory = FlyweightFactory.get_instance();

		Troop archer1 = factory.create_Troop("Archer");
		
		archer1.act();

		Troop archer2 = factory.create_Troop("Archer");
		
		archer2.act();	
	}
}


//Troop is our flyweight inteface

interface Troop
{
	public void act();
}


//Two flyweight classes - Archer and Pikeman
//There is sleep command in their constructors to imtate long build process

class Archer implements Troop
{
	public Archer()
	{
		try
		{
			Thread.sleep(2000);

			System.out.println("Archer created!");
		}
		catch(InterruptedException exception)
		{
			exception.printStackTrace();
		}
	}

	public void act()
	{
		System.out.println("Archers moving!");
	}
}


class Pikeman implements Troop
{
	public Pikeman()
	{
		try
		{
			Thread.sleep(3000);

			System.out.println("Pikeman created");
		}
		catch(InterruptedException exception)
		{
			exception.printStackTrace();
		}
	}

	public void act()
	{
		System.out.println("Pikeman on position!");
	}
}


//FlywieghtFactory is factory of flyweights
//It is singletone class, so it has private static FlyweightFactory field,
//private constructor and static get_instance() method

class FlyweightFactory
{
	private static FlyweightFactory factory;

	//In this HashMap we will store already instantited classes for future re-use
	private Map<String , Troop> pool;

	private FlyweightFactory()
	{
		pool = new HashMap<String , Troop>();
	}

	public static FlyweightFactory get_instance()
	{
		if(factory == null)
		{
			factory = new FlyweightFactory();
		}

		return factory;
	}

	public Troop create_Troop(String type)
	{
		//This method is creating troops if they are not instantiated
		//or getting them from HashMap, otherwise

		Troop troop;

		if(pool.containsKey(type))
		{
			System.out.println(type + " has already been instantiated!");

			return pool.get(type);
		}

		System.out.println(type + " has not been instantiated!");
		System.out.println("Instatntiating " + type + "...");

		//Look, what type of troop to instantiate

		if (type.equals("Archer"))
		{
			troop = new Archer();
		}
		else
		{
			troop = new Pikeman();
		}

		pool.put(type , troop);

		return troop;
	}
}