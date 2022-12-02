package com.example.myTimeTable;

import java.util.Scanner;

public class Week extends Professor{
    private Professor listProf;
    private String nameG;
    private String room;

    private String objectW;

    public Week() {
        this.listProf = new Professor();
        this.nameG = new String();
        this.room = new String();
        this.objectW = new String();
    }

    public String setNameG(){
        return this.nameG;
    }

    public void copy(Professor a){
        this.listProf.copy(a);
    }

    public void writeGroup(String g){
        this.nameG = g;
    }

    public void writeRoom(String r){
        this.room = r;
    }

    public void writeObj(String obj){
        this.objectW = obj;
    }

    public void printWeek(){
        String a = listProf.setName();
        System.out.println("Преподаватель:" + a);
        System.out.println("Предмет:" + objectW);
        System.out.println("Группа:" + nameG);
        System.out.println("Аудитория:" + room);
    }
}
