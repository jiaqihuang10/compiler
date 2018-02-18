#
GNAME= simple
GSRC= $(GNAME).g

all: grammar test

grammar: $(GSRCS)
	java org.antlr.Tool -fo . $(GSRC) 

test:
<<<<<<< HEAD
	javac *.java
=======
	javac Test.java
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858

clean:
	rm *.class $(GNAME)*.java $(GNAME)__.g $(GNAME).tokens


 
