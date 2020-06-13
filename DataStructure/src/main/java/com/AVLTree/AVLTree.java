package com.AVLTree;

public class AVLTree {
    private Node root;
    public AVLTree(){}

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void add(Node node){
        if(root==null){
            root=node;
            return;
        }else {
            root.add(node);
        }
    }
    public void infixOrder(){
        if(root==null){
            System.out.println("树为空");
        }else {
            root.infixOrder();
        }
    }
    public Node search(int value){
        if(root==null){
            return null;
        }else {
            return root.search(value);
        }
    }
    public Node searchParent(int value){
        if(root==null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    /**
     *删除以node为根节点，最小的节点的值并返回该值
     * @param node 传入根节点
     * @return 以node为根节点最小节点的值
     */
    public int delRightTreeMin(Node node){
        Node target=node;
        //循环的查找左子节点，就会找到最小值
        while(target.left != null) {
            target = target.left;
        }
        //这时 target就指向了最小结点
        //删除最小结点
        delNode(target.value);
        return target.value;
    }
    public void delNode(int value){
        if(root==null){
            return;
        }else {
            //1.需求先去找到要删除的结点  targetNode
            Node targetNode = search(value);
            //如果没有找到要删除的结点
            if(targetNode == null) {
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个结点
            if(root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node parent=searchParent(value);
            //删除叶子节点
            if(targetNode.left==null&&targetNode.right==null){
                if(parent.left!=null&&parent.left.value==value){
                    parent.left=null;
                }else parent.right=null;

            }else if(targetNode.left!=null&&targetNode.right!=null){//删除有两棵子树的节点
                int i = delRightTreeMin(targetNode.right);
                targetNode.value=i;

            }else {//删除只有一颗子树的节点

                if (targetNode.left != null) {//要删除的节点有左子节点
                    if (parent != null) {//父节点为空说明是根节点
                        if (parent.left!=null&&parent.left.value == value) {//targetNode是parent的左子节点
                            parent.left = targetNode.left;
                        } else parent.right = targetNode.left;
                    } else {
                        root = targetNode.left;
                    }
                } else {//要删除的节点有右子节点
                    if (parent != null) {
                        if (parent.left!=null&&parent.left.value == value) {//targetNode是parent的左子节点
                            parent.left = targetNode.right;
                        } else parent.right = targetNode.right;
                    } else {//父节点为空说明是根节点
                        root = targetNode.right;
                    }
                }


            }



        }
    }
}
class Node {
    int value;
    Node right;
    Node left;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node(int value) {
        this.value = value;
    }

    public int leftHeight(){
        if(left==null){
            return 0;
        }else {
            return left.height();
        }
    }
    public int rightHeight(){
        if(right==null){
            return 0;
        }else {
            return right.height();
        }
    }
    /**
     *
     * @return 返回当前子树的高度
     */
    public int height(){
        return Math.max((left==null)?0:left.height(),right==null?0:right.height())+1;
    }

    /**
     * 当右子树大于左子树时向左旋转
     */
    public void leftRotate(){
        //创建新的结点，以当前根结点的值
        Node newNode = new Node(value);
        //把新的结点的左子树设置成当前结点的左子树
        newNode.left = left;
        //把新的结点的右子树设置成带你过去结点的右子树的左子树
        newNode.right = right.left;
        //把当前结点的值替换成右子结点的值
        value = right.value;
        //把当前结点的右子树设置成当前结点右子树的右子树
        right = right.right;
        //把当前结点的左子树(左子结点)设置成新的结点
        left = newNode;
    }
    //右旋
    public void rightRotate(){
        Node newNode=new Node(value);
        newNode.right=right;
        newNode.left=left.right;
        value=left.value;
        right=newNode;
        left=left.left;
    }

    public void add(Node node){
        if(node==null){
            return;
        }
        if(node.value<this.value){//放左边
            if(this.left!=null){
                this.left.add(node);
            }else {
                this.left=node;
            }
        }else {//放右边
            if (this.right!=null){
                this.right.add(node);
            }else {
                this.right=node;
            }
        }

        if(rightHeight()-leftHeight()>1){//左旋
            if(right.leftHeight()>right.rightHeight()){
                right.rightRotate();
                leftHeight();
            }else leftRotate();
            return;
        }
        if(leftHeight()-rightHeight()>1){//右旋
            //如果它的左子树的右子树高度大于它的左子树的高度
            if(left != null && left.rightHeight() > left.leftHeight()) {
                //先对当前结点的左结点(左子树)->左旋转
                left.leftRotate();
                //再对当前结点进行右旋转
                rightRotate();
            } else {
                //直接进行右旋转即可
                rightRotate();
            }
        }



    }
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }

        System.out.println(this);

        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    /**
     *
     * @param value
     * @return 当前节点
     */
    public Node search(int value){
        if(value==this.value){
            return this;
        }else if(value<this.value){//向左找
            if(this.left==null){
                return null;
            }
            return this.left.search(value);
        }else {
            if(this.right==null){
                return right;
            }
            return this.right.search(value);
        }
    }

    /**
     *
     * @param value 要找的节点值
     * @return 当前节点的父节点
     */
    public Node searchParent(int value){
        if((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)){
            return this;
        }else {
            if(value<this.value&&this.left!=null){
                return this.left.searchParent(value);
            }else if(value>this.value&&this.right!=null){
                return this.right.searchParent(value);
            }else return null;
        }

    }
}