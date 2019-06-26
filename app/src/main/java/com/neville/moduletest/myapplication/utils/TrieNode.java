package com.neville.moduletest.myapplication.utils;

/**
 * Created by niewei on 2019/6/20.
 */

public class TrieNode {
    public boolean isEndingChar = false;
    public char data;
    public TrieNode[] children;

    public TrieNode(char data) {
        this.data = data;
        children = new TrieNode[26];
    }

}
