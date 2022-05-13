package graph.algorithm;

import java.util.ArrayList;

import graph.Graph;
import graph.ValorableUndirectionalGraph;
import graph.algorithm.Algorithm;
import graph.components.Valorable;
import graph.components.edge.undirectional.ValorableUndirectionalEdge;
import graph.components.vertex.Vertex;
import graph.matrix.Matrix;

public class FloydWarshall implements Algorithm {
    private Matrix<Integer> distances;
    private ArrayList<Vertex> vertexs;

    @Override
    public void run(Graph g) {
        ValorableUndirectionalGraph g = (ValorableUndirectionalGraph) g;
        vertexs.addAll(g.getAllVertexs());
        distances = new Matrix<>();
        for (int i = 0; i < vertexs.size(); i++) {
            distances.setValue(vertexs.get(i).getId(), 0, i + 1);
            distances.setValue(vertexs.get(i).getId(), i + 1, 0);
        }
        System.out.println(distances);
    }

}