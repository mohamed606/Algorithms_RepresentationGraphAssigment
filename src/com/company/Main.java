package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter number of Vertices");
        Scanner input= new Scanner(System.in);
        int numberOfVetices= input.nextInt();

        String startVertex;
        String terminalVertex;
        ArrayList<Vertex>graphVertices=new ArrayList<>();
        for(int i=0;i<numberOfVetices;i++)
        {
            graphVertices.add(new Vertex(input.next()));
        }
    Graph graph=new Graph(graphVertices);

        int termination;

        while(true)
        {
            System.out.println("Enter -1 to Exit");
            termination=input.nextInt();
            if(termination==-1)
            {
                break;
            }
            startVertex=input.next();
            terminalVertex=input.next();
            Vertex start=graph.findVertex( startVertex);
            Vertex terminal =graph.findVertex(terminalVertex);
            start.addVertex(terminal);
            terminal.addVertex(start);

        }
//      ArrayList<Vertex>adjacencyList= graph.createAdjacencyList();
//        for(int i=0;i<adjacencyList.size();i++)
//        {
//            Vertex vertex = adjacencyList.get(i);
//            System.out.print(vertex.getVertexName()+" ");
//            ArrayList<Vertex>adjacentVertices = vertex.getAdjacentVertices();
//            for(int j=0 ; j<adjacentVertices.size();j++){
//
//                System.out.print(adjacentVertices.get(j).getVertexName()+" , ");
//
//            }
//            System.out.println();
//        }
        printTwoDemnsionalArray(graph.createAdjacencyMatrix(),graphVertices);

    }
    static void printTwoDemnsionalArray(int [][] array , ArrayList<Vertex>vertices){
        System.out.print("  ");
        for(int i=0 ; i<vertices.size();i++){
            System.out.print(vertices.get(i).getVertexName()+" ");
        }
        System.out.println();
        for(int i=0 ; i<array.length;i++){
            System.out.print(vertices.get(i).getVertexName()+" ");
            for(int j=0;j<array[0].length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
