package PrototypePattern;


//Model of Prototype Pattern
//The idea is to take adecuate copies from excisting objects

public class PrototypePatternModel
{
	public static void main(String[] args)
	{
		Fregate fregate1 = new Fregate(40);

		System.out.println(fregate1);

		System.out.println("Taking copy from fregate");

		Fregate fregate2 = fregate1.doClone();

		System.out.println(fregate2);
	}
}


//Class with doClone method, wich allow to take copy

class Fregate
{
	private  int cannons;

	public Fregate(int cannons)
	{
		this.cannons = cannons;
	}

	public Fregate doClone()
	{
		return new Fregate(this.cannons);
	}

	public String toString()
	{
		return "Fregate with " + this.cannons + " cannons!";
	}
}