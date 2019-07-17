package Node;

public class Node {
    private String data;
    private Node nextNode;

    public Node(String data) {
        this.data = data;
    }

    public Node append(String data) {
        return this.append(new Node(data));
    }

    public Node append(Node nextNode) {
        Node node = this;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.nextNode = nextNode;
        return this;
    }

    public Node append(int index, String data) {
        Node node = this;
        for (int i = 0; i < index - 1; i++) {
            node = node.getNext();
            if (node == null) {
                throw new RuntimeException("不存在指定位置：" + index);
            }
        }
        Node newNode = new Node(data);
        newNode.nextNode = node.getNext();
        node.nextNode = newNode;
        return node;
    }

    public void removeNext() {
        Node nextNode = this.nextNode.nextNode;
        this.nextNode = nextNode;
    }

    public boolean isLast() {
        return this.getNext() == null;
    }

    public Node getNext() {
        return this.nextNode;
    }

    public void show() {
        Node nextNode = this;
        System.out.print("[");
        while (nextNode != null) {
            System.out.print(" " + nextNode.data + " ");
            nextNode = nextNode.getNext();
        }
        System.out.println("]");
    }

}
