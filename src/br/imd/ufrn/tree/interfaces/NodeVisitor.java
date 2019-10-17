package br.imd.ufrn.tree.interfaces;

import br.imd.ufrn.tree.Node;

public interface NodeVisitor<T extends Indexable> {
    void visit(Node<T> node);
}
