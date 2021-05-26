package tree;

public interface BinNode {
    public Object setElement(Object obj);
    public Object getElement();

    public BinNode setRightBinNode(BinNode binNode);
    public BinNode getRightBinNode();

    public BinNode setLeftBinNode(BinNode binNode);
    public BinNode getLeftBinNode();

    public boolean isLeaf();

}
