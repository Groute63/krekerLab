package com.company.buildings;

import com.company.buildings.Interfece.Floor;

import java.io.Serializable;

public class DNode<T extends Floor> implements Serializable {
    public    T value;
    public DNode<T> next;
    public DNode<T> prev;
    public DNode(){

    }
    public DNode(T value, DNode<T> prev,DNode<T> next)
    {
        this.value = value;
        this.next=next;
        this.prev = prev;
    }
    public Object clone(){
        try {
            DNode<T> cl = (DNode<T>) super.clone();
            if(this.value != null)
                cl.value = (T) this.value.clone();
            return cl;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
