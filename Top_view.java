//TOP VIEW OF A BST

package BST;
import java.util.*;

public class Top_view <K extends Comparable<K>,V> implements Iterable <K>
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

    public void add(K key,V val,int disp)
    {
        root = add(root,key,val,disp);
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

    private Node add(Node n,K key,V val,int disp)
    {
        if(n == null) return new Node(key,val,disp);
        int cmp = key.compareTo(n.key);
        if(cmp == 0) n.val = val;
        else if(cmp > 0) n.right = add(n.right,key,val,disp+1);
        else n.left = add(n.left,key,val,disp-1);
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

    public void top()
    {
	Queue <Node> q = new LinkedList<>();
	int[] pos = new int[100];
	int[] neg = new int[100];
	int i;

	for(i = 0; i < pos.length; i++)
	{
	    pos[i] = -1;
	    neg[i] = -1;
	}

	q.add(root);

	while( !q.isEmpty())
	{
	    Node x = q.poll();
	    if(x.disp >= 0 && pos[x.disp] == -1)
	    {
		
		pos[x.disp] = 0;
		System.out.println(x.key);
	    }
	    else if(x.disp < 0 && neg[-(x.disp)] == -1)
            {

                neg[-(x.disp)] = 0;
                System.out.println(x.key);
            }
	    if(x.left != null)
	    {
		q.add(x.left);
	    }
	    if(x.right != null)
	    {
		q.add(x.right);
	    }
	}
    }

    public void bottom()
    {
        Queue <Node> q = new LinkedList<>();
	Map <Integer , K> m = new HashMap<>();
	/*Map<Integer, K> m = new TreeMap<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }

                });*/
        int i,max = -1,min = 99;
        q.add(root);
        while( !q.isEmpty())
        {
            Node x = q.poll();
	    if(m.containsKey(x.disp))
	    {
		m.replace(x.disp, x.key);
		max = (max < x.disp)? x.disp : max;
		min = (min > x.disp)? x.disp : min; 
	    }
	    else
	    {
		max = (max < x.disp)? x.disp : max;
                min = (min > x.disp)? x.disp : min;
	        m.put(x.disp, x.key);
	    }
            if(x.left != null)
            {
                q.add(x.left);
            }
            if(x.right != null)
            {
                q.add(x.right);
            }
        }
	/*for (Map.Entry<Integer, K> entry : m.entrySet())  
            System.out.println(entry.getValue()); */
	for(i = min; i<= max; i++)
	    System.out.println(m.get(i));

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
        private int disp;
        private Node left = null;
        private Node right = null;
        private int N;

        public Node(K key, V val, int disp)
        {
            this.key = key;
            this.val = val;
            this.N = 1;
            this.disp = disp;
        }
    }

    @Override
    public Iterator<K> iterator()
    {
        return null;
    }
}

