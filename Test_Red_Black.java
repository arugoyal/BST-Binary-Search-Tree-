package BST;
import java.util.*;

public class Test
{
    public static void main(String[] args)
    {
        Red_Black <Integer,String> bst = new Red_Black<>();
        bst.add(1, "one");
        bst.add(2, "two");
        bst.add(5, "five");
        bst.add(6, "six");
        bst.add(7, "seven");

        //System.out.println(bst.get(1));
        //System.out.println(bst.get(8));

        System.out.println(bst.height());
    }
}

