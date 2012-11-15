package AdapterPattern;


//AdapterPatternModel illustrates usage of Adapter Pattern
//Idea of Adapter Pattern is to adapt old class for new needs without changing it's code

public class AdapterPatternModel
{
	public static void main(String[] args)
	{
		//Testing class adapter

		MileMeterClassAdapter class_adapter = new MileMeterClassAdapter();
		class_adapter.set_meter(3);
		System.out.println("Setting 5 meters to class adapter, it returns: " + class_adapter.get_meter() + " meters and " + class_adapter.get_mile() + " miles.");
		class_adapter.set_mile(3);
		System.out.println("Setting 5 miles to class adapter, it returns: " + class_adapter.get_meter() + " meters and " + class_adapter.get_mile() + " miles.");
	

		//Testing object adapter
		MileMeterObjectAdapter object_adapter = new MileMeterObjectAdapter();
		object_adapter.set_meter(3);
		System.out.println("Setting 5 meters to class adapter, it returns: " + object_adapter.get_meter() + " meters and " + object_adapter.get_mile() + " miles.");
		object_adapter.set_mile(3);
		System.out.println("Setting 5 miles to class adapter, it returns: " + object_adapter.get_meter() + " meters and " + object_adapter.get_mile() + " miles.");
	}
}


//Meter, this class we will adapt

class Meter
{
	//Meter containes filed meter
	//It has to methods - get_meter and set_meter

	double meter;

	public double get_meter()
	{
		return meter;
	}

	public void set_meter(double meter)
	{
		this.meter = meter;
	}
}


//MileMeterAdapter adapts Meter class to work with miles

interface MileMeterAdapter
{
	public void set_mile(double mile);

	public double get_mile();
}


//MileMeterClassAdapter extends Meter class and impements MileMeterAdapter interface
//It uses methods of Meter class to work with meters and overrides methods of MileMeterAdapter
//to work with miles
//When passed to MileMeterClassAdapter, miles are converted to meters and stored in meter field
//of Meter parent class

class MileMeterClassAdapter extends Meter implements MileMeterAdapter
{
	@Override
	public void set_mile(double mile)
	{
		this.meter = mile * 2.0 / 3.0;
	}

	@Override
	public double get_mile()
	{
		return 1.5 * this.meter;
	}
}


//MileMeterObjectAdapter impements MileMeterAdapter interface
//It containes field of Meter type, the object meter_object, via this object it adapts old Meter class
//fields and methods and because of this this adapter type is called object adapter 
//It has own methods to work with meters,
//but they us Meter class methods via meter_object object
//and overrides methods of MileMeterAdapter to work with miles
//When passed to MileMeterObjectAdapter, miles are converted to meters and stored in meter field
//of Meter parent class

class MileMeterObjectAdapter implements MileMeterAdapter
{
	Meter meter_object;

	public MileMeterObjectAdapter()
	{
		meter_object = new Meter();
	}

	@Override
	public void set_mile(double mile)
	{
		this.meter_object.set_meter(mile * 2.0 / 3.0);
	}

	@Override
	public double get_mile()
	{
		return 1.5 * this.meter_object.get_meter();
	}

	public void set_meter(double meter)
	{
		this.meter_object.set_meter(meter);
	}

	public double get_meter()
	{
		return this.meter_object.get_meter();
	}
}