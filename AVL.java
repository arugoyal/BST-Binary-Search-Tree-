package BST;

public class AVL { 
    Node root; 

    int heightf(Node root)
    {
	if(root==null)
	    return 0;
	int l=heightf(root.left);
	int r=heightf(root.right);
	if(l>r)
	    return l+1;
	else
	    return r+1;
	//return (1+ max(heightf(root.left),heightf(root.right)));
    }
   
    int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 
   
    Node rightRotate(Node root) { 
        Node y = root.left; 
        Node temp = y.right;  
        y.right = root; 
        root.left = temp; 
        root.height = max(heightf(root.left), heightf(root.right)) + 1; 
        y.height = max(heightf(y.left), heightf(y.right)) + 1; 
        return y; 
    } 
   
    Node leftRotate(Node root) { 
        Node y = root.right; 
        Node temp = y.left; 
        y.left = root; 
        root.right = temp; 
        root.height = max(heightf(root.left), heightf(root.right)) + 1; 
        y.height = max(heightf(y.left), heightf(y.right)) + 1; 
        return y; 
    } 

     Node insert(Node node, int key) { 
        if (node == null) 
            return (new Node(key)); 
  
        if (key < node.data) 
            node.left = insert(node.left, key); 
        else if (key > node.data) 
            node.right = insert(node.right, key); 
  
        int balance = heightf(node.left) - heightf(node.right); 
        if (balance > 1)
	{
	    if (heightf(node.left.left) - heightf(node.left.right) >= 0)
                node = rightRotate(node);
	    else
	    {
		node.left = leftRotate(node.left);
		node = rightRotate(node);
	    }
	}
	else if (balance < -1)
	{
	    if(heightf(node.right.left) - heightf(node.right.right) < 0)
                node = leftRotate(node);
	    else
	    {
		node.right = rightRotate(node.right);
		node = leftRotate(node);
	    }
	}
	
	else
	{
	    int l=heightf(node.left);
	    int r=heightf(node.right);
	    if(l>r)
	        node.height=l+1;
	    else
	        node.height=r+1;
	    //root.height=max(heightf(root.left),heightf(root.right))+1;
	}
	
	return node;
    } 
    void inOrder(Node node) { 
        if (node == null)
	    return;
	inOrder(node.left);
        System.out.print(node.data + " "); 
        inOrder(node.right);  
    } 

    private class Node {
        int data, height;
        Node left, right;
        Node(int d) {
            data = d;
            height = 1;
        }
    }
} 
