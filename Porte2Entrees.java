public abstract class Porte2Entrees extends Porte
{	
	protected Composant in1;
	protected Composant in2;
	
	public void setIn1(Composant comp)
	{	
		in1 = comp;
	}

	public void setIn2(Composant comp)
	{	
		in2 = comp;
	}

	public String description()
	{
		return getId() + " in1: " + (in1 == null ? "Non connecté" : in1.getId()) + " in2: " + (in2 == null ? "Non connecté" : in2.getId());
	}
}
