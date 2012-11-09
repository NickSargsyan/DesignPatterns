package MediatorPattern;

import java.util.ArrayList;
import java.util.Iterator;


//MediatorPatternModel will introduce usage of  Madiator Pattern

public class MediatorPatternModel
{
	public static void main(String[] args)
	{
		/*
		The collegue of our mediator are:
			two factories, that are searching producers of row
			three productores, that produce two types of row materials - peech and grape
		*/

		Mediator mediator = new Mediator();
		Factory first_factory = new Factory(mediator , "First");
		Factory second_factory = new Factory(mediator , "Second");

		//Besides mediator, price and amount of row materials are givem to the Producer classes constructor
		PeechProducer peech_producer_1 = new PeechProducer(mediator , 10 , 20);
		PeechProducer peech_producer_2 = new PeechProducer(mediator , 5 , 10);
		GraipProducer graip_producer = new GraipProducer(mediator , 15 , 30);

		//first_facory is searching for 10 amount of peech of cost 7
		first_factory.set_product_parametres(10 , 7 , "peech");
		first_factory.search_producer();

		System.out.println("");

		//second_facory is searching for 5 amount of peech of cost 9
		second_factory.set_product_parametres(5 , 9 , "peech");
		second_factory.search_producer();

		System.out.println("");

		//second_facory is searching for 5 amount of peech of cost 13
		second_factory.set_product_parametres(5 , 13 , "peech");
		second_factory.search_producer();

		System.out.println("");

		//first_facory is searching for 15 amount of graip of cost 8
		first_factory.set_product_parametres(15 , 8 , "graip");
		first_factory.search_producer();

		System.out.println("");
	}
}


class Mediator
{
	//ArrayLists of facories and producers in mediators collegue
	ArrayList<Factory> factory_list;
	ArrayList<Producer> producer_list;

	public Mediator()
	{
		//Constructor

		factory_list = new ArrayList();
		producer_list = new ArrayList();
	}

	public void set_factory(Factory factory)
	{
		//Adding a new factory to collegue

		this.factory_list.add(factory);
	}

	public void set_producer(Producer producer)
	{
		//Adding new  producer to collegue

		this.producer_list.add(producer);
	}

	public boolean search_producer(int amount , int price , String product)
	{
		//Searching a producer to a factory

		//This iterator will help us to run through the producer_list
		Iterator<Producer> producer_iterator = producer_list.iterator();
	
		//While the producer_iterator has next element
		while (producer_iterator.hasNext())
		{
			//Get next element
			Producer producer = producer_iterator.next();

			if (producer.accept_request(amount , price , product))
			{
				//If producer accepts trade request

				System.out.println("Producer found!");

				return true;
			}
		}

		//If none of producers accept trade request

		System.out.println("No producer found!");

		return false;
	}
}


class Factory
{
	//Mediator of the factory
	Mediator mediator;

	//amount, price and product name of row factory need
	int amount;
	int price;
	String product;

	//Name of the factory
	String factory_name;

	public Factory(Mediator mediator , String factory_name)
	{
		//Setting the madiator of the factory
		this.mediator = mediator;

		//Adding this factory to the collegue of madiator
		this.mediator.set_factory(this);

		//Setting factory name
		this.factory_name = new String(factory_name);
	}

	public void set_product_parametres(int amount , int price , String product)
	{
		//Setting parametres of product to be found

		this.amount = amount;
		this.price = price;
		this.product = product;
	}

	public boolean search_producer()
	{
		//Searching for producer of product needed

		System.out.println(factory_name + "factory is searching for " + amount + " " + product + " cost " + price + ".");

		//Search is redirected to the mediator,
		//avoiding us to write search functions to every type of product
		//and other class to class comunication headache
		return this.mediator.search_producer(amount , price , product);
	}
}


class Producer
{
	//Mediator of producer
	Mediator mediator;

	//price, amount and type of product, produced here
	int price;
	int amount;
	String product;
	
	public Producer(Mediator mediator , int price , int amount)
	{
		//Setting the mediator, price and amount
		this.mediator = mediator;
		this.price = price;
		this.amount = amount;

		//Adding this producer to the collegue of mediator
		this.mediator.set_producer(this);
	}

	public boolean accept_request(int amount , int price , String product)
	{
		//See, if this producer can accept traid request sent by factory through mediator

		if (this.product.equalsIgnoreCase(product) && amount <= this.amount && price >= this.price)
		{
			//If there is the amount of material required and price is not lower then producer tell,
			//Send amount needed to factory and accept request

			this.amount = this.amount - amount;

			System.out.println("Request accepted!");

			return true;
		}

		//Decline, if one of staitements above are not complete

		return false;
	}
}


class PeechProducer extends Producer
{
	//This is class for peech producer

	public PeechProducer(Mediator mediator , int price , int amount)
	{
		//Call constructor of producer
		
		super(mediator , price , amount);

		//Set name of produced material
		this.product = new String("Peech");
	}
}


class GraipProducer extends Producer
{
	//This is class for graip producer

	public GraipProducer(Mediator mediator , int  price , int amount)
	{
		//Call constructor of producer

		super(mediator , price , amount);

		//Set name of produced material
		this.product = new String("Graip");
	}
}