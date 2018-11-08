package BST;
import java.util.*;

public class Test_Top_view
{
    public static void main(String[] args)
    {
        Top_view <Integer,Integer> bst = new Top_view<>();
        bst.add(5, 5,0);
        bst.add(3, 3,0);
        bst.add(6, 6,0);
        bst.add(2, 2,0);
        bst.add(4, 4,0);

        //bst.top();
	bst.bottom();
    }
}

