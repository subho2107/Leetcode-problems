import java.util.*;

// Definition for a Node.

class CloneGraph {
    HashSet<Integer>visited;
    Node [] nodes;
    public void util(Node node){
        visited.add(node.val);
        ArrayList<Node> temp = new ArrayList<>();
        for(Node neighbor : node.neighbors){
            if(!visited.contains(neighbor.val)){
                nodes[neighbor.val] = new Node(neighbor.val);
                util(neighbor);
            }
            temp.add(nodes[neighbor.val]);
        }
        nodes[node.val].neighbors = new ArrayList<>(temp);
    }
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        nodes = new Node[101];
        nodes[1] = new Node(1);
        visited = new HashSet<>();
        util(node);
        return nodes[1];
    }

    public static void main(String[] args) {
        Node [] arr = new Node[5];
        for (int i = 1; i < 5; i++) {
            arr[i] = new Node(i);
        }
        arr[1].neighbors.add(arr[2]);
        arr[1].neighbors.add(arr[4]);

        arr[2].neighbors.add(arr[1]);
        arr[2].neighbors.add(arr[3]);

        arr[3].neighbors.add(arr[2]);
        arr[3].neighbors.add(arr[4]);

        arr[4].neighbors.add(arr[1]);
        arr[4].neighbors.add(arr[3]);
        new CloneGraph().cloneGraph(arr[1]);
    }
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}