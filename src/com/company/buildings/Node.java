package com.company.buildings;

import com.company.buildings.Interfece.Space;

import java.io.Serializable;

public class Node<T extends Space> implements Serializable {
 public    T value;
   public Node<T> next;
    public Node(){

    }
    public Node(T value,Node<T> next)
    {
        this.value = value;
        this.next=next;
    }

}
