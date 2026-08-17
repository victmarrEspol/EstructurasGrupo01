package TDA;

import java.util.Comparator;
import java.util.LinkedList;


public class Tree<E> {

    private NodeTree<E> root;
    private Comparator<E> cmp;

    public Tree(Comparator<E> cmp){
        this.cmp = cmp;
        root = null;
    }

    public Tree(E content, Comparator<E> cmp){
        this.cmp = cmp;
        this.root = new NodeTree<>(content, cmp);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public NodeTree<E> getRoot(){
        return root;
    }

    public void setRoot(NodeTree<E> root){
        this.root = root;
    }


    // Método toString() (no sabía cómo hacer para que se vea bonita la salida, así que busqué cómo se hace)
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Arbol vacio";
        }

        StringBuilder sb = new StringBuilder();

        sb.append(root.getContent()).append("\n");

        LinkedList<Tree<E>> hijos = root.getChildren();

        for (int i = 0; i < hijos.size(); i++) {
            construirString(
                    hijos.get(i),
                    "",
                    i == hijos.size() - 1,
                    sb
            );
        }

        return sb.toString();
    }

    private void construirString(
            Tree<E> tree,
            String prefijo,
            boolean esUltimo,
            StringBuilder sb
    ) {
        sb.append(prefijo);
        sb.append(esUltimo ? "`-- " : "|-- ");
        sb.append(tree.getRoot().getContent());
        sb.append("\n");

        LinkedList<Tree<E>> hijos = tree.getRoot().getChildren();

        for (int i = 0; i < hijos.size(); i++) {
            construirString(
                    hijos.get(i),
                    prefijo + (esUltimo ? "    " : "|   "),
                    i == hijos.size() - 1,
                    sb
            );
        }
    }

}
