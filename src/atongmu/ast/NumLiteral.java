/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * +++++++++++++++++++++++++++++++++++Written by: Hao Wu++++++++++++++++++++++++++++++++
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 *
 *	This is a part of my PhD work.
 *  haowu@cs.nuim.ie
 *  APR-2012 
 *  
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * ++++++++++++++++++++++++++++++Do or do not, there is no try.+++++++++++++++++++++++++
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */
package atongmu.ast;

import atongmu.value.Value;
import atongmu.value.IntValue;
import atongmu.ast.visitor.AbstractVisitor;

//numeric constant
public class NumLiteral extends Constant{
	private IntValue value;
	
	public NumLiteral(){
		//default constructor
		value=new IntValue();
	}

	public NumLiteral(IntValue v){
		value=v;
	}
		
	//Take an integer as a numeric constant
	public NumLiteral (int v){
		value=new IntValue(v);
	}

	public Value getValue(){
		return value;
	}

	public int getLiteral(){
		return value.getValue();
	}

	public void accept(AbstractVisitor visitor){
		visitor.visit(this);
	}

	public String toString(){
		return String.format("%d",value.getValue());	
	}
}
