// Joel Yang: created all unit tests for this class. see: BasicGraphInterface.java, DirectedGraph.java,
// GraphAlgorithms.java

package GraphPackage;

import ADTPackage.*;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class DirectedGraphTest {
    DirectedGraph<Integer> g;

    @org.junit.jupiter.api.Test
    void addVertex() {
        g = new DirectedGraph<>();
        boolean success = g.addVertex(1);
        assertTrue(success);
        ListWithIteratorInterface<Integer> list = new LinkedListWithIterator<>();
        assertEquals(g.getVertexLabels().getEntry(1), 1);
    }

    @org.junit.jupiter.api.Test
    void removeVertex() {
        g = new DirectedGraph<>();
        assertTrue(g.isEmpty());
        g.addVertex(1);
        assertFalse(g.isEmpty());
        boolean success = g.removeVertex(1);
        assertTrue(g.isEmpty());
        assertTrue(success);
    }

    @org.junit.jupiter.api.Test
    void addEdge() {
        g = new DirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addEdge(1, 2);
        assertEquals(1, g.getNumberOfEdges());
    }

    @org.junit.jupiter.api.Test
    void testAddEdge() {
        g = new DirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addEdge(1, 2, 1.0);
        assertEquals(1, g.getNumberOfEdges());
    }

    @org.junit.jupiter.api.Test
    void hasEdge() {
        g = new DirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addEdge(1, 2);
        assertTrue(g.hasEdge(1, 2));
    }

    @org.junit.jupiter.api.Test
    void removeEdge() {
        g = new DirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addEdge(1, 2);
        assertTrue(g.removeEdge(1, 2));
        assertFalse(g.hasEdge(1, 2));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        g = new DirectedGraph<>();
        assertTrue(g.isEmpty());
        g.addVertex(1);
        assertFalse(g.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        g = new DirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        assertFalse(g.isEmpty());
        g.clear();
        assertTrue(g.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void getVertexLabels() {
        g = new DirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        LinkedListWithIterator<Integer> compare = new LinkedListWithIterator<>();
        compare.add(4);
        compare.add(3);
        compare.add(2);
        compare.add(1);
        assertEquals(g.getVertexLabels().getLength(), compare.getLength());
        assertEquals(g.getVertexLabels().getEntry(1), compare.getEntry(1));
        assertEquals(g.getVertexLabels().getEntry(2), compare.getEntry(2));
        assertEquals(g.getVertexLabels().getEntry(3), compare.getEntry(3));
        assertEquals(g.getVertexLabels().getEntry(4), compare.getEntry(4));
    }

    @org.junit.jupiter.api.Test
    void getNumberOfVertices() {
        g = new DirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        assertEquals(g.getNumberOfVertices(), 2);
        g.addVertex(3);
        g.addVertex(4);
        assertEquals(g.getNumberOfVertices(), 4);
        g.clear();
        assertEquals(g.getNumberOfVertices(), 0);
    }

    @org.junit.jupiter.api.Test
    void getNumberOfEdges() {
        g = new DirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        assertEquals(g.getNumberOfEdges(), 0);
        g.addEdge(1, 2);
        assertEquals(g.getNumberOfEdges(), 1);
        g.addEdge(3, 4);
        assertEquals(g.getNumberOfEdges(), 2);
    }

    @org.junit.jupiter.api.Test
    void getBreadthFirstTraversal() {
        g = new DirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addVertex(7);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        QueueInterface<Integer> q = new LinkedQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        QueueInterface<Integer> bfsResult = g.getBreadthFirstTraversal(1);
        assertEquals(q.dequeue(), bfsResult.dequeue());
        assertEquals(q.dequeue(), bfsResult.dequeue());
        assertEquals(q.dequeue(), bfsResult.dequeue());
        assertEquals(q.dequeue(), bfsResult.dequeue());
        assertEquals(q.dequeue(), bfsResult.dequeue());
        assertEquals(q.dequeue(), bfsResult.dequeue());
        assertEquals(q.dequeue(), bfsResult.dequeue());
        assertTrue(q.isEmpty());
        assertTrue(bfsResult.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void getDepthFirstTraversal() {
        g = new DirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addVertex(7);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        QueueInterface<Integer> q = new LinkedQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(5);
        q.enqueue(3);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(4);
        QueueInterface<Integer> dfsResult = g.getDepthFirstTraversal(1);
        assertEquals(q.dequeue(), dfsResult.dequeue());
        assertEquals(q.dequeue(), dfsResult.dequeue());
        assertEquals(q.dequeue(), dfsResult.dequeue());
        assertEquals(q.dequeue(), dfsResult.dequeue());
        assertEquals(q.dequeue(), dfsResult.dequeue());
        assertEquals(q.dequeue(), dfsResult.dequeue());
        assertEquals(q.dequeue(), dfsResult.dequeue());
        assertTrue(q.isEmpty());
        assertTrue(dfsResult.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void getTopologicalOrder() {
        g = new DirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addVertex(7);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        StackInterface<Integer> s = new LinkedStack<>();
        s.push(7);
        s.push(6);
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        StackInterface<Integer> tResult = g.getTopologicalOrder();
        assertEquals(s.pop(), tResult.pop());
        assertEquals(s.pop(), tResult.pop());
        assertEquals(s.pop(), tResult.pop());
        assertEquals(s.pop(), tResult.pop());
        assertEquals(s.pop(), tResult.pop());
        assertEquals(s.pop(), tResult.pop());
        assertEquals(s.pop(), tResult.pop());
        assertTrue(s.isEmpty());
        assertTrue(tResult.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void getShortestPath() {
        g = new DirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(1, 4);
        assertEquals(g.getShortestPath(1, 4, new LinkedStack<Integer>()), 1);
    }

    @org.junit.jupiter.api.Test
    void getCheapestPath() {
        g = new DirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addEdge(1, 2, 2.0);
        g.addEdge(2, 3, 2.0);
        g.addEdge(3, 4, 2.0);
        g.addEdge(1, 4, 7.0);
        assertEquals(g.getCheapestPath(1, 4, new LinkedStack<Integer>()), 6.0);
    }

    @org.junit.jupiter.api.Test
    void findTerminal() {
        g = new DirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(1, 4);
        assertEquals(g.findTerminal().getLabel(), 4);
    }

    @org.junit.jupiter.api.Test
    void displayEdges() {
        g = new DirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(1, 4);
        g.displayEdges();
    }
}