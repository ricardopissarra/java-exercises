package com.amigoscode._4_datastructures._8_challenge;


import java.util.*;

public class DataStructureChallenge {

    static record Student(String name, int grade, String subject) {}

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 92, "Math"));
        students.add(new Student("Tom", 78, "Science"));
        students.add(new Student("Ricardo", 49, "English"));
        students.add(new Student("Jamila", 92, "Math"));
        students.add(new Student("Alex", 33, "Science"));
        students.add(new Student("Marie", 81, "English"));
        students.add(new Student("Mario", 12, "Math"));
        students.add(new Student("Bob", 50, "Science"));
        students.add(new Student("Nelson", 99, "English"));
        students.add(new Student("Ian", 97, "Math"));

        Map<String, List<Student>> mapBySubject = new HashMap<>();
        for (Student student : students) {
            mapBySubject.computeIfAbsent(student.subject, k -> new ArrayList<>()).add(student);
        }

        mapBySubject.entrySet()
                .forEach(e -> System.out.println("Subject: %s, students: %s".formatted(e.getKey(), e.getValue())));

        Set<String> uniqueSubjects = new HashSet<>();
        for (Student student : students) {
            uniqueSubjects.add(student.subject);
        }
        System.out.println(uniqueSubjects);


        Stack<Student> viewed = new Stack<>();
        Random random = new Random();
        viewed.add(students.get(random.nextInt(0, 9)));
        viewed.add(students.get(random.nextInt(0, 9)));
        viewed.add(students.get(random.nextInt(0, 9)));
        System.out.println(viewed.pop());
        System.out.println(viewed.pop());
        System.out.println(viewed.pop());

        students.sort(Comparator.comparingInt(Student::grade).reversed());

        System.out.println(students);
        System.out.println();
        System.out.println("""
                Summary report:
                Total number of students: %d
                Number of unique subjects: %d
                Highest grade student: %s""".formatted(
                        students.size(),
                uniqueSubjects.size(),
                students.get(0)
        ));
        System.out.println("Number of students per subject:");
        mapBySubject.entrySet().forEach(
                e -> System.out.println("- %s: %d".formatted(e.getKey(), e.getValue().size()))
        );

    }
}
