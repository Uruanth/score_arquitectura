package co.com.sofka.score.domain.course;

import co.com.sofka.score.domain.course.events.CourseCreated;
import co.com.sofka.score.domain.course.events.LessonAdded;
import co.com.sofka.score.domain.generic.AggregateRoot;
import co.com.sofka.score.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;

public class Course extends AggregateRoot  {

    protected Map<String, Lesson> lessons;
    protected String name;

    public Course(String id, String name) {
        super(id);
        subscribe(new CourseChange(this));
        appendChange(new CourseCreated(id, name)).apply();
    }

    private Course(String id){
        super(id);
        subscribe(new CourseChange(this));
    }

    public static Course from(String courseId, List<DomainEvent> events) {
        var course = new Course(courseId);
        events.forEach(course::applyEvent);
        return course;
    }

    public void addLesson(String id, String name) {
        appendChange(new LessonAdded(id, name)).apply();
    }

    public void addStudent(String lessonId, String name, String email) {
        this.lessons.get(lessonId).addStudent(name, email);
    }

    public void evaluationStudent(String lessonId, String email, Score score) {
        this.lessons.get(lessonId).evaluationStudent(email, score);
    }

    @Override
    public String toString() {
        return "Course{" +
                "lessons=" + lessons +
                ", name='" + name + '\'' +
                '}';
    }

    public Lesson findLesson(String id) {
        return this.lessons.get(id);
    }
}
