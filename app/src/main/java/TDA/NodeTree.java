package TDA;

import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class NodeTree<E> {
    private E content;
    private LinkedList<Tree<E>> children;
    private Comparator<E> cmp;

    public NodeTree(E content, Comparator<E> cmp){
        this.content = content;
        this.cmp = cmp;
        children = new LinkedList<>();
    }

    public E getContent(){
        return content;
    }

    public void setContent(E content){
        this.content = content;
    }

    public LinkedList<Tree<E>> getChildren(){
        return children;
    }

    public void addChild(E content){
        children.add(new Tree<>(content, cmp));
    }

}
