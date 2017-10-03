/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.list01;

/**
 *
 * @author Eduardo
 */
public class CList <T>{
    Node<T> pivot;
    Node<T> pointer;
    int length;
    
    CList(){
        pivot = pointer = null;
        length = 0;
    }
    
    CList(T d){
        Node<T> node = new Node<>(d);
	pivot = node.next = node;
	length++;
    }
    
    public boolean isEmpty(){
        return length == 0;
    }
    
    public void insert(T d){
        Node<T> node = new Node<>(d);
        if (isEmpty()) {
            pivot = node.next = node;
        } else {
            node.next = pivot.next;
            pivot.next = node;
        }
        length++;
    }
    
    public void deleteNode(T d){
        if (!isEmpty()){
            pointer = pivot;
            for (int i = 1; i<= length; i++){
                if (pointer.data == d){
                    pointer.next = pointer.next.next;
                    if (pivot.data == d){
                        pivot = pointer;
                    }
                    length--;
                    pointer = null;
                    i = length + 1;
                }
                pointer = pointer.next;
            }
        }
    }
    
    public void deleteList(){
        pivot = pointer = null;
    }
}
