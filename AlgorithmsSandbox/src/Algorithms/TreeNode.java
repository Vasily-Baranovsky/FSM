package Algorithms;
import java.util.Queue;
import java.util.LinkedList;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode (int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode (int value) {
        this(value, null, null);
    }

    public void addValueBST(int valueToAdd) {
        if (valueToAdd <= value) {
            if (left == null) {
                left = new TreeNode (valueToAdd);
            } else {
                left.addValueBST(valueToAdd);
            }
        } else {
            if (right == null) {
                right = new TreeNode (valueToAdd);
            } else {
                right.addValueBST(valueToAdd);
            }
        }
    }

    private static final int TEXT_WIDTH = 80;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Queue<DepthContainer> queue = new LinkedList<>(); //add, poll

        queue.add (new DepthContainer(this, 0));
        int currentLevel = 0;
        boolean existsNonEmptyElementOnARow = true;
        while (! queue.isEmpty()) {
            DepthContainer currentElement = queue.poll();
            if (currentElement.level > currentLevel) {
                if (! existsNonEmptyElementOnARow) {
                    break;
                }
                existsNonEmptyElementOnARow = false;
                result.append("\n");
                currentLevel = currentElement.level;

            }
            int width = (int)(TEXT_WIDTH / Math.pow(2, currentLevel));
            if (currentElement.node == null) {
                result.append(printOneValue("_", width));

                queue.add(new DepthContainer(null, currentElement.level + 1));   //применить подход с флагом, проверять, когда элементы на уровне пустышки
                queue.add(new DepthContainer(null, currentElement.level + 1));

            } else {
                String valueString = Integer.toString(currentElement.node.value);
                result.append(printOneValue(valueString, width));
                existsNonEmptyElementOnARow = existsNonEmptyElementOnARow ||
                        currentElement.node.left != null || currentElement.node.right != null;

                queue.add(new DepthContainer(currentElement.node.left, currentElement.level + 1));   //применить подход с флагом, проверять, когда элементы на уровне пустышки
                queue.add(new DepthContainer(currentElement.node.right, currentElement.level + 1));
            }
        }
        return result.toString();
    }

    private String printOneValue(String value, int width) {

        int emptySpaces = width - value.length();
        return " ".repeat(emptySpaces/2) + value + " ".repeat(emptySpaces - emptySpaces/2);
    }

    private static class DepthContainer {
        public TreeNode node;
        public int level;

        public DepthContainer (TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}