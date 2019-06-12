package com.neville.moduletest.myapplication.dataStructure.tree;

import com.neville.moduletest.myapplication.utils.TreeNode;

/**
 * Created by niewei on 2019/6/12.
 */

public class TraverseTree {
    //              A
    //       B             C
    //   D       E     F       G
    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");
        TreeNode nodeG = new TreeNode("G");
        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeC.left = nodeF;
        nodeC.right = nodeG;
//        preOrderTraversal(nodeA);
//        inOrderTraversal(nodeA);
        postOrderTraversal(nodeA);
    }

    //前序遍历
    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    //中序遍历
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.value);
        inOrderTraversal(node.right);
    }

    //后序遍历
    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value);
    }
}
