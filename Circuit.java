import java.util.*;

public class Circuit
{
	private		String nom;
	private		List<Composant> composants = new ArrayList<Composant>();
	protected	ProbeTable probt = new ProbeTable();

	public Circuit(String nom, Composant[] cps)
	{
		this.nom = nom;
		composants.addAll(Arrays.asList(cps));
		Collections.sort(composants);
	}

	public void initProbe()
	{
		/*
		Iterator<Composant> iter = new composants.values().iterator();
		while(iter.hasNext())
		{
			iter.next();
			//TODO
		}
		*/
	}

	public void resetProbe()
	{
	}

	public void destroyProbe()
	{
	}

	public List<String> nomenclature()
	{
		List<String> noms = new ArrayList<String>();
		for(int i=0; i<composants.size(); i++)
			noms.add(composants.get(i).getId());

		return noms;
	}

	public void TraceEtats()
	{
		System.out.println("Circuit name : "+nom);
		for(int i=0; i<composants.size(); i++)
		{
			System.out.println(composants.get(i).traceEtat());
		}
	}

	public List<Interrupteur> getIns()
	{
		List<Interrupteur> inte = new ArrayList<Interrupteur>();
		for(int i=0; i<composants.size(); i++)
			if(composants.get(i) instanceof Interrupteur)
				inte.add((Interrupteur) composants.get(i));
		return inte;
	}

	public void description()
	{
		System.out.println("Circuit name : "+nom);
		for(int i=0; i<composants.size(); i++)
		{
			System.out.println(composants.get(i).description());
		}
	}

	public List<Vanne> getOutS()
	{
		List<Vanne> outs = new ArrayList<Vanne>();
		for(int i=0; i<composants.size(); i++)
			if(composants.get(i) instanceof Vanne)
				outs.add((Vanne) composants.get(i));
		return outs;
	}
}
