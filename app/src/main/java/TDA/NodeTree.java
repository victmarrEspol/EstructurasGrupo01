package TDA;

import java.util.Comparator;
import java.util.LinkedList;

import Game.Table;

public class NodeTree<E> {
    private E content;
    private LinkedList<Tree<E>> children;

    public NodeTree(E content){
        this.content = content;
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

    public void addChild(Table content){
        children.add(new Tree<>(content));
    }

}

