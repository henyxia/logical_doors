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
		Composant cmp;
		for(int i=0; i<composants.size(); i++)
		{
			cmp = composants.get(i);
			System.out.print(cmp.getId());
			if(cmp instanceof Porte2Entrees)
			{
				System.out.print("\n\tHas two input");
				if(((Porte2Entrees) cmp).getIn1() instanceof Interrupteur)
				{
					LazyProbe tmp = probt.getProbe((Interrupteur)((Porte2Entrees) cmp).getIn1(), cmp, "in1");
					((Porte2Entrees) cmp).setIn1(tmp);
					System.out.print("\n\t\tSwitch 1 switched to a LazyProbe (ID "+tmp.getId()+")");
				}
				else
					System.out.print("\n\t\tNot a switch on pin 1");
				if(((Porte2Entrees) cmp).getIn2() instanceof Interrupteur)
				{
					System.out.print("\n\t\tSwitch 2 switched to a LazyProbe");
					LazyProbe tmp = probt.getProbe((Interrupteur)((Porte2Entrees) cmp).getIn2(), cmp, "in2");
					((Porte2Entrees) cmp).setIn2(tmp);
				}
				else
					System.out.print("\n\t\tNot a switch on pin 2");


			}
			else if(cmp instanceof Porte)
			{
				System.out.print("\n\tHas one input");
				if(((Not) cmp).getIn() instanceof Interrupteur)
				{
					System.out.print("\n\t\tSwitch switched to a LazyProbe");
					LazyProbe tmp = probt.getProbe((Interrupteur)((Not) cmp).getIn(), cmp, "in");
					((Not) cmp).setIn(tmp);
				}
				else
					System.out.print("\n\t\tNot a switch");
			}
			System.out.print("\n");
		}
	}

	public void resetProbe()
	{
		probt.resetProbe();
	}

	public void destroyProbe()
	{
		Composant cmp;
		for(int i=0; i<composants.size(); i++)
		{
			cmp = composants.get(i);
			System.out.print(cmp.getId());
			if(cmp instanceof Porte2Entrees)
			{
				System.out.print("\n\tHas two input");
				if(((Porte2Entrees) cmp).getIn1() instanceof LazyProbe)
				{
					System.out.print("\n\t\tLazyProbe 1 reverted to a Switch");
					Interrupteur tmp = probt.getInterrupteur((LazyProbe)((Porte2Entrees) cmp).getIn1());
					((Porte2Entrees) cmp).setIn1(tmp);
				}
				else
					System.out.print("\n\t\tNot a lazy probe on pin 1");
				if(((Porte2Entrees) cmp).getIn2() instanceof LazyProbe)
				{
					System.out.print("\n\t\tLazyProbe 2 switched to a Switch");
					Interrupteur tmp = probt.getInterrupteur((LazyProbe)((Porte2Entrees) cmp).getIn2());
					((Porte2Entrees) cmp).setIn2(tmp);
				}
				else
					System.out.print("\n\t\tNot a lazy probe on pin 2");


			}
			else if(cmp instanceof Porte)
			{
				System.out.print("\n\tHas one input");
				if(((Not) cmp).getIn() instanceof LazyProbe)
				{
					System.out.print("\n\t\tLazyProbe switched to a Switch");
					Interrupteur tmp = probt.getInterrupteur((LazyProbe)((Not) cmp).getIn());
					((Not) cmp).setIn(tmp);
				}
				else
					System.out.print("\n\t\tNot a lazy probe");
			}
			System.out.print("\n");
		}

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
