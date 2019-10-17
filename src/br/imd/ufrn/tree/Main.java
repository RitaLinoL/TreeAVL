package br.imd.ufrn.tree;

public class Main {

    public static void main(String[] args) {
        AvlTree<Pessoa> tree = new AvlTree<>();

        tree.insert(new Pessoa(3));
        tree.insert(new Pessoa(6));
        tree.insert(new Pessoa(5));
        tree.insert(new Pessoa(7));
        tree.insert(new Pessoa(8));
        tree.show();
        tree.balance();
//        System.out.println(tree.getRoot().getLeft().getLeft().toString());

    }
}
