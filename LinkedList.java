import java.util.NoSuchElementException;
/**
 * A class to represent a linked list of nodes.
 */
public class LinkedList<T> {
    /** the first node of the list, or null if the list is empty */
    private LLNode<T> firstNode;

    /**
     * Creates an initially empty linked list
     */
    public LinkedList() {
        firstNode = null;
    }

    /**
     * Returns the first node.
     */
    protected LLNode<T> getFirstNode() {
        return firstNode;
    }
    /**
     * Changes the front node.
     * @param node  the node that will be the first node of the new linked list
     */
    protected void setFirstNode(LLNode<T> node) {
        this.firstNode = node;
    }
    /**
     * Return whether the list is empty
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return (getFirstNode() == null);
    }

    /**
     * Add an element to the front of the linked list
     */
    public void addToFront(T element) {
        setFirstNode(new LLNode<T>(element, getFirstNode()));
    }

    /**
     * Removes and returns the element at the front of the linked list
     * @return the element removed from the front of the linked list
     * @throws NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        if (isEmpty())
            throw new NoSuchElementException();
        else {
            T save = getFirstNode().getElement();
            setFirstNode(getFirstNode().getNext());
            return save;
        }
    }

    /**
     * Returns the length of the linked list
     * @return the number of nodes in the list
     */
    public int length() {
        int lengthSoFar = 0;
        LLNode<T> nodeptr = getFirstNode();
        while (nodeptr != null) {
            lengthSoFar++;
            nodeptr = nodeptr.getNext();
        }
        return lengthSoFar;
    }

    /**
     * Moves the first node back n spaces
     * @param n the number of spaces the first node is moves back
     */
    public void moveBack(int n){
        LLNode<T> nodeptr = getFirstNode();
        LLNode<T> node1, node2;
        if(this.length() >= n + 1 && n > 0){
            /**loops through LinkedList until reach the node after which first node should be placed */
            for(int i = 0; i < n; i++){
                nodeptr = nodeptr.getNext();
            }
            node1 = getFirstNode();
            node2 = nodeptr.getNext();
            setFirstNode(getFirstNode().getNext());
            nodeptr.setNext(node1);
            node1.setNext(node2);
        }
    }

    /**
     * Moves the first node to be the last node
     */
    public void moveFirstToLast(){
        LLNode<T> nodeptr, firstNode, prevNode;

        firstNode = getFirstNode();
        nodeptr = firstNode;
        if(nodeptr != null && nodeptr.getNext() != null){
            /**loops through LinkedList until reach last node */
            while(nodeptr.getNext() != null){
                prevNode = nodeptr;
                nodeptr = nodeptr.getNext();
            }
            nodeptr.setNext(firstNode);
            this.setFirstNode(firstNode.getNext());
            firstNode.setNext(null);
        }
    }

    /**
     * Moves last node to be first node
     */
    public void moveLastToFirst(){
        LLNode<T> nodeptr;
        LLNode<T> prevnode = null;

        nodeptr = getFirstNode();
        if(nodeptr != null){
            /**loops through LinkedList until reach last node */
            while(nodeptr.getNext() != null){
                prevnode = nodeptr;
                nodeptr = nodeptr.getNext();
            }
            if(prevnode != null){
                prevnode.setNext(null);
                nodeptr.setNext(getFirstNode());
                setFirstNode(nodeptr);
            }
        }
    }

    /**
     * Reverses the order of nodes in the list
     */
    public void reverseList(){
        if(this.length() >= 2){
            /**loops through LinkedList and moves each node to back of list */
            for(int i = this.length() - 1; i > 0; i--){
                this.moveBack(i);
            }

        }
    }
    /**
     * Reverses the first k nodes of the list
     */
    public void reverseFirstK(int k){
        if(this.length() >= k){
            /**loops through list and moves first k nodes back */
            for(int i = k - 1; i > 0; i--){
                this.moveBack(i);
            }
        }
    }
}
