package FactoryPattern;


public class FactoryPatternModel
{
	public static void main(String[] args)
	{
		Factory factory = new Factory();

		Troop infantry = factory.create_troop("Infantry");
		Troop artillery = factory.create_troop("Artillery");
		Troop cavalery = factory.create_troop("Cavalary");

		infantry.act();
		artillery.act();
		cavalery.act();
	}
}


class Factory
{
	public Factory()
	{
		System.out.println("Factory craeted!");
	}

	public Troop create_troop(String name)
	{
		if (name.equals("Infantry"))
		{
			return new Infantry();
		}
		else if (name.equals("Artillery"))
		{
			return new Artillery();
		}
		else
		{
			return new Cavalary();
		}
	}
}


interface Troop
{
	public void act();
}


class Infantry implements Troop
{
	public Infantry()
	{
		System.out.println("Infantry craeted!");
	}

	@Override
	public void act()
	{
		System.out.println("Infantry marching!");
	}
}


class Artillery implements Troop
{
	public Artillery()
	{
		System.out.println("Artillery craeted!");
	}

	@Override
	public void act()
	{
		System.out.println("Artillery on positions!");
	}
}


class Cavalary implements Troop
{
	public Cavalary()
	{
		System.out.println("Cavalary craeted!");
	}

	@Override
	public void act()
	{
		System.out.println("Cavalary unchained!");
	}
}