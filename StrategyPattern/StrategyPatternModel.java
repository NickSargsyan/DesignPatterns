package StrategyPattern;


//StrategyPatternModel class shows example of Strategy Pattern use
//Strategy Pattern is very similar to State Pattern, for me
//In both of them class can change his behaviour,
//But if in State Pattern it was done automatically because of State changes,
//In Strategy Pattern we must change the behaviour manually

public class StrategyPatternModel
{
	public static void main(String[] args)
	{
		//Three Strategy objects

		HeroStrategy courage = new Coureage();
		HeroStrategy pragmatic = new Pragmatic();
		HeroStrategy scared = new Scared();

		//Context object

		Hero hero = new Hero(8 , courage);

		//Acting by Courage strategy
		System.out.println("Acting by Courage strategy");
		hero.act();

		//Changing strategy to Pragmatic
		System.out.println("Changing strategy to Pragmatic");
		hero.set_strategy(pragmatic);
		hero.act();

		//Changing strategy to Scared and enemy_cout to 30
		System.out.println("Changing strategy to Scared and enemy_cout to 30");
		hero.set_enemy_count(30);
		hero.set_strategy(scared);
		hero.act();
	}
}


//HeroStrategy interface. Alghorytms of hero behavior shares this interface

interface HeroStrategy
{
	public void act(int enemy_count);	

	//This will used by println to print strategies name
	public String toString();
}


//Three different behaviours, or strategies, which from we can choose strategy to Hero object

class Coureage implements HeroStrategy
{
	@Override
	public void act(int enemy_count)
	{
		if (enemy_count <= 70)
		{
			System.out.println("My courage is insubmersible!!!");
		}
		else
		{
			System.out.println("This is not an easy work even for Superman...");
		}
	}

	@Override
	public String toString()
	{
		return "Coureage";
	}
}


class Pragmatic implements HeroStrategy
{
	@Override
	public void act(int enemy_count)
	{
		if (enemy_count <= 10)
		{
			System.out.println("This is easy work for my allies. I'll go and sleep :P");
		}
		else if (enemy_count > 10 && enemy_count <= 30)
		{
			System.out.println("Let me see what is happening... Attack!");
		}
		else
		{
			System.out.println("Nope!");
		}
	}

	@Override
	public String toString()
	{
		return "Pragmatic";
	}
}


class Scared implements HeroStrategy
{
	@Override
	public void act(int enemy_count)
	{
		if (enemy_count <= 10)
		{
			System.out.println("I like pease, but if you say...");
		}
		else
		{
			System.out.println("NOPE!!!");
		}
	}

	@Override
	public String toString()
	{
		return "Scared";
	}
}


//Hero, our Context class

class Hero
{
	//It contains referance to HeroStrategy
	int enemy_count;
	HeroStrategy strategy;

	public Hero(int enemy_count , HeroStrategy strategy)
	{
		//Constructor

		this.enemy_count = enemy_count;

		this.strategy = strategy;
	}

	public void set_strategy(HeroStrategy strategy)
	{
		//Setting new strategy

		this.strategy = strategy;
	}

	public void set_enemy_count(int enemy_count)
	{
		//Setting new enemy_count

		this.enemy_count = enemy_count;
	}

	public void act()
	{
		//Acting
		//Work is passing to HeroStrategy-s act method via referance

		System.out.println("There is " + enemy_count + " enemy arround and I'm " + strategy);
		this.strategy.act(this.enemy_count);
	}
}