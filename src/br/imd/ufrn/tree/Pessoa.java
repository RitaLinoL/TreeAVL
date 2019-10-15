package br.imd.ufrn.tree;

import br.imd.ufrn.tree.interfaces.Indexable;

public class Pessoa implements Indexable {
    int key;

    public Pessoa(int key){
        this.key = key;
    }

    @Override
    public int getKey() {
        return key;
    }
}
