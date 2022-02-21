package by.it.yushkevich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    public static final int MAX_COUNT = 30;
    public static final int MAX_GRADE = 10;
    private List<Integer> grades = new ArrayList<>();


    public static void main(String[] args) {
        Random random = new Random();
        TaskA1 instance = new TaskA1();// нужен экзепляр класса
        int n = MAX_COUNT / 2 + random.nextInt(MAX_COUNT / 2 + 1);
        for (int i = 0; i < n; i++) {
            int grade = random.nextInt(MAX_GRADE + 1);
            instance.grades.add(grade);

        }
        System.out.println(instance.grades);
        instance.clearBad(instance.grades);
        System.out.println(instance.grades);

    }

    private void clearBad(List<Integer> grades) {

        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Integer grade = iterator.next();
            if (grade < 4) {
                iterator.remove();
            }
        }


    }


}
