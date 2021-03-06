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

public enum Arithmetic {
	
	PLUS {public String toString(){return "+";}},
	MINUS {public String toString(){return "-";}},
	MUL {public String toString(){return "*";}},
	DIV {public String toString(){return "/";}},
	GREATER {public String toString(){return ">";}},
	LESS {public String toString(){return "<";}},
	GREATER_EQUAL {public String toString(){return ">=";}},
	EQUAL {public String toString(){return "=";}},
	LESS_EQUAL {public String toString(){return "<=";}};	
}
