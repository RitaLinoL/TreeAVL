package br.com.waldson.aula15;

public class AvlTree<Value extends Indexable> {
    private Node<Value> root;

    public void insert(Value value) {
        insert(new Node<Value>(value));
    }

    public void insert(Node<Value> value) {

    }

    public void remove() {

    }

    public Value search(int key) {
        return null;
    }
}
