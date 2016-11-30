import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * Created by David Stovlbaek on 29/09/16.
 */
// An IntTree object represents an entire binary tree of ints.
public class IntTree {
    private IntTreeNode overallRoot;

    //Used for CountLeftNodes()
    private int counter;
    private boolean check;
    private String sTree;
    private IntTreeNode temp;

    public IntTree() {
        overallRoot = null;
    }

    // pre : max >= 0 (throws IllegalArgumentException if not)
    // post: constructs a sequential tree with given number of
    //       nodes
    public IntTree(int max) {
        if (max < 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    // post: returns a sequential tree with n as its root unless
    //       n is greater than max, in which case it returns an
    //       empty tree
    private IntTreeNode buildTree(int n, int max) {
        if(n > max){
            return null;
        }
        else{
            return new IntTreeNode(n, buildTree(2 * n, max),
                                   buildTree(2 * n + 1, max));
        }
    }

    // post: prints the tree contents using a pre-order traversal
    public void printPreOrder(){
        System.out.println("pre-order:");
        printPreOrder(overallRoot);
        System.out.println();
    }

    // post: prints in pre-order the tree with given root
    private void printPreOrder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }

    // post: prints the tree contents using an inorder traversal
    public void printInOrder() {
        System.out.print("inOrder:");
        printInOrder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInOrder(IntTreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(" " + root.data);
            printInOrder(root.right);
        }
    }

    // post: prints the tree contents using a post-order traversal
    public void printPostOrder() {
        System.out.print("postOrder:");
        printPostOrder(overallRoot);
        System.out.println();
    }

    // post: prints in post-order the tree with given root
    private void printPostOrder(IntTreeNode root) {
        if (root != null) {
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preOrder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level){
        if(root != null){
            printSideways(root.right, level + 1);
            for(int i=0;i<level;i++){
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }

    //Counts the left nodes in tree
    public int countLeftNodes(){
        counter = 0;
        countLeftNodes(overallRoot);
        return counter;
    }

    private void countLeftNodes(IntTreeNode node){
        if(node == null) return;

        if(node.right != null && node.right.left != null){
            counter++;
            countLeftNodes(node.right);
        }
        if(node.left != null) {
            counter++;
            countLeftNodes(node.left);
        }
    }

    //Counts how many empty branches in Tree
    public int countEmpty(){
        counter = 0;
        countEmpty(overallRoot);
        return counter;
    }

    private void countEmpty(IntTreeNode node){

        if(node == null){
            counter++;
            return;
        }

        if(node.right == null){
            counter++;
        }
        else {
            countEmpty(node.right);
        }

        if(node.left == null){
            counter++;
        }
        else {
            countEmpty(node.left);
        }
    }

    public void depthSum() {
        System.out.println(depthSum(overallRoot, 1));
    }

    // post: prints in post-order the tree with given root
    private int depthSum(IntTreeNode node, int n) {
        if(node == null) return 0;
        else{
            return n * node.data + depthSum(node.left, n + 1) + depthSum(node.right, n + 1);
        }
    }

    //Counts every branch with even nodes. Which means no leafs
    public int countEvenBranches(){
        counter = 0;
        countEvenBranches(overallRoot);
        return counter;
    }

    private void countEvenBranches(IntTreeNode node){
        if(node == null || node.left == null && node.right == null) return;

        if(node.data % 2 == 0) {
            counter++;
        }
        countEvenBranches(node.left);
        countEvenBranches(node.right);
    }

    public void printLevel(int n){
        if(n < 1) throw new IllegalArgumentException();
        printLevel(overallRoot, n, 1);
    }

    private void printLevel(IntTreeNode node, int n, int k){
        if(node == null) return;

        if(n == k){
            System.out.println(node.data);
        }
        printLevel(node.left, n, k+1);
        printLevel(node.right, n, k+1);
    }

    public void printLeaves() {
        if (overallRoot == null){
            System.out.print("No leaves");
            return;
        }
        System.out.print("Leaves: ");
        printLeaves(overallRoot);
    }

    private void printLeaves(IntTreeNode node){
        if(node == null) return;

        if(node.right == null && node.left == null){
            System.out.print(node.data + " ");
        }
        printLeaves(node.right);
        printLeaves(node.left);
    }

    public boolean isFull(){
        if(overallRoot == null) return false;
        check = true;
        isFull(overallRoot);
        return check;
    }

    private void isFull(IntTreeNode node){

            if(node.right != null)
            isFull(node.right);
            if(node.left != null)
            isFull(node.left);

        if(node.left != null && node.right == null || node.right != null && node.left == null){
            check = false;
        }
    }

/*
    public void add(int value) {
        overallRoot = add(overallRoot, value);
    }

    private IntTreeNode add(IntTreeNode root, int value) {
        if (root == null) {
            root = new IntTreeNode(value);
        } else if (value <= root.data) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        return root;
    }

    public void myAdd(int value){
        if(overallRoot == null){
            overallRoot = new IntTreeNode(value);
            return;
        }

        IntTreeNode current = overallRoot;

        while(true){
            if(current.data < value){
                if(current.right == null){
                    current.right = new IntTreeNode(value);
                    break;
                }
                else current = current.right;
            }
            else{
                if(current.left == null){
                    current.left = new IntTreeNode(value);
                    break;
                }
                else current = current.left;
            }
        }
    }
*/

    //Prints the height of the Tree
    public int heightOfTree(){
        return heightOfTree(overallRoot);
    }

    private int heightOfTree(IntTreeNode node) {
        if (node == null) return 0;
        else return 1 + Math.max(heightOfTree(node.left), heightOfTree(node.right));
    }

    public boolean equals(IntTree t){
        check = true;
        equalsTest(overallRoot, t.overallRoot);
        return check;
    }

    // post: prints in inorder the tree with given root
    private void equalsTest(IntTreeNode node, IntTreeNode node2) {
        if(check) {
            if(node == null && node2 == null) return;
            try {
                equalsTest(node.left, node2.left);
                if (node.data != node2.data) check = false;
                equalsTest(node.right, node2.right);
            }
            catch(Exception e){
                check = false;
            }
        }
    }

    public void doublePositives(){
        doublePositives(overallRoot);
    }

    private void doublePositives(IntTreeNode node) {
        if (node != null) {
            if(node.data > 0)
            node.data = node.data * 2;
            doublePositives(node.left);
            doublePositives(node.right);
        }
    }

    @Override
    public String toString() {
        sTree = "";
        print(overallRoot);
        return sTree;
    }

    private void print(IntTreeNode node) {
        if(node.left != null && node.right != null){
            sTree += ("(" + node.data + ", ");
            print(node.left);
            sTree += (", ");
            print(node.right);
            sTree += (")");
        }
        else {
            sTree += ("(" + node.data + ", ");
            if(node.left != null) sTree += (node.left.data + ", ");
            else sTree += ("empty, ");
            if(node.right != null) sTree += (node.right.data + ")");
            else sTree += ("empty)");
        }

    }



    public void myTreeEx8(){
        overallRoot = new IntTreeNode(2);
        overallRoot.left = new IntTreeNode(8);
        overallRoot.left.left = new IntTreeNode(0);

        overallRoot.right = new IntTreeNode(1);
        overallRoot.right.right = new IntTreeNode(6);
        overallRoot.right.right.right = new IntTreeNode(9);

        overallRoot.right.left = new IntTreeNode(7);
        overallRoot.right.left.left = new IntTreeNode(4);
    }

}