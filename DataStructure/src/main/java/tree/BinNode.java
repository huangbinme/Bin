package tree;

public interface BinNode {
    public Object setElement(Object obj);

    public Object getElement();

    public BinNode getRightBinNode();

    public BinNode setRightBinNode(BinNode binNode);

    public BinNode getLeftBinNode();

    public BinNode setLeftBinNode(BinNode binNode);

    public boolean isLeaf();

}
