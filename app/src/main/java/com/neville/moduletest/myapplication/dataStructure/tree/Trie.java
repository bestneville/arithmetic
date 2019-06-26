package com.neville.moduletest.myapplication.dataStructure.tree;

import com.neville.moduletest.myapplication.utils.TrieNode;

/**
 * Created by niewei on 2019/6/20.
 */

//字典树
public class Trie {
    private static TrieNode root = new TrieNode('/');//存储无意义字符;

    public static void main(String[] args) {
        insertNode("hi");
        insertNode("hello");
        insertNode("sorry");
        insertNode("hah");
        insertNode("so");
        insertNode("world");
        boolean find = find("hello");
        System.out.print(find);
    }

    private static void insertNode(String insertStr) {
        char[] data = insertStr.toCharArray();
        TrieNode p = root;
        for (int i = 0; i < data.length; i++) {
            int index = data[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(data[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    private static boolean find(String findStr) {
        char[] data = findStr.toCharArray();
        TrieNode p = root;
        for (int i = 0; i < data.length; i++) {
            int index = data[i] - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEndingChar;//不能完全匹配的话，只是前缀
    }
}
