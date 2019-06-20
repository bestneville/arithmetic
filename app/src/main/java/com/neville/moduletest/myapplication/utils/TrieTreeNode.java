package com.neville.moduletest.myapplication.utils;

/**
 * Created by niewei on 2019/6/20.
 */

public class TrieTreeNode {
    public boolean isEndingChar = false;
    public char data;
    public TrieTreeNode[] children;

    public TrieTreeNode(char data) {
        this.data = data;
        children = new TrieTreeNode[26];
    }

}
