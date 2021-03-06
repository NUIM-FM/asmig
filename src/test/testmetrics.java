

package test;
import java.io.*;
import java.util.*;
import atongmu.ast.*;
import atongmu.atg.*;
import atongmu.type.*;
import atongmu.util.*;
import atongmu.value.*;
import atongmu.err.*;
import atongmu.ast.visitor.*;
import atongmu.util.SMT2Writer;
import atongmu.smt.*;
import atongmu.translator.*;
import atongmu.interpreter.*;

public class testmetrics{


	private static String testfile="../../test/LCOM.ecore";

	public static void main (String args[]){
		System.out.println("Testing LCOM metrics...");
		if (args.length>=1){
			testfile=args[0];
			testLCOM3();
			//testNOC();
		}
		else{
			System.out.println("You did not sepcify a model, the default model is applied.");
			//testLCOM3();
			testNOC();
		}
		//testModel2();
	}


	public static void testNOC(){
		System.out.println("**********************NOC Testing**********************");
		FOFormula fof;
		long time = System.currentTimeMillis();
		System.out.println("Translating...");
		e2a GraphTranslator = new e2a(testfile);	// create factory and bound objects within a single call.
		GraphTranslator.translate();
		// print details about everything, for debugging purpose.
		System.out.println(GraphTranslator.getFactory().toString(true));
		a2f ModelTranslator = new a2f(GraphTranslator);
		ModelTranslator.TranslateToFOF();
		/*Acyclic acyclic = new Acyclic(ModelTranslator,
			ModelTranslator.getATGTranslator().getBound().getReferenceByName("extends"));
		acyclic.gen0();*/
		Chain chain = new Chain(ModelTranslator);
		chain.genChain(8,"extends");
		
		//Metrics metrics = new Metrics(ModelTranslator);
		//metrics.ExactNumberNonReflexive("methods",5);

		//metrics.ExactNumber("extends",8,false);
		

		//ModelTranslator.Conjoin(metrics.getFormulas());
		System.out.println("Translation time spend: "+(System.currentTimeMillis()-time)+" ms.");
		System.out.println("Formula successfully generated, ready to solve...?");
		DotInterpreter interpreter;
		int solution=0;
		int s = 1;
		Scanner scan = new Scanner(System.in);
		s = scan.nextInt();
		if (s==0) return;
		try{
			fof = ModelTranslator.getFormula();
			SMT2Writer writer = new SMT2Writer(new PrintWriter (new FileWriter("test.smt2")),
			fof);
			SmtInvoker invoker = new SmtInvoker(Solver.Z3, writer); //use Z3 smt-solver
			while (invoker.incSolve()==Result.SAT){
				if (solution==100) break;
				System.out.println("Solving...");
				System.out.println("interpreting this solution...");
				interpreter = new DotInterpreter("./dot/instance"+solution+".dot",ModelTranslator,"instance"+solution);
				interpreter.interpret();
				solution++;
				System.out.println(solution +" One solution found...Do you want to continue finding ?");
				//s = scan.nextInt();
				fof.addExpression(FOFormula.NegVars());
			}
			//invoker.releaseFiles();
			System.out.println(solution+" solution(s) enumerated." );
		}
		catch (IOException e){ 
			//
		}
		catch (UnknownException e){
			e.printErrMessage(" formula cannot be decided.");
		}
		catch (UnsatException e){
			e.printErrMessage(" formula is not satisfiable.");
		}

		time = System.currentTimeMillis()-time;
		System.out.println("Toal time spend: "+time+" ms.");


	}


	public static void testLCOM3(){
		System.out.println("**********************LCOM3 testing**********************");
		int share0[]=new int[3];
		int share1[]=new int[3];
		int share2[]=new int[2];
		int share3[]=new int[2];
		int share4[]=new int[2];
		int share5[]=new int[2];
		int diff0[]=new int[3];
		int diff1[]=new int[2];		
		int diff2[]=new int[1];

		share0[0]=1;share0[1]=2;share0[2]=3;
		//share1[0]=3;share1[1]=4;share1[2]=5;
		//share2[0]=2;share2[1]=3;
		//share3[0]=2;share3[1]=4;
		//share4[0]=3;share4[1]=4;

		diff0[0]=4;diff0[1]=5;diff0[2]=2;
		//diff1[0]=2;diff1[1]=4;
		FOFormula fof;
		long time = System.currentTimeMillis();
		System.out.println("Translating...");
		e2a translator = new e2a(testfile);	// create factory and bound within a single call.
		translator.translate();
		System.out.println(translator.getFactory().toString(true)); // print details about everything, for debugging purpose.
		//System.out.println(translator.getFactory().toString(false));
		a2f foftranslator = new a2f(translator);
		foftranslator.TranslateToFOF();
		
		Metrics metrics = new Metrics(foftranslator);
		metrics.DisjointShare("access",share0);
		//metrics.Share("access",share1);
		//metrics.Share("access",share2);
		//metrics.Share("access",share3);
		//metrics.Share("access",share4);
		metrics.NoWeakShare("access",diff0);
		//metrics.NoWeakShare("access",diff1);
		//metrics.NoWeakShare("access",diff2);
		foftranslator.Conjoin(metrics.getFormulas());
		
		System.out.println("Translation time spend: "+(System.currentTimeMillis()-time)+" ms.");
		System.out.println("Formula successfully generated, ready to solve...?");
		DotInterpreter interpreter;
		int solution=0;
		int s = 1;
		Scanner scan = new Scanner(System.in);
		s = scan.nextInt();
		if (s==0) return;
		try{
			fof = foftranslator.getFormula();
			SMT2Writer writer = new SMT2Writer(new PrintWriter (new FileWriter("test.smt2")),
			fof);
			SmtInvoker invoker = new SmtInvoker(Solver.Z3, writer); //use Z3 smt-solver
			while (invoker.incSolve()==Result.SAT){
				if (solution==100) break;
				System.out.println("Solving...");
				System.out.println("interpreting this solution...");
				interpreter = new DotInterpreter("./dot/instance"+solution+".dot",foftranslator,"instance"+solution);
				interpreter.interpret();
				solution++;
				System.out.println(solution +" One solution found...Do you want to continue finding ?");
				//s = scan.nextInt();
				fof.addExpression(FOFormula.NegVars());
			}
			//invoker.releaseFiles();
			System.out.println(solution+" solution(s) enumerated." );
		}
		catch (IOException e){ 
			//
		}
		catch (UnknownException e){
			e.printErrMessage(" formula cannot be decided.");
		}
		catch (UnsatException e){
			e.printErrMessage(" formula is not satisfiable.");
		}

		time = System.currentTimeMillis()-time;
		System.out.println("Toal time spend: "+time+" ms.");
	}




}
