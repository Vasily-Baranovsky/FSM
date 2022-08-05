package Algorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeNodeTest {

    @Test
    public void smokeTest () {
        TreeNode root = new TreeNode(5);
        root.addValueBST(3);
        root.addValueBST(1);
        root.addValueBST(4);
        root.addValueBST(8);
        root.addValueBST(7);
        root.addValueBST(6);
        System.out.println(root.subTreeToString());
    }

    @Test
    public void createListOfDepthsWithoutQueueTest() {
        TreeNode root = new TreeNode(5);
        root.addValueBST(3);
        root.addValueBST(1);
        root.addValueBST(4);
        root.addValueBST(8);
        root.addValueBST(7);
        root.addValueBST(6);
        System.out.println(printLevels(root.createListOfDepthsWithoutQueue()));
        System.out.println(root.subTreeToString());
    }

    private String printLevels(ArrayList<LinkedList<TreeNode>> treeLevels) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < treeLevels.size(); i++) {
            LinkedList<TreeNode> level = treeLevels.get(i);
            stringBuilder.append("Level number: ").append(i);
            stringBuilder.append("; Nodes : ");
            for (int j = 0; j< level.size(); j++) {
                stringBuilder.append(level.get(j)).append("; ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
