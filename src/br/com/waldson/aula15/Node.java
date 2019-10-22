package br.com.waldson.aula15;

public class Node<Value extends Indexable> {
    Value value;
    Node<Value> left;
    Node<Value> right;

    public Node(Value value) {
        this.value = value;
    }
}
