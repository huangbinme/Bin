package base.queue;

public class LinkListQueue<T> {

    private int size;
    private Node<T> header;
    private Node<T> tail;

    public void enqueue(T obj) {
        Node newNode = new Node(obj);
        if (isEmpty()) {
            header = newNode;
            tail = newNode;
        } else {
            Node tmp = tail;
            tmp.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        Node<T> tmp = header;
        if (size() == 1) {
            tail = null;
        }
        header = tmp.next;
        size--;
        return tmp.getObj();
    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            return "NULL";
        }
        Node tmp = header;
        do {
            sb.append(tmp.getObj().toString() + "|");
            tmp = tmp.next;
        } while (tmp != null);
        return sb.toString();
    }

    private class Node<T> {
        private T obj;
        private Node next;

        public Node(T obj) {
            this.obj = obj;
        }

        public T getObj() {
            return obj;
        }

        public void setObj(T obj) {
            this.obj = obj;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
