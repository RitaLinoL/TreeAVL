package br.imd.ufrn.tree;

import br.imd.ufrn.tree.interfaces.Indexable;
import br.imd.ufrn.tree.interfaces.NodeVisitor;

public class Node <T extends Indexable>{
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node() {
        this.value = null;
        this.left = null;
        this.right = null;
    }

    public T getValue(){
        return this.value;
    }


    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

    public void balance(){
        System.out.println(this.isBalanced());
    }


    public void accessPreOrder(NodeVisitor v) {
        v.visit(this);

        if (this.left != null) {

            this.left.accessPreOrder(v);
        }

        if (this.right != null) {
            this.right.accessPreOrder(v);
        }
    }

    public void accessInOrder(NodeVisitor v) {
        if (this.left != null) {
            this.left.accessInOrder(v);
        }

        v.visit(this);

        if (this.right != null) {
            this.right.accessInOrder(v);
        }
    }

    public void accessPostOrder(NodeVisitor v) {
        if (this.left != null) {
            this.left.accessPostOrder(v);
        }

        if (this.right != null) {
            this.right.accessPostOrder(v);
        }

        v.visit(this);
    }



    @Override
    public boolean equals(Object o){
        if ( o == null || this.getClass() != o.getClass()) return false;
        return this.value == ((Node)o).value;
    }

    public boolean isLeaf(){
        if (this.left== null && this.right == null){
            return true;
        }else{
            return false;
        }
    }
    public int nodeDegree() {
        int quant = 0;
        quant = (this.left==null)?1:0;
        quant += (this.right==null)?1:0;
        return quant;
    }


    public Node(T value) {
        this.value = value;
    }




    public int isBalanced() {
        if (this.left == null && this.right == null) {
            return 0;
        }
        int r = 0;
        int l = 0;

        if (this.left != null) {
            l++;
        }
        if (this.right != null) {
            r++;
        }

        //node is balanced
        if (r == l) {
            return this.right.isBalanced() - this.left.isBalanced() ;
        }

        if (l > r) {
            return 1;
        }else {
            return -1;
        }

    }



    @Override
    public String toString() {
        return Integer.toString(this.getValue().getKey());
    }

    public void remove(Node<T> node) {
        if (node.equals(this.left)) {

            if (this.left.isLeaf()) {
                this.left = null;
                return;
            } else if (this.left.nodeDegree() == 1) {
                this.left = (this.left.left == null) ? this.left.right : this.left.left;
            } else {
                this.left = moveNode(this.left);
                return;
            }

        } else if (node.equals(this.right)) {

            if (this.right.isLeaf()) {
                this.right = null;
                return;
            } else if (this.right.nodeDegree() == 1) {
                this.right = (this.right.getLeft() == null) ? this.right.right : this.right.left;
            } else {
                this.right = moveNode(this.right);
                return;
            }

        } else {
            if (this.left != null){
                this.left.remove(node);
            }
            if (this.right != null){
                this.right.remove(node);
            }
        }
    }

    public void insert(Node<T> node) {
        if (node.value.getKey() < this.value.getKey()) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.insert(node);
            }
        } else if (node.value.getKey() > this.value.getKey()) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.insert(node);
            }
        }
    }

    public Node search(int key) {
        if (key == this.value.getKey()) {
            return this;
        }

        if (key < this.value.getKey()) {
            if (this.left != null) {
                return this.left.search(key);
            }
        }

        if (key > this.value.getKey()) {
            if (this.right != null) {
                return this.right.search(key);
            }
        }

        return null;
    }

    private Node searchParentOfLarger(Node<T> node) {
        if (node.right.right== null) {
            return node;
        }else{
            return searchParentOfLarger(node.right);
        }
    }

    private Node moveNode(Node<T> node){
        if (node.left.isLeaf()){
            Node substitute = node.left;
            substitute.right = node.right;
            node = substitute;
            return node;
        }
        Node parentOfSubstitute = searchParentOfLarger(node.left);

        parentOfSubstitute.right.left = node.left;
        parentOfSubstitute.right.right = node.right;
        node = parentOfSubstitute.right;
        parentOfSubstitute.right = null;

        return node;
    }


}
