package todolist;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Scanner;

public class ToDoList{
    
    ArrayList<String> taskList = new ArrayList<>();
    ArrayList<String> pending = new ArrayList<>();
    ArrayList<String> completed = new ArrayList<>();
    
    public static int count;

    Scanner scanner = new Scanner(System.in);

    public void addTask() {
        while (true) {
            System.out.println("add new task: Exit: zero");
            String newTask = scanner.nextLine();
            if(!newTask.equals("zero")){
                taskList.add(newTask);
                pending.add(newTask);
                count++;
            }
            else{
                System.out.println("========================");
                break;   
            }
        }
     
    }

    public void completeTask() {
        for(int i = 0; i < taskList.size(); i++){
            System.out.println((i)+ ". "+ taskList.get(i));
        }
        while(true){
            System.out.println("enter your task index to complete: Quit: -1");
            int index = scanner.nextInt();
            if(index >= 0 && index < taskList.size()){
                System.out.println("\"" + taskList.get(index)+ "\""+" has been completed\n=================");
                taskList.remove(index);
                if(taskList.isEmpty()){ 
                    System.out.println("you finished all your tasks\n=========================");
                    break; 
                }
            } 
            else if(index == -1){
                System.out.println("==========================");
                break;
            }
            else{
                System.out.println("indalid index. Please try again");
            }
        }
    }

    public void TaskManager() {
        Scanner optionScaner = new Scanner(System.in);
        while (true) {
            System.out.println("choose: 1. add tasks, 2. complete task, 3. displayTasks, 4.suggestions, 5. quit");
            int userChoice = optionScaner.nextInt();
            System.out.println("====================================");
            switch (userChoice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    completeTask();
                    break;
                case 3 : 
                    displayTasks();
                    break;
                case 4:
                    suggestions();
                    break;
                case 5 : 
                    System.out.println("program stopped");
                    System.exit(userChoice);
                    break;
                default:
                    System.out.println("invalid option. Please try again.");
                    optionScaner.close();
                    break;
            }                               
        }
    }

    public void suggestions() {

        boolean love = true;
        while (love) {

            System.out.println("Choose one of Following Options");
            System.out.println("================");
            System.out.println("1. edit tasks");
            System.out.println("2. displayTasks !");
            System.out.println("3. Random Task");
            System.out.println("4. Back");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    editTask();
                    break;
                case 2:
                    displayTasks();
                    break;
                case 3:
                    randomTasks();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid Option. Please try Again");
                    System.out.println("=======================");
                    break;
            }
            break;
        }
    }

    public void editTask() {
        for(int i = 0; i < taskList.size(); i ++){
            System.out.println((i+1) + ". " + taskList.get(i));
        }
        System.out.println("enter task number that you want to edit");
        System.out.println("only index of Task: ");
        int taskIndex = scanner.nextInt();
        scanner.nextLine();
        if (taskIndex >= 1 && taskIndex <= taskList.size()) {
            System.out.println("enter new task description: ");
            String newTask = scanner.nextLine();
            // taskList.remove(taskIndex);
            // taskList.add(newTask);
            taskList.set(taskIndex - 1, newTask);
            System.out.println("task has been updated successfully");
        }  
        else{ 
            System.out.println("something went wrong. Please try again");
        }
    }

    public void displayTasks() {
        System.out.println("Here is Your all Tasks:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 0) + "." + taskList.get(i));
        }
        System.out.println("All you Have is: " + taskList.size());
        System.out.println("==============================");
    }

    public void randomTasks() {
    
        int randomTask = (int)(Math.random()*taskList.size());
        String radnomString = taskList.get(randomTask);
        System.out.println("random task: "+radnomString);
        
        // Random random = new Random();
        // int randomIndex = random.nextInt(taskList.size());
        // String randomTask = taskList.get(randomIndex);
        // System.out.println("you can just do " + randomTask);
    } 
}
