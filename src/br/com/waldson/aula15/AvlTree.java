package br.com.waldson.aula15;

public class AvlTree<Value extends Indexable> {
    private Node<Value> root;



    public void remove(int key){
        root = remove(key, root);
    }

    private Node<Value> remove(int key, Node<Value> root) {
        if (root == null){
            return root;
        }

        if (key == root.getValue().getKey()){
            if (root.getLeft() == null){
                return root.getRight();
            }

            if (root.getRight() == null){
                return root.getLeft();
            }

            int balanceFactor = root.getBalanceFactor();
            if (balanceFactor >= 0){
                //pendendo para o lado esquerdo
                Value max = getMaxValue(root.getLeft());
                root.setValue(max);
                root.setLeft(remove(max.getKey(), root.getLeft()));
            }else{
                //pendendo para o lado direito
                Value min = getMinValue(root.getRight());
                root.setValue(min);
                root.setLeft(remove(min.getKey(), root.getRight()));
            }
            return root;
        }

        if (key < root.getValue().getKey()){
            root.setLeft(remove(key, root.getLeft()));
        }else{
            root.setRight(remove(key, root.getRight()));
        }
        return root;
    }

    public void insert(Value value) {
        root = insert(new Node<Value>(value), root);
    }

    public Value getMinValue(){
        return getMinValue(root);
    }

    private Value getMinValue(Node<Value> root) {
        if (root == null){
            return null;
        }

        if (root.getLeft() == null){
            return root.getValue();
        }

        return getMinValue(root.getLeft());
    }

    public Value getMaxValue(){
        return getMaxValue(root);
    }

    private Value getMaxValue(Node<Value> root) {
        if (root == null){
            return null;
        }

        if (root.getRight() == null){
            return root.getValue();
        }

        return getMaxValue(root.getRight());
    }

    private Node<Value> insert(Node<Value> node, Node<Value> parent) {
        if (parent == null) {
            return node;
        }

        if (node.getValue().getKey() == parent.getValue().getKey()) {
            parent.setValue(node.getValue());
            return parent;
        }

        if (node.getValue().getKey() < parent.getValue().getKey()) {
            parent.setLeft(insert(node, parent.getLeft()));
        } else {
            parent.setRight(insert(node, parent.getRight()));
        }

        return balance(parent);
    }

    public boolean isBalanced() {
        if (root == null) {
            return true;
        }

        return Math.abs(root.getBalanceFactor()) <= 1;
    }

    private Node<Value> balance(Node<Value> node) {
        int balanceFactor = node.getBalanceFactor();
        if (balanceFactor >= -1 && balanceFactor <= 1) {
            return node;
        }

        if (balanceFactor > 1) {
            //L
            if (node.getLeft().getBalanceFactor() > 0) {
                //LL
                return rotateRight(node);
            } else {
                //LR
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            }
        } else {
            //R
            if (node.getRight().getBalanceFactor() < 0) {
                //RR
                return rotateLeft(node);
            } else {
                //RL
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            }
        }
    }

    private Node<Value> rotateLeft(Node<Value> oldRoot) {
        Node<Value> newRoot = oldRoot.getRight();
        oldRoot.setRight(newRoot.getLeft());
        newRoot.setLeft(oldRoot);

        return newRoot;
    }

    private Node<Value> rotateRight(Node<Value> oldRoot) {
        Node<Value> newRoot = oldRoot.getLeft();
        oldRoot.setLeft(newRoot.getRight());
        newRoot.setRight(oldRoot);

        return newRoot;
    }


    public Value search(int key) {
       return search(key, root);
    }

    private Value search(int key, Node<Value> root) {
        if (root==null){
            return null;
        }

        if (root.getValue().getKey() == key){
            return root.getValue();
        }else if(key < root.getValue().getKey()){
            return search(key, root.getLeft());
        }
        return search(key, root.getRight());
    }



}
