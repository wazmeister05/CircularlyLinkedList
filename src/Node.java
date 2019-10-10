public class Node<E> {

    private E element;  //E is a generic type, placeholder. Must be defined in class definition
    private Node<E> next;

    public Node(E e, Node<E> n){
        element = e;
        next = n;
    }

    public E getElement(){
        return element;
    }

    public Node<E> getNext(){
        return next;
    }

    public void setNext(Node<E> n){
        next = n;
    }

}
