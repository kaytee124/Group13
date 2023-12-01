
class Node {
    Event data;
    Node prev;
    Node next;

    public Node(Event data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}