package com.neville.moduletest.myapplication.search;

import com.neville.moduletest.myapplication.dataStructure.graph.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by niewei on 2019/6/13.
 */

//广度优先搜索
public class BreadthFirstSearch {

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
        bfs(graph, 0, 6);
    }

    public static void bfs(Graph.MyGraph graph, int s, int t) {
        if (s == t) return;
        LinkedList<Integer>[] data = graph.getAdj();
        int v = data.length;//顶点数
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        boolean[] visited = new boolean[v];
        visited[s] = true;
        int[] prev = new int[v];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            int w = queue.poll();
            LinkedList<Integer> list = data[w];
            for (int i = 0; i < list.size(); i++) {
                int q = list.get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        for (int j = 0; j < prev.length; j++) {
                            System.out.print(prev[j] + "  ");

                        }

                        print(prev, s, t);
                    }
                    visited[q] = true;
                    queue.add(q);
                }
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
