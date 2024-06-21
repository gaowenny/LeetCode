
// head 是空数据
public class LinkNodeList<T> {
    private LinkNode<T> head, tail;
    private Integer size;

    public LinkNodeList() {
        head = new LinkNode<>(null);
        size = 0;
        tail = null;
    }

    public void addFirst(T data) {
        if (data == null) {
            return;
        }
        LinkNode<T> node = new LinkNode<>(data);
        node.next = head.next;
        head.next = node;
        size++;
    }

    public void addEnd(T data) {
        if (data == null) {
            return;
        }
        LinkNode<T> node = new LinkNode<>(data);
        tail.next = node;
        tail = node;
        size++;
    }

    public void add(int index, T data) {
        checkIndexElementValid(index);
        if (data == null) {
            return;
        }
        if (index == size) {
            addEnd(data);
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        LinkNode<T> newNode = new LinkNode<>(data);
        LinkNode<T> certNode = head;
        for (int i = 0; i < index; i++) {
            certNode = certNode.next;
        }
        newNode.next = certNode.next;
        certNode.next = newNode;
        size++;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        LinkNode<T> node = head.next;
        head.next = node.next;
        size--;
    }

    public void deleteEnd() {
        if (isEmpty()) {
            return;
        }
        LinkNode<T> node = head;
        while (node.next != tail) {
            node = node.next;
        }
        tail = node;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        LinkNode<T> node = head.next;
        return node.val;
    }

    public T getEnd() {
        if (isEmpty()) {
            return null;
        }
        return tail.val;
    }

    public T get(int index) {
        checkIndexPositionValid(index);
        if (isEmpty()) {
            return null;
        }
        LinkNode<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.val;
    }

    public LinkNode<T> getNode(int index) {
        checkIndexPositionValid(index);
        if (isEmpty()) {
            return null;
        }
        LinkNode<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int getSize() {
        return size;
    }

    public LinkNode<T> getHead() {
        return head;
    }

    public LinkNode<T> getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return size > 0;
    }

    public void checkIndexPositionValid(int index) {
        if (!isIndexPositionValid(index)) {
            throw new RuntimeException("index not valid");
        }
    }

    public void checkIndexElementValid(int index) {
        if (!isIndexPositionValid(index)) {
            throw new RuntimeException("index not valid");
        }
    }

    // index 位置是否合法
    private boolean isIndexPositionValid(int index) {
        return index >= 0 && index < size;
    }
    private boolean isIndexElementValid(int index) {
        return index >= 0 && index <= size;
    }
}
