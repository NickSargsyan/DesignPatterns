package BridgePattern;


//Idea of Bridge Pattern is to separate some interface from abstract class
//Doing this, we can change some charachteristics of this class without creating new relative classes

public class BridgePatternModel
{
	public static void main(String[] args)
	{
		//Creating brig and changing it's sails

		Brig brig = new Brig(new LatinSail());

		brig.get_sailset();

		System.out.println("Setting another sails to brig");

		brig.set_sail(new StreightSail());

		brig.get_sailset();
	}
}


//We separate Sail interface from abstract class Ship

abstract class Ship
{
	Sail sail;
	int masts;

	public Ship(Sail sail)
	{
		this.sail = sail;
	}

	public void get_sailset()
	{
		System.out.println("There are " + sail + " on " + masts + " masts");
	}

	public void set_sail(Sail sail)
	{
		this.sail = sail;
	}
}


//Some child of Ship

class Brig extends Ship
{
	public Brig(Sail sail)
	{
		super(sail);

		masts = 2;
	}
}


//Interface Sail and it's to children

interface Sail
{
	public String toString();
}


class LatinSail implements Sail
{
	public String toString()
	{
		return "Latin sails";
	}
}


class StreightSail implements Sail
{
	public String toString()
	{
		return "Streight sails";
	}
}