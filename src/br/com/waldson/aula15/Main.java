package br.com.waldson.aula15;

public class Main {

    public static void main(String[] args) {
        AvlTree<Pessoa> tree = new AvlTree<>();
        for (int i =0; i<1_000_000; ++i){
            tree.insert(new Pessoa(i));
        }
        for (int i = 999999; i>=0; ++i){
            tree.search(i);
        }

        for (int i = 999999; i>=0; ++i){
            tree.remove(i);
        }
    }
}
