package com.neville.moduletest.myapplication.dataStructure.tree;

import com.neville.moduletest.myapplication.utils.TreeNode;

/**
 * Created by niewei on 2019/6/12.
 */

public class BinarySearchTree {
    private static TreeNode root;

    //注意是无重复数据的插入，查找，删除
    public static void main(String[] args) {
        insert(5);
        insert(3);
        insert(7);
        insert(9);
        insert(2);
        insert(1);
        insert(6);

        delete(9);
        delete(6);
        delete(1);
        delete(5);
        TraverseBinaryTree.inOrderTraversal(root);

    }

    private static void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        TreeNode node = root;
        while (node != null) {
            if (data > node.value) {
                if (node.right == null) {
                    node.right = new TreeNode(data);
                    return;
                }
                node = node.right;
            } else {
                if (node.left == null) {
                    node.left = new TreeNode(data);
                    return;
                }
                node = node.left;
            }
        }
    }


    private static TreeNode find(int data) {
        TreeNode node = root;
        while (node != null) {
            if (data > node.value) {
                node = node.right;
            } else if (data < node.value) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }


    private static void delete(int data) {
        TreeNode p = root;
        TreeNode pp = null;//p的父节点,作用是删除p节点
        while (p != null && p.value != data) {
            pp = p;
            if (data > p.value) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) return;//没有找到这个节点

        //如果要删除的节点，左右子树都存在
        if (p.left != null && p.right != null) {
            TreeNode minpp = p;
            TreeNode minp = p.right;
            //查找右子树最小节点
            while (minp.left != null) {
                minpp = minp;
                minp = minp.left;
            }
            p.value = minp.value;//注意，这个地方替换了p和minp的值，然后删除的其实是minp
            p = minp;
            pp = minpp;
        }

        TreeNode child = null;//p的子节点，最终p的父节点指向p的子节点
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        }

        if (pp == null) {
            root = child;//删除的是根节点
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }

    }


}
