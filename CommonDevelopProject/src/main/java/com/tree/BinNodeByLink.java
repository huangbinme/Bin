package com.tree;

public class BinNodeByLink implements BinNode{
    private Object obj;
    private BinNode right;
    private BinNode left;

    public BinNodeByLink(Object obj) {
        this.obj = obj;
        this.right =null;
        this.left=null;
    }

    public BinNodeByLink(Object obj,BinNode right, BinNode left) {
        this.obj = obj;
        this.right =right;
        this.left=left;
    }

    @Override
    public Object setElement(Object obj) {
        return this.obj=obj;
    }


    @Override
    public Object getElement() {
        return this.obj;
    }

    @Override
    public BinNode setRightBinNode(BinNode binNode) {
        return this.right=binNode;
    }

    @Override
    public BinNode getRightBinNode() {
        return this.right;
    }

    @Override
    public BinNode setLeftBinNode(BinNode binNode) {
        return this.left=binNode;
    }

    @Override
    public BinNode getLeftBinNode() {
        return this.left;
    }

    @Override
    public boolean isLeaf() {
        return (right==null)&&(left==null);
    }
}
