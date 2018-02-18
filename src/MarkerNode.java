package environment;

public class MarkerNode<K,V> extends ListNode<K,V> {
	public MarkerNode (K key, int s, ListNode<K,V> n) {
        super(key,null,s,n);    //call superclass constructors
	}
}
