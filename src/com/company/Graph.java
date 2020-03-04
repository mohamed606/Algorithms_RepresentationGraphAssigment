package com.company;

import java.util.ArrayList;

public class Graph {
   private ArrayList<Vertex>graphVertices;
   public Graph(ArrayList<Vertex> graphVertices)
   {
       this.graphVertices=graphVertices;
   }

   public ArrayList<Vertex> createAdjacencyList () {
       return graphVertices;
   }
   public Vertex findVertex(String vertexName)
    {
        for (Vertex graphVertex : graphVertices) {
            if (graphVertex.getVertexName().equals(vertexName)) {
                return graphVertex;
            }
        }
        return null;
    }


}
