package AbstractFactoryPattern;


//Abstract factory is factory of factories

public class AbstractFactoryPatternModel
{
	public static void main(String[] args)
	{
		//Creating abstract factory,
		//then creating two factories with it,
		//and then creating four ships with this factories

		AbstractFactory abstract_factory = new AbstractFactory();\

		Dock trade = abstract_factory.create_dock("TradeShipDock");
		Dock battle = abstract_factory.create_dock("BattleShipDock");

		Ship cleeper = trade.create_ship("Cleeper");
		Ship cutter = trade.create_ship("Cutter");
		Ship fregate = battle.create_ship("Fregate");
		Ship galeon = battle.create_ship("Galeon");

		cleeper.act();
		cutter.act();
		fregate.act();
		galeon.act();	
	}
}


//Our abstract factory

class AbstractFactory
{
	public AbstractFactory()
	{
		System.out.println("Abstract Factory created!");
	}

	public Dock create_dock(String type)
	{
		//Return different factories in case of type given

		if(type.equals("TradeShipDock"))
		{
			return new TradeShipDock();
		}
		else
		{
			return new BattleShipDock();
		}
	}
}


//Dock is our factory

interface Dock
{
	public Ship create_ship(String type);
}


//Here are two different docks, our factories

class TradeShipDock implements Dock
{
	public TradeShipDock()
	{
		System.out.println("Trade Ship Dock created!");
	}

	@Override
	public Ship create_ship(String type)
	{
		if (type.equals("Cleeper"))
		{
			return new Cleeper();
		}
		else
		{
			return new Cutter();
		}
	}
}


class BattleShipDock implements Dock
{
	public BattleShipDock()
	{
		System.out.println("Battle Ship Dock created!");
	}

	@Override
	public Ship create_ship(String type)
	{
		if (type.equals("Fregate"))
		{
			return new Fregate();
		}
		else
		{
			return new Galeon();
		}
	}
}


//Ship will be our object that factories create

interface Ship
{
	public void act();
}


//Cleeper and Cutter are trade ships, they are created by TradeShipDock

class Cleeper implements Ship
{
	public Cleeper()
	{
		System.out.println("Cleeper created!");
	}

	@Override
	public void act()
	{
		System.out.println("Cleeper is one of most beautiful ships!");
	}
}


class Cutter implements Ship
{
	public Cutter()
	{
		System.out.println("Cutter created!");
	}

	@Override
	public void act()
	{
		System.out.println("Cutter - small and fast!");
	}
}


//Fregate and Galeon are battle ships, they are created by BattleShipDock

class Fregate implements Ship
{
	public Fregate()
	{
		System.out.println("Fregate created!");
	}

	@Override
	public void act()
	{
		System.out.println("Fregate - with force of all cannons!");
	}
}


class Galeon implements Ship
{
	public Galeon()
	{
		System.out.println("Galeon created!");
	}

	@Override
	public void act()
	{
		System.out.println("Galeon - crue on the deck!");
	}
}