package thread.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("1", "s1", 0));
        list.add(new Student("2", "s1", 2));
        list.add(new Student("2", "s1", 3));
        list.add(new Student("2", "s1", 2));
        list.add(new Student("2", "s1", 4));
        list.add(new Student("3", "s1", 2));
        list.add(new Student("3", "s1", 2));
        list.add(new Student("3", "s1", 2));
        list.add(new Student("3", "s1", 2));
        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getClassName));
        for (Map.Entry<String, List<Student>> entry : map.entrySet()) {
            List<Student> studentList = entry.getValue();
            studentList = studentList.stream()
                    .sorted(Comparator.comparingInt(s -> s.getScore() * -1))
                    .limit(3)
                    .collect(Collectors.toList());
            entry.setValue(studentList);
        }
    }
}
