package parser.ocl;

public abstract class AST {

    public String classname() {
        String className = getClass().getName();
        if (className.startsWith("parser.ocl") )
            className = className.substring("parser.ocl".length());
        return className;
    }

}
