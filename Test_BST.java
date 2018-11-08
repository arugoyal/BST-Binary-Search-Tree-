package BST;
import java.util.*;

public class Test_BST
{
    public static void main(String[] args)
    {
	BST <Integer,String> bst = new BST<>();
	bst.add(5, "five",0);
	bst.add(6, "six",0);
	bst.add(1, "one",0);
	bst.add(2, "two",0);
	bst.add(7, "seven",0);

	System.out.println(bst.getRank(1));
	System.out.println(bst.getRank(5));

	System.out.println(bst.getRank(7));
    }
}
