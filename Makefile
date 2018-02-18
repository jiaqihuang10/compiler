#
GNAME= simple
GSRC= $(GNAME).g

all: grammar test

grammar: $(GSRCS)
	java org.antlr.Tool -fo . $(GSRC) 

test:
	javac *.java

clean:
	rm *.class $(GNAME)*.java $(GNAME)__.g $(GNAME).tokens


 
