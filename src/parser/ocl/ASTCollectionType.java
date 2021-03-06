package parser.ocl;
import org.antlr.runtime.Token;


public class ASTCollectionType extends ASTType {
    private Token fName;
    private ASTType fElement;

    /**
     * Constructs a nested type. The type constructor is given as
     * <code>name</code>. 
     */
    public ASTCollectionType(Token name, ASTType elem) {
        fName = name;
        fElement = elem;
    }

    public String toString() {
	/*This is hacked by Hao Wu*/
        return "ASTCollectionType: (" + fName.toString() + " " + fElement.toString() + ")";
    }

}
