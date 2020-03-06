package com.company;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> graphVertices;
    private ArrayList<Edge> graphEdges;

    public Graph(ArrayList<Vertex> graphVertices, ArrayList<Edge> graphEdges) {
        this.graphEdges = graphEdges;
        this.graphVertices = graphVertices;
    }

    public ArrayList<Vertex> createAdjacencyList() {
        return graphVertices;
    }
    public ArrayList<ArrayList<Vertex>> createDirectedAdjacencyList(){
        ArrayList<ArrayList<Vertex>> adjacencyList = new ArrayList<>();
        for(int i=0; i<graphVertices.size(); i++){
            Vertex vertex = graphVertices.get(i);
            adjacencyList.add(new ArrayList<>());
            for(int j=0; j<graphEdges.size(); j++){
                Vertex edgeStart=graphEdges.get(j).getStart();
                Vertex edgeEnd=graphEdges.get(j).getTermination();
                if(vertex.equals(edgeStart))
                    adjacencyList.get(i).add(edgeEnd);
            }
        }
        return adjacencyList;
    }



    public int[][] createDiAdjacencyMatrix() {
        int[][] diAdjacencyMatrix = new int[graphVertices.size()][graphVertices.size()];
        ArrayList<ArrayList<String>> diAdjacencyList = createDiAdjacencyList();
        for (int i = 0; i < graphVertices.size(); i++) {
            ArrayList<String> adjacentVertices = diAdjacencyList.get(i);
            for (int j = 1; j < adjacentVertices.size(); j++) {
                diAdjacencyMatrix[i][findVertex(adjacentVertices.get(j))] = 1;
            }
        }
        return diAdjacencyMatrix;
    }

    public int[][] createAdjacencyMatrix() {
        int[][] adjacencyMatrix = new int[graphVertices.size()][graphVertices.size()];
        for (int i = 0; i < graphVertices.size(); i++) {
            Vertex vertex = graphVertices.get(i);
            ArrayList<Vertex> adjacentVertices = vertex.getAdjacentVertices();
            for (int j = 0; j < adjacentVertices.size(); j++) {
                adjacencyMatrix[i][graphVertices.indexOf(adjacentVertices.get(j))] = 1;
            }
        }
        return adjacencyMatrix;
    }

    public int[][] createRepresentationMatrix() {
        int[][] representationMatrix = new int[graphVertices.size()][graphVertices.size()];
        for (int i = 0; i < graphVertices.size(); i++) {
            Vertex vertex = graphVertices.get(i);
            ArrayList<Vertex> adjacentVertices = vertex.getAdjacentVertices();
            ArrayList<Integer> numberOfEdgesBetweenEachVertices = vertex.getNumberOfEdgesWithEachAdjacentVertex();
            for (int j = 0; j < adjacentVertices.size(); j++) {
                representationMatrix[i][graphVertices.indexOf(adjacentVertices.get(j))] = numberOfEdgesBetweenEachVertices.get(j);
            }
        }
        return representationMatrix;
    }

    public int[][] createDiRepresentationMatrix() {
        int[][] representationMatrix = new int[graphVertices.size()][graphVertices.size()];
        ArrayList<ArrayList<String>> diAdjacencyList = createDiAdjacencyList();
        ArrayList<Edge> tempEdges = deepCopyForEdges();
        for (int i = 0; i < graphVertices.size(); i++) {
            ArrayList<String> adjacentVertices = diAdjacencyList.get(i);
            String start = adjacentVertices.get(0);
            for (int j = 1; j < adjacentVertices.size(); j++) {
                int numberOfEdgesWithEachAdjacentVertex = 0;
                String end = adjacentVertices.get(j);
                for (int s = 0; s < tempEdges.size(); s++) {
                    Edge edge = tempEdges.get(s);
                    if (edge.getStart().getVertexName().equals(start) && edge.getTermination().getVertexName().equals(end)) {
                        numberOfEdgesWithEachAdjacentVertex++;
                        tempEdges.remove(s);
                        s--;
                    }
                }
                representationMatrix[i][findVertex(end)] = numberOfEdgesWithEachAdjacentVertex;
            }
        }
        return representationMatrix;
    }

    public int findVertex(String vertexName) {
        for (int i = 0; i < graphVertices.size(); i++) {
            if (graphVertices.get(i).getVertexName().equals(vertexName)) {
                return i;
            }
        }
        return -1;
    }

    public int[][] createIncidenceMatrix() {
        int[][] incidenceMatrix = new int[graphVertices.size()][graphEdges.size()];
        for (int i = 0; i < graphVertices.size(); i++) {
            Vertex vertex = graphVertices.get(i);
            for (int j = 0; j < graphEdges.size(); j++) {
                Vertex edgeStart = graphEdges.get(j).getStart();
                Vertex edgeEnd = graphEdges.get(j).getTermination();
                if (vertex.equals(edgeStart) || vertex.equals(edgeEnd)) {
                    incidenceMatrix[i][j] = 1;
                }
            }
        }
        return incidenceMatrix;
    }

    public int[][] createDiIncidenceMatrix() {
        int[][] incidenceMatrix = new int[graphVertices.size()][graphEdges.size()];
        for (int i = 0; i < graphVertices.size(); i++) {
            Vertex vertex = graphVertices.get(i);
            for (int j = 0; j < graphEdges.size(); j++) {
                Vertex edgeStart = graphEdges.get(j).getStart();
                Vertex edgeEnd = graphEdges.get(j).getTermination();
                if (vertex.equals(edgeStart)) {
                    incidenceMatrix[i][j] = 1;
                } else if (vertex.equals(edgeEnd)) {
                    incidenceMatrix[i][j] = -1;
                }
            }
        }
        return incidenceMatrix;
    }

    private ArrayList<Edge> deepCopyForEdges() {
        return new ArrayList<>(graphEdges);
    }
    private ArrayList<ArrayList<String>> createDiAdjacencyList() {
        ArrayList<Edge> temporaryEdges = deepCopyForEdges();
        ArrayList<ArrayList<String>> diAdjacencyList = new ArrayList<>();
        for (int i = 0; i < graphVertices.size(); i++) {
            Vertex vertex = graphVertices.get(i);
            ArrayList<String> adjacentVertices = new ArrayList<>();
            adjacentVertices.add(vertex.getVertexName());
            for (int j = 0; j < temporaryEdges.size(); j++) {
                Edge edge = temporaryEdges.get(j);
                if (vertex.getVertexName().equals(edge.getStart().getVertexName())) {
                    temporaryEdges.remove(j);
                    j--;
                    int index = adjacentVertices.lastIndexOf(edge.getTermination().getVertexName());
                    if (-1==index || (index==0)) {
                        adjacentVertices.add(edge.getTermination().getVertexName());
                    }
                }
            }
            diAdjacencyList.add(adjacentVertices);
        }
        return diAdjacencyList;
    }

    public ArrayList<Edge> getGraphEdges() {
        return graphEdges;
    }
}
