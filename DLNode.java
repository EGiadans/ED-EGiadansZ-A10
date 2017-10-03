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
public class DLNode <T> {
    T data;
    DLNode next;
    DLNode back;
    
    DLNode(T d){
        data = d;
        next = null;
        back = null;
    }
    
    
}
