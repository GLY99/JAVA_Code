import java.util.Scanner;

class TreeNode{
    public char val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(char val) {
        this.val = val;
    }
}
public class Main {
    public static  int i = 0;
    public static TreeNode createTreeByString(String string){
        TreeNode root = null;
        if (string.charAt(i) != '#'){
            root = new TreeNode(string.charAt(i));
            i++;
            root.left = createTreeByString(string);
            root.right = createTreeByString(string);
        }else{
            i++;
        }
        return root;
    }
    public static void inorder(TreeNode root){
        if (root == null)return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        TreeNode root = createTreeByString(str);
        inorder(root);
    }
}
