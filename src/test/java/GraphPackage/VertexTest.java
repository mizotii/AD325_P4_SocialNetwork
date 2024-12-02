package GraphPackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VertexTest {

    @Test
    void getLabel() {
        Vertex<Integer> v1 = new Vertex<>(5);
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
        String expected = "Vertex{label=5, cost=10}";
        assertEquals(expected, v1.toString());
    }

    @Test
    void getWeightIterator() {
    }

    @Test
    void connect() {
    }

    @Test
    void testConnect() {
    }

    @Test
    void getNeighborIterator() {
    }

    @Test
    void hasNeighbor() {
    }

    @Test
    void getUnvisitedNeighbor() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void display() {
    }
}
