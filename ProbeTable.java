import java.util.*;

public class ProbeTable
{
	private Map<LazyProbe, Interrupteur> probeToInte = new TreeMap<LazyProbe, Interrupteur>();
	private Map<Interrupteur, LazyProbe> inteToProbe = new TreeMap<Interrupteur, LazyProbe>();

	public ProbeTable()
	{
	}

	public Interrupteur getInterrupteur(LazyProbe probe)
	{
		return probeToInte.get(probe);
	}

	public LazyProbe getProbe(Interrupteur inte, Composant target, String input)
	{
		try
		{
			LazyProbe out = inteToProbe.get(inte);
			return out;
		}
		catch(NullPointerException e)
		{
			LazyProbe tmp = new LazyProbe(target, input);
			probeToInte.put(tmp, inte);
			inteToProbe.put(inte, tmp);
			return tmp;
		}
	}

	public void resetProbe()
	{
		Iterator<LazyProbe> iter = inteToProbe.values().iterator();
		while(iter.hasNext())
			iter.next().reset();
	}

	public void clear()
	{
		probeToInte.clear();
		inteToProbe.clear();
	}
}
