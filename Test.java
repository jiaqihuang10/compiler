import org.antlr.runtime.*;
import java.io.*;
import ast.*;
import type.*;

public class Test {
	public static void main (String[] args) throws Exception {
		ANTLRInputStream input;

		if (args.length == 0 ) {
			System.out.println("Usage: Test filename.ul");
			return;
		}
		else {
			input = new ANTLRInputStream(new FileInputStream(args[0]));
		}

		// The name of the grammar here is "ulNoActions",
		// so ANTLR generates ulNoActionsLexer and ulNoActionsParser
		simpleLexer lexer = new simpleLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		simpleParser parser = new simpleParser(tokens);

		try {
			Program p = parser.program();
            Visitor v = new PrintVisitor();
            p.accept(v);
		}
		catch (RecognitionException e )	{
			// A lexical or parsing error occured.
			// ANTLR will have already printed information on the
			// console due to code added to the grammar.  So there is
			// nothing to do here.
		}
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
