package GraphPackage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class UndirectedGraphTest {
    UndirectedGraph<Integer> g;

    @Test
    void addEdge() {
        g = new UndirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addEdge(1, 2);
        assertTrue(g.hasEdge(1, 2));
        assertTrue(g.hasEdge(2, 1));
    }

    @Test
    void testAddEdge() {
        g = new UndirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addEdge(1, 2, 1.0);
        assertTrue(g.hasEdge(1, 2));
        assertTrue(g.hasEdge(2, 1));
    }

    @Test
    void removeEdge() {
        g = new UndirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addEdge(1, 2);
        g.removeEdge(2, 1);
        assertFalse(g.hasEdge(1, 2));
        assertFalse(g.hasEdge(2, 1));
    }

    @Test
    void getNumberOfEdges() {
        g = new UndirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        assertEquals(g.getNumberOfEdges(), 0);
        g.addEdge(1, 2);
        g.addEdge(3, 6);
        assertEquals(g.getNumberOfEdges(), 2);
        g.addEdge(2, 3);
        g.addEdge(1, 5);
        assertEquals(g.getNumberOfEdges(), 4);
        g.addEdge(6, 5);
        g.addEdge(4, 2);
        g.addEdge(4, 6);
        assertEquals(g.getNumberOfEdges(), 7);
        g.clear();
        assertEquals(g.getNumberOfEdges(), 0);
    }

    @Test
    void getTopologicalOrder() {
        g = new UndirectedGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addEdge(1, 2);

        assertThrows(UnsupportedOperationException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                g.getTopologicalOrder();
            }
        });
    }
}