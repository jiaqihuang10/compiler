package environment;

import java.util.*;

public class ListEnvironment<K,V> implements Environment<K,V> {
    public ListNode<K,V> head; //symbol table for local variables
    public int	 scopeLevel;

    public ListEnvironment(){
        head = null;
        scopeLevel = 0;
    }

    public void beginScope() {
        scopeLevel++;
        MarkerNode<K,V> marker = new MarkerNode("marker", scopeLevel,head);
        head = marker;
    }

    public void endScope() {
        ListNode<K,V> cur = head;
        while (cur != null && !(cur instanceof MarkerNode)) {
            head = cur.next;
            cur.next = null;
            cur = head;
        }
        head = cur.next;
        cur.next = null;
        scopeLevel--;
    }

    public boolean inCurrentScope(K key) {
        return searchScope(key);
    }

    public void add(K key, V value) {
        addToList(key,value);
    }

    public V lookup(K key) {
        return searchList(key);
    }


    public V searchList(K key) {
        ListNode<K,V> cur = head;
        while (cur != null) {
            if (cur instanceof MarkerNode) {
                return null;
            }
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    private boolean searchScope(K key) {
        ListNode<K,V> cur = head;
        while (cur != null) {
            if (cur instanceof MarkerNode) {
                return false;
            }
            if (cur.key.equals(key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void printList() {
        ListNode<K,V> cur = head;
        while (cur != null) {
            System.out.println("varName " + cur.key);
            cur = cur.next;
        }
    }

    private void addToList(K key, V value) {
        ListNode<K,V> node = new ListNode<K,V>(key,value,scopeLevel,head);
        head = node;
    }

}
