package com.company;

import java.util.ArrayList;

public class Graph {
   private ArrayList<Vertex>graphVertices;
   private ArrayList<Edge>graphEdges;
   public Graph(ArrayList<Vertex> graphVertices,ArrayList<Edge>graphEdges)
   {
       this.graphEdges=graphEdges;
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
   public int [][] createRepresentationMatrix(){
       int [][] representationMatrix = new int[graphVertices.size()][graphVertices.size()];
       for(int i=0 ; i<graphVertices.size();i++){
           Vertex vertex = graphVertices.get(i);
           ArrayList<Vertex>adjacentVertices = vertex.getAdjacentVertices();
           ArrayList<Integer>numberOfEdgesBetweenEachVertices = vertex.getNumberOfEdgesWithEachAdjacentVertex();
           for(int j=0 ; j<adjacentVertices.size();j++){
               representationMatrix[i][graphVertices.indexOf(adjacentVertices.get(j))]=numberOfEdgesBetweenEachVertices.get(j);
           }
       }
       return representationMatrix;
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
    public int [][] createIncidenceMatrix()
    {
        int [][] incidenceMatrix=new int[graphVertices.size()][graphEdges.size()];
        for(int i=0;i<graphVertices.size();i++)
        {
            Vertex vertex=graphVertices.get(i);
            for(int j=0;j<graphEdges.size();j++)
            {
                Vertex edgeStart=graphEdges.get(j).getStart();
                Vertex edgeEnd=graphEdges.get(j).getTermination();
                if(vertex.equals(edgeStart )|| vertex.equals(edgeEnd))
                {
                    incidenceMatrix[i][j]=1;
                }
            }
        }
        return incidenceMatrix;
    }


    public ArrayList<Edge> getGraphEdges() {
        return graphEdges;
    }
}
