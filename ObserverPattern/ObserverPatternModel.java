package ObserverPattern;

import java.util.ArrayList;
import java.util.Iterator;


//ObserverPatternModel class shows usage of Observer Pattern

public class ObserverPatternModel
{
	public static void main(String[] args)
	{
		//Creating PetrolTank
		PetrolTank mytank = new PetrolTank(10);

		//And it's three observers
		PetrolMeter mymeter = new PetrolMeter();
		Engine myengine = new Engine();
		Driver me = new Driver();

		//Adding observers
		mytank.add_observer(mymeter);
		mytank.add_observer(myengine);
		mytank.add_observer(me);

		//Doing changes in mytank, looking at observers response

		System.out.println("Changing petrol value in tank to 0");
		mytank.set_petrol(0);

		System.out.println("Changing petrol value in tank to 5");
		mytank.set_petrol(5);
	}
}


//PetrolTank, our subject

class PetrolTank
{
	//It has the value of petrol and list of observers to notify
	private int petrol_value;
	private ArrayList<PetrolTankObserver> observers;

	public PetrolTank(int petrol_value)
	{
		//Constructor

		this.petrol_value = petrol_value;

		this.observers = new ArrayList();
	}

	public void add_observer(PetrolTankObserver observer)
	{
		//Adding observer

		this.observers.add(observer);
	}

	public void remove_observer(PetrolTankObserver observer)
	{
		//Removing observer

		observers.remove(observer);
	}

	public void do_notify()
	{
		//Notifying observers about the changes in subject PetrolTank object

		Iterator<PetrolTankObserver> iterator = observers.iterator();

		while(iterator.hasNext())
		{
			iterator.next().respond(this.petrol_value);
		}
	}

	public void set_petrol(int petrol_value)
	{
		//Changing value of petrol

		this.petrol_value = petrol_value;

		//Notifying about changes

		this.do_notify();
	}
}


//This interface is discribing an observer for our subject

interface PetrolTankObserver
{
	//Method to respond the changes in subject object
	//This method is called from subject's do_notify method, when change occures

	public void respond(int petrol_value);
}


//Engine, PetrolMeter and Driver are observer classes implementing PetrolTankObserver interface
//They also override respond method as they need

class Engine implements PetrolTankObserver
{
	@Override
	public void respond(int petrol_value)
	{
		if (petrol_value == 0)
		{
			System.out.println("Engine dies...");
		}
		else
		{
			System.out.println("Engine is working!");
		}
	}
}


class PetrolMeter implements PetrolTankObserver
{
	@Override
	public void respond(int petrol_value)
	{
		System.out.println("Petrol Mater shows " + petrol_value);
	}
}

class Driver implements PetrolTankObserver
{
	@Override
	public void respond(int petrol_value)
	{
		if (petrol_value == 0)
		{
			System.out.println("So I'm stack...");
		}
		else
		{
			System.out.println("On the road again!");
		}
	}
}