package com.example.myTimeTable;

import java.util.*;

public class Professor {
    private String name;
    private String[] object;

    public Professor() {
        this.name = new String();
        this.object = new String[3];
    }

    public Professor(String name, String obj1, String obj2, String obj3){
        this.name = name;
        this.object[0] = obj1;
        this.object[1] = obj2;
        this.object[2] = obj3;
    }

    public String setName(){
        return this.name;
    }

    public void copy(Professor a){
        this.name = a.name;
        this.object[0] = a.object[0];
        this.object[1] = a.object[1];
        this.object[2] = a.object[2];
    }

    public String setObject(int i){
        return this.object[i];
    }
    public void teachersNotFile(){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] params = str.split(",");
        this.name = params[0];
        this.object[0] = params[1];
        this.object[1] = params[2];
        this.object[2] = params[3];
    }
    public void teachersFile(String str) {
        String[] params = str.split(",");
        this.name = params[0];
        this.object[0] = params[1];
        this.object[1] = params[2];
        this.object[2] = params[3];
    }

    public void print(int p) {
        System.out.println("Номер" + p);
        System.out.println("ФИО: " + name);
        for(int j = 0; j < object.length; j++) {
            System.out.println("Предмет" + (j+1) + ":" + object[j]);
        }
        System.out.println();
    }
}
