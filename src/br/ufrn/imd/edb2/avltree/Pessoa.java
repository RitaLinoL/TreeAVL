package br.ufrn.imd.edb2.avltree;

public class Pessoa implements Indexable {
    private int chave;

    public Pessoa(int chave){
        this.chave = chave;
    }

    @Override
    public int getKey() {
        return 0;
    }
}
