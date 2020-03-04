package com.company;

import java.util.ArrayList;

public class Vertex {
    private String vertexName;
    private ArrayList<Vertex>adjacentVertices;
    private ArrayList<Integer>numberOfEdgesWithEachAdjacentVertex;
    public Vertex(String vertexName)
    {
        this.vertexName=vertexName;
    }
    public ArrayList<Integer> getNumberOfEdgesWithEachAdjacentVertex() {
        return numberOfEdgesWithEachAdjacentVertex;
    }

   void addVertex(Vertex vertex)
   {
       if(adjacentVertices == null && numberOfEdgesWithEachAdjacentVertex == null){
           adjacentVertices=new ArrayList<>();
           numberOfEdgesWithEachAdjacentVertex= new ArrayList<>();
       }
       int vertexIndex=adjacentVertices.indexOf(vertex);
       if(vertexIndex == -1)
       {
           adjacentVertices.add(vertex);
           numberOfEdgesWithEachAdjacentVertex.add(1);
       }else {
           int numberOfEdges = numberOfEdgesWithEachAdjacentVertex.get(vertexIndex)+1;
           numberOfEdgesWithEachAdjacentVertex.set(vertexIndex,numberOfEdges);
       }

   }

    public ArrayList<Vertex> getAdjacentVertices() {
        return adjacentVertices;
    }

    public String getVertexName() {
        return vertexName;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Vertex)
        {
            Vertex vertex=(Vertex) obj;
            return this.vertexName.equals(vertex.getVertexName());
        }
        return false;
    }

}
