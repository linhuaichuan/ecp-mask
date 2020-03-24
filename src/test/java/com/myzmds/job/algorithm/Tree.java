package com.myzmds.job.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.alibaba.druid.support.json.JSONUtils;

public class Tree {
    public class Node {
        private Object value; // 节点的值
        
        private Node node; // 此节点，数据类型为Node
        
        private Node left;
        
        private Node right;
        
        public Object getValue() {
            return value;
        }
        
        public void setValue(Object value) {
            this.value = value;
        }
        
        public Node getNode() {
            return node;
        }
        
        public void setNode(Node node) {
            this.node = node;
        }
        
        public Node getLeft() {
            return left;
        }
        
        public void setLeft(Node left) {
            this.left = left;
        }
        
        public Node getRight() {
            return right;
        }
        
        public void setRight(Node right) {
            this.right = right;
        }
        
        public Node(Object value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    
    // 队列遍历
    public ArrayList<Object> print(Node root) {
        ArrayList<Object> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node nowNode = q.poll();// 返回第一个元素并删除
            resultList.add(nowNode.value);
            if (nowNode.left != null) {
                q.add(nowNode.left);
            }
            if (nowNode.right != null) {
                q.add(nowNode.right);
            }
        }
        
        return resultList;
    }
    
    // 前序遍历：1-获取，2-递归左，3-递归右
    public void preTraversal(Node node) {
        if (node == null) // 很重要，必须加上 当遇到叶子节点用来停止向下遍历
            return;
        System.out.print(node.getValue() + " ");
        preTraversal(node.getLeft());
        preTraversal(node.getRight());
    }
    
    // 中序遍历：1-递归左，2-获取，3-递归右
    public void midTraversal(Node node) {
        if (node == null)
            return;
        midTraversal(node.getLeft());
        System.out.print(node.getValue() + " ");
        midTraversal(node.getRight());
    }
    
    // 后序遍历：1-递归左，2-递归右，3-获取
    public void postTraversal(Node node) {
        if (node == null)
            return;
        postTraversal(node.getLeft());
        postTraversal(node.getRight());
        System.out.print(node.getValue() + " ");
    }
    
    // 栈遍历
    public void preOrderTraversalbyLoop(Node node) {
        Stack<Node> stack = new Stack<Node>();
        Node p = node;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                // 当p不为空时，就读取p的值，并不断更新p为其左子节点，即不断读取左子节点
                System.out.print(p.getValue() + " ");
                stack.push(p); // 将p入栈
                p = p.getLeft();
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.getRight();
            }
        }
    }
    
    public Node getNode(Object value) {
        return new Node(value);
    }
    
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.getNode("A");
        Node nodeB = tree.getNode("B");
        Node nodeC = tree.getNode("C");
        Node nodeD = tree.getNode("D");
        Node nodeE = tree.getNode("E");
        Node nodeF = tree.getNode("F");
        Node nodeG = tree.getNode("G");
        Node nodeH = tree.getNode("H");
        Node nodeI = tree.getNode("I");
        root.setLeft(nodeB);
        root.setRight(nodeC);
        nodeB.setLeft(nodeD);
        nodeB.setRight(nodeF);
        nodeC.setLeft(nodeG);
        nodeC.setRight(nodeI);
        nodeF.setRight(nodeE);
        nodeG.setRight(nodeH);
        System.out.println("前序：");
        tree.preTraversal(root);
        System.out.println("");
        System.out.println("中序：");
        tree.midTraversal(root);
        System.out.println("");
        System.out.println("队列：");
        System.out.println(JSONUtils.toJSONString(tree.print(root)));
        System.out.println("");
        System.out.println("队列：");
    }
}
