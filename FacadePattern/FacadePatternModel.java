package FacadePattern;


//Facade PatternModel shows example of Facade Pattern
//Facade Pattern is used to concentrate and standartize methods from other classes
//for simple uses by client

public class FacadePatternModel
{
	public static void main(String[] args)
	{
		FacadeClass facade = new FacadeClass();

		System.out.println("Counting sum by Class2 via Facade Class - " + facade.sum(5 , 8));
		System.out.println("Counting complex magnitude by Class1 via Facade Class - " + facade.complex_magnitude(5 , 8));
	}
}


//Two classes

class Class1
{
	public double from_Julia_set_meybe_I_am(double x , double y)
	{
		return x * x + y * y;
	}
}


class Class2
{
	public int remeber_kids(int x , int y)
	{
		return x + y;
	}			
}


//Facade class, their concentration

class FacadeClass
{
	public double complex_magnitude(double x , double y)
	{
		Class1 class1 = new Class1();

		return class1.from_Julia_set_meybe_I_am(x , y);
	}

	public int sum(int x , int y)
	{
		Class2 class2 = new Class2();

		return class2.remeber_kids(x , y);
	}
}