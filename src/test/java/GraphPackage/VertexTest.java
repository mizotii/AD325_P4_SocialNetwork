
// Joel Yang: see: Vertex.java, VertexInterface.java

package GraphPackage;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
//Eric Norman tested this class
class VertexTest {

    @Test
    void getLabel() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        assertEquals(v1.getLabel(), 5);
    }

    @Test
    void hasPredecessor() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        VertexInterface<Integer> v2 = new Vertex<>(7);
        assertFalse(v1.hasPredecessor());
        v1.setPredecessor(v2);
        assertTrue(v1.hasPredecessor());
    }

    @Test
    void setPredecessor() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        VertexInterface<Integer> v2 = new Vertex<>(7);
        v1.setPredecessor(v2);
        assertTrue(v1.hasPredecessor());
    }

    @Test
    void getPredecessor() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        VertexInterface<Integer> v2 = new Vertex<>(7);
        v1.setPredecessor(v2);
        assertEquals(v2.getLabel(), v1.getPredecessor().getLabel());
    }

    @Test
    void visit() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        assertFalse(v1.isVisited());
        v1.visit();
        assertTrue(v1.isVisited());
    }

    @Test
    void unvisit() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        v1.visit();
        assertTrue(v1.isVisited());
        v1.unvisit();
        assertFalse(v1.isVisited());
    }

    @Test
    void isVisited() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        assertFalse(v1.isVisited());
        v1.visit();
        assertTrue(v1.isVisited());
    }

    @Test
    void getCost() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        assertEquals(0, v1.getCost());
        v1.setCost(10);
        assertEquals(10, v1.getCost());
    }

    @Test
    void setCost() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        v1.setCost(10);
        assertEquals(10, v1.getCost());
    }

    @Test
    void testToString() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        v1.setCost(10);
        String expected = "5";
        assertEquals(expected, v1.toString());
    }

    @Test
    void getWeightIterator() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        VertexInterface<Integer> v2 = new Vertex<>(7);
        VertexInterface<Integer> v3 = new Vertex<>(9);
        v1.connect(v2, 2.0);
        v2.connect(v3, 3.0);
        v1.connect(v3, 4.0);
        Iterator<Double> it = v1.getWeightIterator();
        assertTrue(it.hasNext());
        it.next();
        assertEquals(4.0, it.next(), 0.001);
    }

    @Test
    void connect() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        VertexInterface<Integer> v2 = new Vertex<>(7);
        boolean success = v1.connect(v2, 2.0);
        assertTrue(success);
        Iterator<Double> it = v1.getWeightIterator();
        assertTrue(it.hasNext());
        assertEquals(2.0, it.next(), 0.001);
    }

    @Test
    void testConnect() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        VertexInterface<Integer> v2 = new Vertex<>(7);
        boolean success = v1.connect(v2);
        assertTrue(success);
        Iterator<VertexInterface<Integer>> it = v1.getNeighborIterator();
        assertTrue(it.hasNext());
        assertEquals(it.next(), v2);
    }

    @Test
    void getNeighborIterator() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        VertexInterface<Integer> v2 = new Vertex<>(7);
        VertexInterface<Integer> v3 = new Vertex<>(9);
        v1.connect(v2);
        v1.connect(v3);
        Iterator<VertexInterface<Integer>> it = v1.getNeighborIterator();
        assertTrue(it.hasNext());
        it.next();
        assertEquals(v3.getLabel(), it.next().getLabel());
    }

    @Test
    void hasNeighbor() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        VertexInterface<Integer> v2 = new Vertex<>(7);
        assertFalse(v1.hasNeighbor());
        v1.connect(v2);
        assertTrue(v1.hasNeighbor());
        assertFalse(v2.hasNeighbor());
        v2.connect(v1);
        assertTrue(v2.hasNeighbor());
    }

    @Test
    void getUnvisitedNeighbor() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        VertexInterface<Integer> v2 = new Vertex<>(7);
        VertexInterface<Integer> v3 = new Vertex<>(9);
        v1.connect(v2);
        v1.connect(v3);
        v2.visit();
        assertEquals(v3, v1.getUnvisitedNeighbor());
    }

    @Test
    void testEquals() {
        VertexInterface<Integer> v1 = new Vertex<>(5);
        VertexInterface<Integer> v2 = new Vertex<>(5);
        assertEquals(v1, v2);
    }

    @Test
    void display() {
    }
}
