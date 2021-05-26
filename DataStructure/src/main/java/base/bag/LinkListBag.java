package base.bag;

import java.util.Iterator;
import java.util.Random;

public class LinkListBag<T> implements Iterable<T> {
    private int size;
    private Node<T> header;
    private Node<T> tail;
    private RandomBag<T> randomBag;

    public void add(T obj) {
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

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkListBagIterator<>();
    }

    public T getObjByRandomBag() {
        if (randomBag == null) {
            randomBag = new RandomBag(header, size());
        }
        return randomBag.get();
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

    private class LinkListBagIterator<T> implements Iterator<T> {
        Node tmp = header;
        private int iteratorSize = size();

        @Override
        public boolean hasNext() {
            return iteratorSize > 0;
        }

        @Override
        public T next() {
            Node currentNode = tmp;
            tmp = tmp.next;
            iteratorSize--;
            return (T) currentNode.getObj();
        }
    }

    private class Node<T> {
        private T obj;
        private Node<T> next;

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

    private class RandomBag<T> {
        private T[] objects;
        private Random random = new Random();
        private int objRemainedInbag;

        public RandomBag(Node<T> header, int size) {
            Object[] objects = new Object[size];
            //this.objects=objects;
            Node<T> tmp = header;
            for (int i = 0; i < size; i++) {
                objects[i] = tmp.getObj();
                tmp = tmp.next;
            }
            this.objects = (T[]) objects;
            objRemainedInbag = size;
        }

        public T get() {
            if (objRemainedInbag == 0) {
                System.out.println("Waring : base.bag is null");
                return null;
            }
            int randomNum = getRandomNum(objRemainedInbag);
            T right = objects[randomNum];
            T left = objects[objRemainedInbag - 1];
            objects[randomNum] = left;
            objects[objRemainedInbag - 1] = right;
            this.objRemainedInbag--;
            return right;
        }

        private int getRandomNum(int bond) {
            return random.nextInt(bond);
        }
    }
}
