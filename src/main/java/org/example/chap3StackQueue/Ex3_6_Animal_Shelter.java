package org.example.chap3StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.DelayQueue;


public class Ex3_6_Animal_Shelter {
    Deque<Animal> queue = new LinkedList<>();

    public void enqueue(Animal animal){
        queue.addLast(animal);
    }

    public Animal dequeAny(){
        if(queue.isEmpty()){
            return null;
        }
        return queue.pollFirst();
    }

    public Animal dequeCat(){
        if(queue.isEmpty()){
            return null;
        }

        if(queue.peekFirst().type.equals("cat")){
            return queue.pollFirst();
        }else{
            Iterator<Animal> iterator = queue.iterator();
            Animal result = null;
            while(iterator.hasNext()){
                Animal ele = iterator.next();
                if(ele.type.equals("cat")){
                    result = ele;
                    iterator.remove();
                    break;
                }
            }
            return result;
        }
    }

    public Animal dequeDog(){
        if(queue.isEmpty()){
            return null;
        }

        if(queue.peekFirst().type.equals("dog")){
            return queue.pollFirst();
        }else{
            Iterator<Animal> iterator = queue.iterator();
            Animal result = null;
            while(iterator.hasNext()){
                Animal ele = iterator.next();
                if(ele.type.equals("dog")){
                    result = ele;
                    iterator.remove();
                    break;
                }
            }
            return result;
        }
    }

    /*
 cat-1  -> dog-1  -> cat-2 -> cat-3 -> dog-2

 */
    public static void main(String[] args) {
        Ex3_6_Animal_Shelter solution = new Ex3_6_Animal_Shelter();
        solution.enqueue(new Animal("cat", 1));
        solution.enqueue(new Animal("dog", 1));
        solution.enqueue(new Animal("cat", 2));
        solution.enqueue(new Animal("cat", 3));
        solution.enqueue(new Animal("dog", 2));
        solution.enqueue(new Animal("dog", 3));

        System.out.println("dequeAny: " + solution.dequeAny()); // cat-1
        System.out.println("deque cat: " + solution.dequeCat()); // cat-2
        System.out.println("deque dog: " + solution.dequeDog()); // dog - 1
        System.out.println("deque dog: " + solution.dequeDog()); // dog - 2
        System.out.println("deque any: " + solution.dequeAny()); // cat - 3
        System.out.println("deque cat: " + solution.dequeCat()); // null


    }

    static class Animal{
        public Animal(){};

        public Animal(String type, int id){
            this.type = type;
            this.id = id;
        }

        public String type;
        public int id;

        public String toString(){
            return type + "-" + id;
        }
    }
}
