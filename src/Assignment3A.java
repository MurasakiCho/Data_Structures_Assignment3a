/*
Name: Briana O'Neal
Class: CS 3305/W01
Term: Fall 2022
Instructor: Sharon Perry
Assignment: 3 - Part 1 Iterator
*/

// class for LinkedList nodes: each node has an integer and a next pointer
class node {
    public int data;
    public node next;

    node(int data){
        this.data = data;
    }

    public static node lastNode(node node){
        if(node.next != null){
            return lastNode(node.next);
        }
        return node;
    }
}

//class for collection of nodes: adds nodes, shows list, prints x inclusive y exclusive range of list, and removes repetitions
class Collection{
    private node head = null;

    //add method: takes in an int, puts it in a new node
    //if head is empty, the new node is now head
    //else, a method to find the last node is activated and the new node is set to lastNode.next (aka the end of the list)
    public void add(int n){
        node temp = new node(n);
        if(head == null){
            head = temp;
        }
        else{
            node.lastNode(head).next = temp;
        }
    }

    //show_all method: prints every node's data in order
    public void show_all(){
        node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    //prints a range of numbers in the list
    public void printRange(int x, int y){
        node temp = head;
        while(temp != null){
            //if nothing equals x, nothing prints
            if(temp.data == x){
                while(temp != null){
                    //prints until it finds an integer equal to y
                    if(temp.data != y){
                        System.out.print(temp.data + " ");
                    }
                    else{
                        break;
                    }
                    temp = temp.next;
                }
                //signifies end of list
                System.out.print("End\n");
                break;
            }
            temp = temp.next;
        }
    }

    //removes and repetition of numbers in the list
    public void removeRepetitions(){
        node temp = head;
        node prev = null;

        //loops through each node
        while(temp != null){
            //sets current node data to comparable variable
            int compare = temp.data;
            node temp2 = temp.next;
            //loops through each node to compare variables
            while(temp2 != null){
                //if duplicate found, removes it
                if(temp2.data == compare){
                   temp.next = temp2.next;
                }
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
    }
}

public class Assignment3A {
    public static void main(String[] args) {
        //create list and add integers
        Collection collection = new Collection();
        collection.add(1);
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(3);
        collection.add(4);
        collection.add(4);
        collection.add(5);
        collection.add(6);
        collection.add(7);

        collection.printRange(1, 5);
        collection.removeRepetitions();
        collection.show_all();
    }
}
