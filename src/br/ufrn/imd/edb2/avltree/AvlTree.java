package br.ufrn.imd.edb2.avltree;

public class AvlTree<Value extends Indexable> {
    private Node<Value> root;

    public void insert(Value value) {
        this.root = insert(new Node<Value>(value), root);
    }

    private Node<Value> insert(Node<Value> node, Node<Value> parent) {
        if (parent == null){
            return node;
        }

        if (node.getValue().getKey() == parent.getValue().getKey()){
            parent.setValue(node.getValue());
            return parent;
        }

        if (node.getValue().getKey() < parent.getValue().getKey()){
            parent.setLeft(insert(node, parent.getLeft()));
        }else{
            parent.setRight(insert(node, parent.getLeft()));
        }

        return balance(parent);
    }

    private Node<Value> balance(Node<Value> node){
        int balanceFactor = node.getBalanceFactor();

        if (balanceFactor >= -1 && balanceFactor <=1){
            return node;
        }

        if (balanceFactor > 1){
            //L
            if(node.getLeft().getBalanceFactor() > 0){
                //LL
                return rotateRight(node);
            }else{
                //RR
                return

            }

        }else{
            //R
            if(node.getRight().getBalanceFactor() > 0){
                //R

            }else{
                //L

            }
        }

        return null;
    }

    private Node<Value> rotateRight(Node <Value> node){
        Node<Value> newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);

        return newRoot;
    }




    public void remove(Node<Value> value) {


    }

    public Value search(int key) {
        return null;
    }
}