package co.com.sofka.score.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Lesson {
    private final String id;
    private String name;
    private final Map<String, Student> student;

    public Lesson(String id, String name) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.student = new HashMap<>();
    }

    public void addStudent(String name, String email) {
        this.student.put(email, new Student(name, email));
    }


    public void evaluationStudent(String email, Score score) {
        this.student.get(email).eval(score);
    }

    public String id() {
        return id;
    }

    public Map<String, Student> student() {
        return student;
    }

    public String name() {
        return name;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
