package Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
    String name;
    String id;
    int age;
    String Class;
    float score;
    int grade;

    public Student (){

    }

    public Student(String name, String id, int age, String aClass, float score, int grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.Class = aClass;
        this.score = score;
        this.grade = grade;
    }
    void input(Scanner input) throws InputMismatchException {
        do {
            System.out.println("Enter Student name: ");
            name = input.next();
        }while (name == null);

        System.out.println("Enter Student ID: ");
        id = input.next();
        do {
            try {
                System.out.println("Enter Student Age: ");
                age = input.nextInt();
                if (age <= 0 || age >= 100){
                    System.out.println("Age are not available!");
                    age = 0;
                }
            }catch (InputMismatchException mismatchException){
                input.next();
                System.out.println("Try again! Age should be Integer !!!");
                age = 0;
            }
        }while(age == 0);

        System.out.println("Enter Student's class: ");
        Class = input.next();
        do {
            try {
                System.out.println("Enter score: ");
                score = input.nextFloat();
                if (score < 0 || score > 500){
                    System.out.println("Score is not available! please try again!\n");
                    score = 0;
                }
            }catch (InputMismatchException inputMismatchException){
                input.next();
                System.out.println("Score must be float number, not string please try again !!");
                score = 0;
            }
        }while (score == 0);
        do {
            try{
                System.out.println("Enter grade: ");
                grade = input.nextInt();
                if (grade <= 0){
                    System.out.println("Grade can not be minus!");
                    grade = 0;
                }else if (grade >= 13){
                    System.out.println("Grade has only 1 - 12!");
                    grade = 0;
                }
                System.out.println("\n");
            }catch (InputMismatchException inputMismatchException){
                input.next();
                System.out.println("Grade must be integer number, not string!, and greater than 0");
                grade = 0;
            }
        }while (grade == 0);
        System.out.println("Congratulation! Student information inserted into the list!");
    }
    void output(){
        System.out.println("Name: " + name );
        System.out.println ("ID: " + id );
        System.out.println ("Age: " + age );
        System.out.println ("Class: " + Class);
        System.out.println ("Score: " + score);
        System.out.println ("Grade: " + grade);
    }
    void gradedefined(int option){
        if (grade > 13 || grade < 0){
            System.out.println("Grade not available!");
            System.out.println("We only have grade 1 - 12");
            option = 0;
        }
    }
}
