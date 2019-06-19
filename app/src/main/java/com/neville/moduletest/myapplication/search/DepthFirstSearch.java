package com.neville.moduletest.myapplication.search;

import com.neville.moduletest.myapplication.dataStructure.graph.Graph;

import java.util.LinkedList;

/**
 * Created by niewei on 2019/6/13.
 */

//深度优先搜索
public class DepthFirstSearch {
    private static boolean found = false;

    public static void main(String[] args) {
        Graph.MyGraph graph = new Graph.MyGraph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        dfs(graph, 0, 7);
    }

    public static void dfs(Graph.MyGraph graph, int s, int t) {
        found = false;
        LinkedList<Integer>[] data = graph.getAdj();
        int v = data.length;//顶点数
        boolean[] visited = new boolean[v];
        visited[s] = true;
        int[] prev = new int[v];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = -1;
        }
        recurDfs(data, s, t, visited, prev);
        print(prev, s, t);
    }

    public static void recurDfs(LinkedList<Integer>[] data, int s, int t, boolean[] visited, int[] prev) {
        if (found) return;
        visited[s] = true;
        if (s == t) {
            found = true;
            return;
        }
        for (int i = 0; i < data[s].size(); i++) {
            int q = data[s].get(i);
            if (!visited[q]) {
                prev[q] = s;
                recurDfs(data, q, t, visited, prev);
            }
        }
    }


    //递归打印
    private static void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + "->");
    }

}
