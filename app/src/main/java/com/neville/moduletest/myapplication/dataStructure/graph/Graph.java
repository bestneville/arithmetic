package com.neville.moduletest.myapplication.dataStructure.graph;

import java.util.LinkedList;

/**
 * Created by niewei on 2019/6/13.
 */

public class Graph {

    public static void main(String[] args) {

    }


    //无向图
    public static class MyGraph {
        private int v;
        private LinkedList<Integer>[] adj;

        public MyGraph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) {
            //无向图一条边存两次
            adj[s].add(t);
            adj[t].add(s);
        }

        public LinkedList<Integer>[] getAdj() {
            return adj;
        }
    }
}
