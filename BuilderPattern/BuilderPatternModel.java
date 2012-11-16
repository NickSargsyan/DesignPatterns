package BuilderPattern;


//Builder Pattern creates different building alghorythms to build objects
public class BuilderPatternModel
{
	public static void main(String[] args)
	{
		//Here two types of Troop object are built

		VarangianBuilder varangian = new VarangianBuilder();
		Director director1 = new Director(varangian);

		Troop troop1 = director1.create_troop();

		System.out.println(troop1);

		CrossbowmanBulider crossbowman = new CrossbowmanBulider();
		Director director2 = new Director(crossbowman);

		Troop troop2 = director2.create_troop();

		System.out.println(troop2);	
	}
}


//Troop, objects of this type we will build

class Troop
{
	//Troop has shield, weapon and armour

	String shield;
	String weapon;
	String armour;

	public void set_armour(String armour)
	{
		this.armour = armour;
	}

	public void set_weapon(String weapon)
	{
		this.weapon = weapon;
	}

	public void set_shield(String shield)
	{
		this.shield = shield;
	}

	public String toString()
	{
		return "This troop has " + this.shield + " , " + this.weapon + " , " + this.armour + ".";
	}
}


//TroopBuilder, this interface will implement our builders

interface TroopBuilder
{
	public void set_shield();
	public void set_weapon();
	public void set_armour();

	public Troop get_troop();
}


//Here two bulders are declated.
//Fist build Varangian build, second one - Crossbowman
//They pass the exact shield, armour and weapon to the Troop object
//and return it

class VarangianBuilder implements TroopBuilder
{
	Troop troop;
	
	public VarangianBuilder()
	{
		this.troop = new Troop();
	}

	@Override
	public void set_shield()
	{
		this.troop.set_shield("Contra-Tear shield");
	}

	@Override
	public void set_weapon()
	{
		this.troop.set_weapon("Poleax");
	}

	@Override
	public void set_armour()
	{
		this.troop.set_armour("Hauberk");
	}

	@Override
	public Troop get_troop()
	{
		return troop;
	}
}


class CrossbowmanBulider implements TroopBuilder
{
	Troop troop;
	
	public CrossbowmanBulider()
	{
		this.troop = new Troop();
	}

	@Override
	public void set_shield()
	{
		this.troop.set_shield("Huge rectangle shield");
	}

	@Override
	public void set_weapon()
	{
		this.troop.set_weapon("Crossbow");
	}

	@Override
	public void set_armour()
	{
		this.troop.set_armour("Curt");
	}


	@Override
	public Troop get_troop()
	{
		return troop;
	}
}


//Diractor class overs the build process.
//He has TroopBuilder, with it he build troops.
//Director class can help, when we need, for example, all troops to be without shields
//We can declare Director class wich would not ctreate shields instead of declaring
//special non-shield constructor for each troop type

class Director
{
	TroopBuilder builder;

	public Director(TroopBuilder builder)
	{
		this.builder = builder;
	}

	public Troop create_troop()
	{
		this.builder.set_armour();
		this.builder.set_weapon();
		this.builder.set_shield();

		return this.builder.get_troop();
	}
}