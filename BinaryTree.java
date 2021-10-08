//Kyle McElligott
import java.util.*;
import java.io.*;

public class BinaryTree {
	private class Node {
		private Node left;
		private int data;
		private Node right;

		private Node(Node L, int d, Node r) {
			left = L;
			data = d;
			right = r;
		}
	}
	private Node root;


    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int d) {
        root = new Node(null, d, null);
    }

    public BinaryTree(BinaryTree b1, int d, BinaryTree b2) {
        root = new Node(b1.root, d, b2.root);
    }

    public BinaryTree(String t) {
        Scanner s = new Scanner(t);
        try {
            root = (buildTree(s)).root;
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
    }

    private BinaryTree buildTree(Scanner s) throws Exception {
        int d = 0;;
        BinaryTree b1;
        BinaryTree b2;
        String t  = s.next();
        if (t.equals("!")) return new BinaryTree();
        d = s.nextInt();
        b1 = buildTree(s);
        b2 = buildTree(s);
        s.next(); //close )
        return new BinaryTree(b1,d,b2);
    }

    public String levelOrder() {
			if(root == null)
				return "";

			Queue<Node> q = new LinkedList<>();

			q.add(root);
			q.add(null);

			String result = "";
			result = result + Integer.toString(root.data);

			while(!q.isEmpty())
			{
				Node curr = q.poll();

				if(curr == null)
				{
					if(!q.isEmpty())
					{
						q.add(null);
					}
				}
				else
				{
					if(curr.left != null)
					{
						q.add(curr.left);
						result = result + " " + Integer.toString(curr.left.data);
					}

					if(curr.right != null)
					{
						q.add(curr.right);
						result = result + " " + Integer.toString(curr.right.data);
					}
				}
			}
			return result;
    }

    public String preOrder() {
			return preOrder(root);
    }

		private String preOrder(Node tree)
		{
			if(tree == null)
			{
				return "";
			}

			return Integer.toString(tree.data) + " " + preOrder(tree.left) +
			preOrder(tree.right);
		}

    public static void main(String args[]) throws Exception {
        BinaryTree b;
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        String s;
        int i = 0;
        while ((s = in.readLine()) != null) {
            b = new BinaryTree(s);
            System.out.println("Tree "+i+++" :"+s);
            System.out.println("\t"+b.levelOrder());
            System.out.println("\t"+b.preOrder());
            System.out.println();
            }
    }
}
