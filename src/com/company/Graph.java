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
   public int [][] createAdjacencyMatrix(){
       int [][] adjacencyMatrix = new int[graphVertices.size()][graphVertices.size()];
       for(int i=0 ; i<graphVertices.size();i++){
           Vertex vertex = graphVertices.get(i);
           ArrayList<Vertex>adjacentVertices = vertex.getAdjacentVertices();
           for(int j=0 ; j<adjacentVertices.size();j++){
               adjacencyMatrix[i][graphVertices.indexOf(adjacentVertices.get(j))]=1;
           }
       }
       return adjacencyMatrix;
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
