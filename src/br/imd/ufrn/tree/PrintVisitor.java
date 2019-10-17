package br.imd.ufrn.tree;


import br.imd.ufrn.tree.interfaces.NodeVisitor;

public class PrintVisitor implements NodeVisitor {

    @Override
    public void visit(Node node) {
        System.out.println(node.toString());
    }
}

