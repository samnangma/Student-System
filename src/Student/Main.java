package Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> student = new ArrayList<>();
        Student defined = new Student();
        int option; int again;
        do {
            try {
                System.out.println("----------- Welcome to Student-management-system ------------");
                System.out.println("1. Select");
                System.out.println("2. Insert students");
                System.out.println("3. Update student's data");
                System.out.println("4. Remove students");
                System.out.println("5. Show all the students");
                System.out.println("6. Search information of student");
                System.out.println("7. Exit!");
                System.out.print("Input the number 1 - 6 : ");
                option = input.nextInt();
                switch (option) {
                    case 1 -> {
                        System.out.println("******************** Selecting student information ********************");
                        LinkedHashSet<String> Class = new LinkedHashSet<>();
                        LinkedHashSet<Integer> grade = new LinkedHashSet<>();
                        for (Student item : student) {
                            Class.add(item.Class);
                            grade.add(item.grade);
                        }
                        System.out.print ("All Classes: ");
                        for (String c : Class) {
                            System.out.print (c + " ");
                        }
                        System.out.println("\n");
                        System.out.print ("All Grade: ");
                        for (Integer i : grade) {
                            System.out.print (i + " ");
                        }
                        System.out.println("\n");
                        do {
                            System.out.println("1. select by class");
                            System.out.println("2. select by grade");
                            try {
                                System.out.println("Enter the options by number: ");
                                again = input.nextInt();
                            } catch (InputMismatchException inputMismatchException) {
                                input.next();
                                System.out.println("Should be integer!");
                                again = 0;
                            }
                            switch (again) {
                                case 1 -> {
                                    System.out.println("Select students by class : ");
                                    String input_class = input.next();
                                    for (Student value : student) {
                                        if (input_class.equals(value.Class)) {
                                            value.output();
                                            System.out.println("\n");
                                        }
                                    }
                                }
                                case 2 -> {
                                    System.out.println("Select students by grade : ");
                                    int input_grade = input.nextInt();
                                    for (Student value : student) {
                                        if (input_grade == value.grade) {
                                            value.output();
                                            System.out.println("\n");
                                        }
                                    }
                                }
                            }
                        }while (again == 0);
                    }
                    case 2 -> {
                        System.out.println("******************** insert Student information ********************");
                        Student obj = new Student();
                        obj.input(input);
                        student.add(obj);
                    }
                    case 3 -> {
                        int update;
                        System.out.println("******************** update student information ********************");
                        System.out.println("Enter Student ID: ");
                        String search_id = input.next();
                        for (Student value : student) {
                            if (value.id.equals(search_id)) {
                                do {
                                    System.out.println("1. Update score");
                                    System.out.println("2. Update grade");
                                    System.out.println("3. Update ID");
                                    System.out.print("Choose the option: "); update = input.nextInt();
                                    switch (update) {
                                        case 1 -> {
                                            System.out.println("Input new score: ");
                                            value.score = input.nextInt();
                                        }
                                        case 2 -> {
                                            System.out.println("Input new grade: ");
                                            value.grade = input.nextInt();
                                            defined.gradedefined(update);
                                        }
                                        case 3 -> {
                                            System.out.println("New ID: ");
                                            value.id = input.next();
                                        }
                                    }
                                }while (update == 0);
                            }
                        }
                    }
                    case 4 -> {
                        int remove_again;
                        System.out.println("******************** Remove student ********************");
                        System.out.println("1. Remove by ID");
                        System.out.println("2. Remove by Name");
                        try {
                            remove_again = input.nextInt();
                            if (remove_again > 2 || remove_again < 0){
                                System.out.println("Option not available!");
                            }
                        }catch (InputMismatchException inputMismatchException){
                            input.next();
                            System.out.println("It should be integer!");
                            remove_again = 0;
                        }
                        switch (remove_again) {
                            case 1 -> {
                                System.out.println("Enter student's ID: ");
                                String old_id = input.next();
                                student.removeIf(Student -> Student.id.equals(old_id));
                                System.out.println("Successfully deleted!");
                            }
                            case 2 -> {
                                System.out.println("Enter student's name: ");
                                String old_name = input.next();
                                student.removeIf(Student -> Student.name.equals(old_name));
                                System.out.println("Successfully deleted!");
                            }
                        }
                    }
                    case 5 -> {
                        System.out.println("******************** Student information ********************");
                        for (Student value : student) {
                            value.output();
                            System.out.println(" ");
                        }
                    }
                    case 6->{
                        // Search Student information:
                        int search_option;
                        do {
                            System.out.println("1. Search by name");
                            System.out.println("2. Search by id");
                            try {
                                search_option = input.nextInt();
                                if (search_option < 0 || search_option > 2) {
                                    System.out.println("option not available!");
                                }
                            } catch (InputMismatchException inputMismatchException) {
                                System.out.println("It should be integer!");
                                input.next();
                                search_option = 0;
                            }
                            switch (search_option){
                                case 1->{
                                    int check = 0;
                                    System.out.println("Enter student name: ");
                                    String search_name = input.next();
                                    for (Student value : student) {
                                        if (search_name.equals(value.name)){
                                            value.output();
                                            check = 1;
                                        }else{
                                            check = 0;
                                        }
                                    }
                                    if (check == 0){
                                        System.out.println("Name not found!");
                                    }
                                }
                                case 2->{
                                    int check = 0;
                                    System.out.println("Enter student id: ");
                                    String search_id = input.next();
                                    for (Student value : student) {
                                        if (search_id.equals(value.name)){
                                            value.output();
                                            check = 1;
                                        }else{
                                            check = 0;
                                        }
                                    }
                                    if (check == 0){
                                        System.out.println("Name not found!");
                                    }
                                }
                            }
                        }while (search_option == 0);
                    }
                    case 7-> System.out.println("******************** Thanks! ********************");
                }
            }catch (InputMismatchException mismatchException){
                input.next();
                System.out.println("Please try again! Should be integer!");
                option = 0;
            }
        } while (option!=7);
    }
}
