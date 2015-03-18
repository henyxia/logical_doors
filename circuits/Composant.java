package circuits;

import java.io.Serializable;

public abstract class Composant implements Comparable<Composant>, Serializable
{	
	public String getId()
	{	
		return super.toString(); // class@numero renvoye par Object	
	}

	public String description()
	{
		return getId();
	}

	public abstract boolean getEtat() throws NonConnecteException;

	public String traceEtat()
	{
			try
			{
				return getId() + (getEtat() ? " On" : " Off");
			}
			catch(NonConnecteException ex)
			{
				return getId() + " Un des composants n'est pas connecté";
			}
	}

	public int compareTo(Composant cp)
	{
		return this.description().compareTo(cp.description());
	}

}
