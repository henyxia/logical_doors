package circuits;

public class And extends Porte2Entrees
{
	private static final long serialVersionUID = 7526471155622776147L;

	public boolean eval() throws NonConnecteException
	{
		return in1.getEtat() & in2.getEtat();
	}
}
