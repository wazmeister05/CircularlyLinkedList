public class LinkedList<E> {    //generic!

    private Node<E> tail = null;
    private int size = 0;

    public LinkedList(){
        //empty, just here so we can initialise the list, but the fields have done that for us
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()) {   //if list is currently empty
            return null;
        }
        return tail.getNext().getElement();     //in this case, the next element from tail is head, so take heads element.
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void rotate(){
        if (tail != null) {  //if the tail is null, the list is empty, so rotating pointless
            tail = tail.getNext();  //whatever is at the end, get the thing at the front. Head becomes tail
        }
    }

    public void addFirst(E e){
        if (isEmpty()){
            tail = new Node<>(e, null);     //null because it's the first thing so there is nothing to point to
            tail.setNext(tail);         //tail set to itself because circular
        }
        else {      //ie. already a list there
            Node<E> newest = new Node<>(e, tail.getNext());     //assign value of tail.getNext to newest.next
            tail.setNext(newest);                               //assign newest to be tail of tail, making newest head
        }
        size++;     //increment size
    }

    public void addLast(E e){
        addFirst(e);                //add new entry to start first, making it the head.
        tail = tail.getNext();      //tail becomes equal to whatever is stored in the next node, ie. head.
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;            //fine
        }
        Node<E> head = tail.getNext();

        if (head == tail){      //if there is only one entry in the list...
            tail = null;        //...set it to null
        }
        else {
            tail.setNext(head.getNext());   //otherwise set the head to be head.next
        }
        size--;
        return head.getElement();
    }

}
