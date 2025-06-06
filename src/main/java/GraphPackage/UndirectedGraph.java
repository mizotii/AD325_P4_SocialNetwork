// Joel Yang: implemented removeEdge

package GraphPackage;


import ADTPackage.StackInterface;

public class UndirectedGraph<T> extends DirectedGraph<T> implements GraphInterface<T>
{
    public UndirectedGraph()
    {
        super();
    } // end default constructor

    public boolean addEdge(T begin, T end, double edgeWeight)
    {
        return super.addEdge(begin, end, edgeWeight) &&
                super.addEdge(end, begin, edgeWeight);
        // Assertion: edge count is twice its correct value due to calling addEdge twice
    } // end addEdge

    public boolean addEdge(T begin, T end)
    {
        return this.addEdge(begin, end, 0);
    } // end addEdge

    public boolean removeEdge(T begin, T end) {
        return super.removeEdge(begin, end) && super.removeEdge(end, begin);
    }

    public int getNumberOfEdges()
    {
        return super.getNumberOfEdges() / 2;
    } // end getNumberOfEdges

    public StackInterface<T> getTopologicalOrder()
    {
        throw new UnsupportedOperationException("Topological sort is illegal in an undirected graph.");
    } // end getTopologicalOrder
} // end UndirectedGraph
