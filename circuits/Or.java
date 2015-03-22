package circuits;

public class Or extends Porte2Entrees
{
	private static final long serialVersionUID = 7526471155622778847L;

	public boolean eval() throws NonConnecteException
	{
		return in1.getEtat() | in2.getEtat();
	}
}
