public class And extends Porte2Entrees
{
	public boolean getEtat() throws NonConnecteException
	{
		if(in1 == null)
			throw new NonConnecteException();
		else if(in2 == null)
			throw new NonConnecteException();
		else
			return in1.getEtat() & in2.getEtat();
	}
}
