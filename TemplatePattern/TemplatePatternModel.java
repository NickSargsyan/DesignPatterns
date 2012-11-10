package TemplatePattern;


//TemplatePatternModel, that will show the usage of templates

public class TemplatePatternModel
{
	public static void main(String[] args)
	{
		//Creating three types of troops based on the Troop class
		Pikeman pikeman = new Pikeman(10 , 20 , 1);
		Riffleman riffleman = new Riffleman(15 , 30 , 1);
		Croat croat = new Croat(0 , 0 , 2);

		//Little presentation of their function usage
		pikeman.move(15 , 20);
		riffleman.fire(0 , 1);
		croat.drive(10 , 10);
		pikeman.move(10 , 15);
		croat.charge(10 , 15);
		pikeman.charge(10 , 15);
		croat.remove();
	}
}


//Class Troop, parent class for all troops

abstract class Troop
{
	//Contains type, position and id of army
	String type;
	int x;
	int y;
	int army_id;

	public Troop(int x , int y , int army_id , String type)
	{
		//Constructor, initialize the troop

		this.x = y;
		this.y = x;
		this.army_id = army_id;
		this.type = new String(type);

		System.out.println(this.type + " added to army " + this.army_id + " in position " + this.x + " " + this.y);
	}

	public final void move(int x , int y)
	{
		//Moving troop to specified position
		//Method is final, could not be reinitialized

		this.x = x;
		this.y = y;

		System.out.println(this.type + " moved to " + this.x + " " + this.y);
	}

	public final void remove()
	{
		//Removing troop after it is killed
		//Method is final, could not be reinitialized

		System.out.println(this.type + " killed and removed from " + this.x + " " + this.y + " position of army " + this.army_id);
	}

	//Method charge. It will reinitialize by the troops
	public abstract void charge(int x , int y);
}


class Pikeman extends Troop
{
	public Pikeman(int x , int y , int army_id)
	{
		super(x , y , army_id , "Pikeman");
	}

	@Override
	public void charge(int x , int y)
	{
		//This is reinitialization of charge method of Troop parent class
		//Pikeman charges with spearing enemy	

		//Because charge is close-distantion ability, troop must move their first

		this.x = x;
		this.y = y;

		System.out.println("Pikemen speared the position " + this.x + " " + this.y);
	}
}


class Riffleman extends Troop
{
	public Riffleman(int x , int y , int army_id)
	{
		super(x , y , army_id , "Riffleman");
	}

	@Override
	public void charge(int x , int y)
	{
		//This is reinitialization of charge method of Troop parent class
		//Riffleman charges with a knife	

		//Because charge is close-distantion ability, troop must move their first

		this.x = x;
		this.y = y;

		System.out.println("Riffleman hits whith knife position " + this.x + " " + this.y);
	}

	public void fire(int x , int y)
	{
		//Riffleman is long distantion unit, too
		//It has his own, not reinitialized method fire

		System.out.println("Riffleman fires in the position " + x + " " + y);
	}
}


class Croat extends Troop
{
	public Croat(int x , int y , int army_id)
	{
		super(x , y , army_id , "Croat");
	}

	@Override
	public void charge(int x , int y)
	{
		//This is reinitialization of charge method of Troop parent class
		//Croat charges with a sword

		//Because charge is close-distantion ability, troop must move their first

		this.x = x;
		this.y = y;

		System.out.println("Croat hits with sword position " + this.x + " " + this.y);
	}

	public void drive(int x , int y)
	{
		//Croat is a horseman, he can drive too

		this.x = y;
		this.y = x;

		System.out.println("Croat drives to position " + this.x + " " + this.y);
	}
}