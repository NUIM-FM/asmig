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
package atongmu.err;
import java.io.*;
public final class DuplicatedDeclaration extends AbstractException{

	public DuplicatedDeclaration(PrintWriter e){
		this.err=e;
		this.message="Duplicated declaration for variable:";
		this.err_code=0x11;
	}

	public DuplicatedDeclaration(PrintWriter e, int c){
		this.err = e;
		this.err_code=c;
	}

	public void printErrMessage(String varname){
		this.err.println("DuplicatedDeclaration:"+this.message+"["+varname+"]");
	}
}
