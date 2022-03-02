package com.neo.datastructes;

public class LinkedList<E> {
    class Node<E> {
        Object<E> data ;
        Node<E> next ;
        Node<E> prev ;
        public Node<E>(E data){
            this.data = data;
        }

    }
    Node<E> head;
    Node<E> tail;
    int index;
    
    public void addLast(E e){
        Node<E> node = new Node<E>(e);
        if(tail != null){
            node.prev = tail;
            tail.next = node;
            tail = node;
        }else{
            tail = node;
        }
    }

    public void addFirst(E e){
        Node<E> node = new Node<>(e);
        if(head == null){
            head = node;
        }else{
            node.next = head;
            head.prev = node ;
            head = node;
        }
    }

    public void add(int index, E element){
        Node<E> current = head;
        while(index > 0){
            current = current.next;
            if(current == null){
                break;
            }
            --index;
        }
        Node<E> node = new Node<E>(element);
        node.prev = current;
        node.next = current.next;
        current.next.prev = node;
        current.next = node;
    }

    public boolean contains(Object o){
        Node<E> current = head;
        while(current.next != null){
            if(current.data == o){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear(){
        Node<E> current = tail;
        while(current.prev != null){
            current.next = null;
            current = current.prev;
        }
    }
    public E get(int index){
        Node<E> current = head; 
        while(index > 0){
            current = current.next;
            --index;
        }
        return current.data;
    }

    public int indexOf(Object o){
        Node<E> current = head; 
        int index = 0;
        while(current.next != null){
            if(current.data == o){
                return index;
            }else{
                ++index;
                current = current.next;
            }
        }
        if(current.data == o){
            return index;
        }else {
            return -1;
        }
    }

    public void removeFirst(){
        head = head.next;
        head.prev = null;
    }

    public void removeLast(){
        tail = tail.prev;
        tail.next = null;
    }

    public void remove(Object o){
        Node<E> current = head; 
        while(current.next != null){
            if(current.data == o){
               remove(current);
            }else{
                current = current.next;
            }
        }
    }

    public void remove(Node<E> current){
        current.prev.next =current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null; 
    }

    public void remove(int index){
        Node<E> current = head;
        while(index > 0){
            current = current.next;
            --index;
        }
        if(current != null){
            remove(current);
        }else {
            throw new RuntimeException();
        }
    }

    public Iterator<E> listIterator(int index){
        
    }
}