import java.util.ArrayList;

/**
 * Created by David Stovlbaek on 15/09/16.
 */
public class RunProgram {

    public static void main(String[] args) {

        ArrayList<Student> studentList = new ArrayList<Student>();
        String[] names = new String[]{"David", "Jack", "Steve", "Mark", "Bill"};

        for(int i = 0; i < 5; i++){
        studentList.add(new Student(names[i], i+1, i+1*20));
        }

        studentList.add(new Student("David", 1, 20));

        System.out.println(studentList);

        print(new Student("Hej", 10, 100));
        print("Hej 2");

        checkIfEquals(studentList);

    }

    public static <Boris> void print(Boris students){
        System.out.println(students);
    }

    public static void checkIfEquals(ArrayList<?> list){
        for(int i = 0; i < list.size(); i++){
            if(list.size() > i+1){
                for(int k = 0; k < list.size(); k++){
                if(k != i && list.get(i).equals(list.get(k))){
                    System.out.println(list.get(i));
                    i++;
                }
                }
            }
        }
    }

}
