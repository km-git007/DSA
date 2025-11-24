class Node {
    String siteName;
    Node prev, next;
    public Node(String siteName) {
        this.siteName = siteName;
    }
}

class BrowserHistory {
    private Node curr;
    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }

    public void visit(String url) {
        Node node = new Node(url);
        curr.next = node;
        node.prev = curr;

        curr = curr.next;
    }

    public String back(int steps) {
        while(curr.prev != null && steps-- > 0){
            curr = curr.prev;
        }
        return curr.siteName;
    }

    public String forward(int steps) {
        while(curr.next != null && steps-- > 0){
            curr = curr.next;
        }
        return curr.siteName;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */