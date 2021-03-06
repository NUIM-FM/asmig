package parser.ocl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.antlr.runtime.Token;
import parser.ocl.visitor.PrintVisitor;
import parser.ocl.visitor.ReturnVisitor;
import atongmu.ast.Expression;

public class ASTOCLExpression extends ASTExpression{
	private List constraints;
	private List preposts;
	
	public ASTOCLExpression(){
		constraints = new ArrayList();		
		preposts = new ArrayList();
	}	
	
	public void addConstraint(ASTConstraintDefinition cons){
		constraints.add(cons);	
	}

	public void addPrePost(ASTPrePost p){
		preposts.add(p);
	}

	public List<ASTConstraintDefinition> getConstraints(){
		return constraints;
	}

	public void accept(PrintVisitor v){
		v.visit(this);
	}

	public <E,LN,LE,V> V accept(ReturnVisitor<E,LN,LE,V> v){
		return v.visit(this);
	}
}
