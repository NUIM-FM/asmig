package parser.ocl;

import atongmu.atg.NodeType;
import atongmu.atg.Edge;
import java.util.TreeSet;

public class ASTContext{
	private NodeType context;
	private TreeSet<Edge> edges=null;
	private String reference=null;
	/* FIXME: we need a default constructor */
	/*public ASTContext(){context=new NodeType();}*/

	public ASTContext(String type){
		context = new NodeType(type,type.hashCode());
	}

	public ASTContext(String type, String ref){
		context = new NodeType(type,type.hashCode());
		reference = new String(ref);
	}

	public void setContext(String type){
		context.setName(type);
		context.setTypeID(type.hashCode());
	}
	public String name(){return context.getName();}
	public boolean hasRef(){return reference!=null;}
	public String getRef(){return reference;}
	public NodeType getContext(){return context;}
	public boolean compareTo(ASTContext c){
		if (c==null) return false;
		if (this.context==null || c.getContext()==null)
			return false;
		
		return this.context.getTypeID()==c.getContext().getTypeID();
	}
	public String toString(){return "context:"+context+", "+reference+"\n";}
	
}
