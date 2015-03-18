CC= javac
CCFLAGS=-g -Werror #-Xlint

P_CIRCUIT_SRC=circuits/And.java circuits/Composant.java circuits/LazyProbe.java
P_CIRCUIT_SRC+=circuits/Not.java circuits/Porte2Entrees.java circuits/ProbeTable.java
P_CIRCUIT_SRC+=circuits/Vanne.java circuits/Circuit.java circuits/Interrupteur.java
P_CIRCUIT_SRC+=circuits/NonConnecteException.java circuits/Or.java circuits/Porte.java
P_CIRCUIT_SRC+=circuits/Sonde.java
P_CIRCUIT_CLASS=$(P_CIRCUIT_SRC:.java=.class)
P_TEST_SRC=test/TestCircuits.java
P_TEST_CLASS=$(P_TEST_SRC:.java=.class)

.SUFFIXES: .java .class

.java.class:
	$(CC) $(CCFLAGS) $<

all: circuit test

circuit: $(P_CIRCUIT_CLASS)

test: $(P_TEST_CLASS)

clean:
	rm -f $(P_CIRCUIT_CLASS) $(P_TEST_CLASS)
