public class Or extends Porte2Entrees
{
	public boolean getEtat() throws NonConnecteException
	{
		if(super.in1 == null)
			throw new NonConnecteException();
		else if(super.in2 == null)
			throw new NonConnecteException();
		else
			return super.in1.getEtat() | super.in2.getEtat();
	}
}
