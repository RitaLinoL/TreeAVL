package br.com.waldson.aula15;

public class Node<Value extends Indexable> {
    Value value;
    Node<Value> left;
    Node<Value> right;

    public Node(Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Node<Value> getLeft() {
        return left;
    }

    public void setLeft(Node<Value> left) {
        this.left = left;
    }

    public Node<Value> getRight() {
        return right;
    }

    public void setRight(Node<Value> right) {
        this.right = right;
    }

    public int getBalanceFactor() {
        int leftHeight  = getLeft() == null ? 0 : 1 + getLeft().getHeight();
        int rightHeight = getRight() == null ? 0 : 1 + getRight().getHeight();

        return leftHeight - rightHeight;
    }

    public int getHeight() {
        if (getLeft() == null && getRight() == null) {
            return 0;
        }
        if (getLeft() == null) {
            return 1 + getRight().getHeight();
        }
        if (getRight() == null) {
            return 1 + getLeft().getHeight();
        }

        return Math.max(1 + getLeft().getHeight(), 1 + getRight().getHeight());
    }
}
