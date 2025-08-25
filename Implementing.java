/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comple;



/**
 *
 * @author BED
 */
public class Implementing  {

    private int[] array;
    private int size;
    
    public Implementing (int capacity){
    array = new int [capacity];
    size = 0;
    }
    
    public void add(int data){
    if (size == array.length){
        System.out.println("List is full.");
        return;
    }
    array[size] = data;
    size++;
    }
    
    public Integer poll(){
    if (size == 0){
    return null;
    }
    
    int data = array[0];
    for (int i = 1; i < size; i++){
    array[i - 1] = array[i];
    }
      size--;
    return data;
    }
    public Integer peek(){
    if (size == 0){
    return null;
    }
    return array [0];
    }
    public Integer pop(){
    if (size == 0){
    return null;
    }
    int data = array [size - 1];
    size --;
    return data;
    }
    public static void main(String[] args) {
        Implementing list = new Implementing (5);
        list.add(1);
        list.add(2);
        list.add(3);
        
        System.out.println("Peek: "+ list.peek());
        System.out.println("Poll: "+ list.poll());
        System.out.println("Pop: "+ list.pop());
        
    }
    
}