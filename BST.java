package BST;
import java.util.*;

public class BST <K extends Comparable<K>, V> implements Iterable <K>
{

    private Node root = null;
 
    public int height()
    {
	return height(root);
    }

    private int height(Node n)
    {
	if(n == null) return 0;
	return 1 + Math.max(height(n.left),height(n.right));
    }

    public void add(K key,V val)
    {
	root = add(root,key,val);
    }

    public V get(K key)
    {
	Node n = get(root, key);
	return (n == null)? null : n.val;
    }

    private Node get(Node n, K key)
    {
	if(n == null) return null;
        int cmp = key.compareTo(n.key);
        if(cmp == 0) return n;
        else if(cmp > 0) return get(n.right,key);
        return get(n.left,key);
    }

    private Node add(Node n,K key,V val)
    {
	if(n == null) return new Node(key,val);
	int cmp = key.compareTo(n.key);
	if(cmp == 0) n.val = val;
	else if(cmp > 0) n.right = add(n.right,key,val);
	else n.left = add(n.left,key,val);
	n.N = 1+sizeOf(n.left)+sizeOf(n.right);
	return n;
    }

    private int sizeOf(Node n)
    {
	return (n==null)? 0 : n.N;
    }

    public int getRank(K key)
    {
	return getRank(root,key);
    }

    private int getRank(Node n,K key)
    {
	if(n==null) return -1;
	int cmp=key.compareTo(n.key);
	if(cmp==0) return sizeOf(n.left);
	if(cmp<0) return getRank(n.left,key);
	return 1 + sizeOf(n.left) + getRank(n.right,key);
    }

    private class Node
    {
	private K key;
	private V val;
	private Node left = null;
	private Node right = null;
	private int N;

	public Node(K key, V val)
	{
	    this.key = key;
	    this.val = val;
	    this.N = 1;
	}
    }

    @Override
    public Iterator<K> iterator()
    {
	return null;
    }
}
