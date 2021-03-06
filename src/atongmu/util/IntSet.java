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
package atongmu.util;

import java.util.*;

public class IntSet{
	TreeSet<Integer> tree = new TreeSet<Integer>();
		
	public IntSet(){
		//Default Constructor
	}
	
	public IntSet(List<Integer> list){
		
	}

	public void add(int i){
		tree.add(i);
	}

	public void remove(int j){
		tree.remove(j);
	}
	
	public void removeAll(){
		tree.clear();
	}

	public Iterator<Integer> iterator(){
		return tree.iterator();
	}

	public boolean contains(int k){
		return tree.contains(k);
	}

	public static void main (String agrs[]){
		IntSet s = new IntSet();
		s.add(2);
		s.add(4);
		s.add(3);
		s.add(5);

		Iterator<Integer> it = s.iterator();
		while (it.hasNext()){
			System.out.println("Next:"+it.next());
		}
		
	}

	
}
