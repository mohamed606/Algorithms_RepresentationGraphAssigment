package com.company;

import java.util.ArrayList;

public class Vertex {
    private String vertexName;
    private ArrayList<Vertex>adjacentVertices;
    private int []  numberOfEdgesWithEachAdjacentVertex;

    public Vertex(String vertexName ,int numberOfVertices)
    {
        this.vertexName=vertexName;
        adjacentVertices=new ArrayList<>();
        numberOfEdgesWithEachAdjacentVertex= new int[numberOfVertices];
    }
    public int [] getNumberOfEdgesWithEachAdjacentVertex() {
        return numberOfEdgesWithEachAdjacentVertex;
    }

   void addVertex(Vertex vertex)
   {
       int vertexIndex=adjacentVertices.indexOf(vertex);
       if(vertexIndex == -1)
       {
           adjacentVertices.add(vertex);
           vertexIndex = adjacentVertices.size()-1;
       }
       numberOfEdgesWithEachAdjacentVertex[vertexIndex]++;

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
