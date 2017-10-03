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
public class DLList <T> {
    DLNode first;
    DLNode last;
    DLNode pointer;
    int length;
    
    DLList(){
        first = null;
        last = null;
        pointer = null;
        length = 0;
    }
    
    DLList(T d){
        DLNode<T> node = new DLNode<>(d);
        first = node;
        last = node;
        length++;
    }
    
    public boolean isEmpty(){
        return length == 0;
    }
    
    public void insertFirst(T d){
        DLNode<T> node = new DLNode<>(d);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.back = node;
        }
        length++;
    }
    
    public void insertLast(T d){
        DLNode<T> node = new DLNode<>(d);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            node.back = last;
            last.next = node;
            last = node;
        }
        length++;
    }
    
    public void deleteFirst(){
        if (!isEmpty()) {
            if (first.next == null) {
                first = null;
                last = null;
            } else {
                first = first.next;
            }
            length--;
        }
    }
    
    public void deleteLast(){
        if (!isEmpty()) {
            if (first.next == null) {
                first = null;
                last = null;
            } else {
                last = last.back;
            }
            length--;
        }
    }
    
    public boolean deleteNode(T d){
        DLNode node = fetch(d);
        if (node != null){
            if (node.data == d) {
                deleteFirst();
            } else {
                node.back.next = node.next;
                node.next.back = node.back;
            }
            length--;
            return true;
        }
        return false;
    }
    
    public DLNode fetch(T d){
        pointer = first;
        if (!isEmpty()) {
            if (first == last){
                if (first.data == d){
                    return first;
                } else {
                    return null;
                }
            } else {
                if (first.data == d) {
                    return first;
                } else {
                    pointer = first;
                    while (pointer.next != last) {
                        if (pointer.data == d){
                            return pointer;
                        }
                        pointer = pointer.next;
                    }
                }
            }
        }
        return null;
    }
    
    public void showListFirstLast(){
        pointer = first;
        System.out.println("first->");
        for (int i=0;i<length;i++){
            System.out.println("["+pointer.data+"]->");
            pointer = pointer.next;
        }
        System.out.println("<-last");
    }
    
    public void showListLastFirst(){
        pointer = last;
        System.out.println("last->");
        for (int i= length; i>0; i--){
            System.out.println("["+pointer.data+"]->");
            pointer = pointer.back;
        }
        System.out.println("<-first");
    }
    
    
    
}
