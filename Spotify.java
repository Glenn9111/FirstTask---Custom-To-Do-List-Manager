/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tests;

/**
 *
 * @author PC
 */
import java.util.*;

public class Spotify {
//Setting up like the playlist, stacks and scanner
    private static ArrayList<String> playlist = new ArrayList<>();
     private static Stack<ArrayList<String>> undoStack = new Stack<>();
    private static Stack<ArrayList<String>> redoStack = new Stack<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Looping menu
        
        boolean lop = true;
        while (lop) {
        System.out.println("Menu:");
            System.out.println("1. Add song");
            System.out.println("2. Remove last song");
            System.out.println("3. Undo");
            System.out.println("4. Redo");
            System.out.println("5. View playlist");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            String choices = sc.nextLine();
            
            //Switch
            
            switch 
                    (choices) {
                case "1":
                    addSong();
                    break;
                case "2":
                    removeLastSong();
                    break;
                case "3": 
                    undo();
                    break;
                case "4":
                    redo();
                    break;
                case "5":
                    view();
                    break;
                case "6": 
                    lop = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        
    }
    //Add song
    private static void addSong(){
        System.out.println("Enter song name: ");
        String song = sc.nextLine();
        saveStateToUndo();
        redoStack.clear();
        playlist.add(song);
        System.out.println("Added: "+ song);
    }
    //remove song
    private static void removeLastSong(){
    if (playlist.isEmpty()){
        System.out.println("Playlist is already empty.");
        return;
    }
        saveStateToUndo();
        redoStack.clear();
        String removed = playlist.remove(playlist.size() - 1);
        System.out.println("Removed: "+ removed);
    }
    //undo
    private static void undo(){
    if (undoStack.isEmpty()){
        System.out.println("Nothing to undo.");
        return;
        
    }
    saveStateToRedo();
    playlist = undoStack.pop();
        System.out.println("Undo successful");
    }
    private static void redo(){
    if (redoStack.isEmpty()){
        System.out.println("Nothing to redo");
        return;
    }
    saveStateToUndo();
    playlist = redoStack.pop();
        System.out.println("Redo successful");
    }
    //view playlist
    private static void view(){
    if (playlist.isEmpty()){
System.out.println("Playlist is empty");

    }else{
        System.out.println("Current Playlist: ");
        for (int i = 0; i < playlist.size(); i++){
            System.out.println((i + 1)+ ". "+ playlist.get(i));
        
        }
    }
}   
    private static void saveStateToUndo(){
    undoStack.push(new ArrayList<>(playlist));
    }
    private static void saveStateToRedo(){
    redoStack.push(new ArrayList<>(playlist));
    }
}
