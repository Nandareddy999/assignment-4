package coreJava;

import java.util.Scanner;

class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Trees {
    static Node root;
    Node temp = root;

    Trees(){
            root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    public void inOrder(Node temp){
            if(temp == null){
                return;
            }

            inOrder(temp.left);
            System.out.print(temp.data + " ");
            inOrder(temp.right);

    }

    public void preOrder(Node temp) {
        if(temp == null){
            return;
        }

        System.out.print(temp.data + " ");
        preOrder(temp.left);
        preOrder(temp.right);
    }
    public void postOrder(Node temp){
        if(temp == null){
            return;
        }

        postOrder(temp.left);
        postOrder(temp.right);
        System.out.print(temp.data + " ");
    }

    public static void main(String[] args) {
        Trees tree = new Trees();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        for(int i=0; i<size; i++){
            int element = sc.nextInt();
            tree.insert(element);
        }
        tree.inOrder(root);
        System.out.println();
        tree.preOrder(root);
        System.out.println();
        tree.postOrder(root);
    }

}
