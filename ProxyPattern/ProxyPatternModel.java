package ProxyPattern;

import java.util.Date;


//Idea of Proxy Pattern is to avoid instansiation of class untill we need it.
//Here constructor of Proxy Class do not initialize Slow object on creation,
//it is initialized only when respond method of Proxy is called
//Us I understood, this used when many slow-created objects are in class,
//to dispense their creation time between whole program working time,
//not to concentrate it in the constructor and get computer stuck on it.

public class ProxyPatternModel
{
    public static void main(String[] args)
    {
    	Proxy proxy = new Proxy();

    	proxy.respond();
    }
}


class Slow
{
	public Slow()
	{
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException exception)
		{
			exception.printStackTrace();
		}
	}

	public void respond()
	{
		System.out.println("Created - " + new Date() + " .I'm slow as a turtle :P");
	}
}


class Proxy
{
	Slow slow;

	public Proxy()
	{
		System.out.println("Proxy created. " + new Date());
	}

	public void respond()
	{
		if (slow == null)
		{
			slow = new Slow();
		}

		slow.respond();
	}
}