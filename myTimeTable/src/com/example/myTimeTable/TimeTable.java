package com.example.myTimeTable;

import java.io.*;
import java.util.*;

public class TimeTable {

    private static final int N = 10;
    private static final int Y = 6;
    private static final int X = 4;

    public static void main(String[] args) throws FileNotFoundException {
        Week[] monday = new Week[Y];
        Week[] tuesday = new Week[Y];
        Week[] yesterday = new Week[Y];
        Week[] thursday = new Week[Y];
        Week[] friday = new Week[Y];
        Week[] saturday = new Week[X];
        Professor[] a = new Professor[N];
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int i = 0, h, count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0;
        do {
            menu();
            System.out.println("Введите номер действия из предложенного меню: ");
            h = scan1.nextInt();
            switch (h) {
                case (1):
                    System.out.println("Введите ФИО через пробел, через комбинацию ' , ' введите до трех предметов, которые он преподает: ");
                    System.out.println("Должен быть введен хотя бы один предмет, вместо пропуска предмета ставьте -");
                    do {
                        a[i] = new Professor();
                        a[i].teachersNotFile();
                        i++;
                        if (i == N) break;
                        System.out.print("Чтобы добавить преподавателя нажмите 1, иначе 2: ");
                        h = scan1.nextInt();
                    }while(h != 2);
                    break;
                case (2):
                    FileReader frT = new FileReader ("teachers.txt");
                    Scanner scan_frT = new Scanner(frT);
                     do{
                        String str = scan_frT.nextLine();
                        a[i] = new Professor();
                        a[i].teachersFile(str);
                        i++;
                        if (i == N) break;
                    }while (scan_frT.hasNextLine());
                    break;
                case (3):
                    System.out.println("Список преподавателей:");
                    for(int k = 0; k < N; k++){
                        if(a[k] == null)break;
                        a[k].print(k+1);
                    }
                    break;
                case (4):
                    if(a[0] == null) {
                        System.out.println("Заполните список преподавателей!");
                        break;
                    }
                    System.out.println("Напишите день недели, по-английски: ");
                    String p = scan2.nextLine();
                    System.out.println("Напишите номер преподавателя: ");
                    int num1 = scan2.nextInt(); num1--;
                    System.out.println("Напишите номер предмета: ");
                    int num2 = scan2.nextInt();
                    switch (p) {
                        case ("monday") -> {
                            if (count1 < Y) {
                                monday[count1] = new Week();
                                completion(a[num1], monday[count1], num2);
                                count1++;
                            } else {
                                System.out.println("На этот день недели записано максимальное кол-во пар!");
                            }
                        }
                        case ("tuesday") -> {
                            if (count2 < Y) {
                                completion(a[num1], tuesday[count2], num2);
                                count2++;
                            } else {
                                System.out.println("На этот день недели записано максимальное кол-во пар!");
                            }
                        }
                        case ("yesterday") -> {
                            if (count3 < Y) {
                                completion(a[num1], yesterday[count3], num2);
                                count3++;
                            } else {
                                System.out.println("На этот день недели записано максимальное кол-во пар!");
                            }
                        }
                        case ("thursday") -> {
                            if (count4 < Y) {
                                completion(a[num1], thursday[count4], num2);
                                count4++;
                            } else {
                                System.out.println("На этот день недели записано максимальное кол-во пар!");
                            }
                        }
                        case ("friday") -> {
                            if (count5 < Y) {
                                completion(a[num1], friday[count5], num2);
                                count5++;
                            } else {
                                System.out.println("На этот день недели записано максимальное кол-во пар!");
                            }
                        }
                        case ("saturday") -> {
                            if (count6 < X) {
                                completion(a[num1], saturday[count6], num2);
                                count6++;
                            } else {
                                System.out.println("На этот день недели записано максимальное кол-во пар!");
                            }
                        }
                        case ("sunday") -> System.out.println("Воскресенье не учебный день!");
                    }
                    break;
                case(5):
                    System.out.println("Понедельник");
                    for(int j = 0; j < Y; j++) {
                        print(monday[j]);
                    }
                    System.out.println("Вторник");
                    for(int j = 0; j < Y; j++) {
                        print(tuesday[j]);
                    }
                    System.out.println("Среда");
                    for(int j = 0; j < Y; j++) {
                        print(yesterday[j]);
                    }
                    System.out.println("Четверг");
                    for(int j = 0; j < Y; j++) {
                        print(thursday[j]);
                    }
                    System.out.println("Пятница");
                    for(int j = 0; j < Y; j++) {
                        print(friday[j]);
                    }
                    System.out.println("Суббота");
                    for(int j = 0; j < X; j++) {
                        print(saturday[j]);
                    }
                    break;
                case(0):
                    return;
            }
        }while(h > 0);
    }

    public static void menu(){
        System.out.println("< Меню для составления расписания:                   >");
        System.out.println("< 1.Записать преподавателя в список                  >");
        System.out.println("< 2.Переписать преподавателей из файла в список      >");
        System.out.println("< 3.Вывести список преподавателей                    >");
        System.out.println("< 4.Заполнение расписания                            >");
        System.out.println("< 5.Вывести расписание                               >");
        System.out.println("< 0.Закончить работу                                 >");
    }

    public  static  void completion(Professor a, Week b, int p) {
        Scanner scan = new Scanner(System.in);
        String str = new String();
        System.out.println("Введите название группы и номер аудитории через ' , ', которые хотите добавить в расписание: ");
        str = scan.nextLine();
        String[] params = str.split(",");
        b.writeGroup(params[0]);
        b.writeRoom(params[1]);
        b.copy(a);
        b.writeObj(a.setObject(p));
    }

    public static void print(Week b){
        if(b != null) {
            b.printWeek();
            System.out.println("\n");
        } else {
            System.out.println("null");
        }
    }

}
