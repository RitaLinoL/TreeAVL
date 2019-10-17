package br.imd.ufrn.tree;

import br.imd.ufrn.tree.interfaces.Indexable;

public class AvlTree <T extends Indexable> {

    private Node<T> root;

    public void insert(T value){
        insert(new Node<T>(value));
    }

    public void insert(Node<T> node){
        if (root == null) {
            root = node;
            return;
        }
        root.insert(node);
    }


    public void balance(){
        root.balance();
    }


    public void remove(){

    }

    public T search(){
        return null;
    }

    public Node getRoot() {
        return this.root;
    }

    public boolean isEmpty() {
        return root == null;
    }

//    public void insert(Node node) {
//        if (root == null) {
//            root = node;
//            return;
//        }
//        root.insert(node);
//    }



    public Node search(int key) {
        if (root == null) {
            return null;
        }
        return root.search(key);
    }

    public void remove(Node node) {
        if (this.root == null) {
            return;
        }
        if (node.equals(root)) {
            Node aux = new Node();
            aux.insert(root);
            aux.remove(root);
            root = (aux.getLeft() == null) ? aux.getRight() : aux.getLeft();
            return;
        }
        root.remove(node);
    }

    public void remove(int value) {
        remove(search(value));
    }


    public void show() {
        PrintVisitor p = new PrintVisitor();
        root.accessPreOrder(p);
    }
}

