package Algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {
    @Test
    public void smokeTest () {
        TreeNode root = new TreeNode(5);
        root.addValueBST(3);
        root.addValueBST(1);
        root.addValueBST(4);
        root.addValueBST(8);
        root.addValueBST(7);
        root.addValueBST(6);

        System.out.println(root);
    }
}