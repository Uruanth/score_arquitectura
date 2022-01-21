package co.com.sofka.score.domain.course.events;

import co.com.sofka.score.domain.generic.DomainEvent;

public class CourseCreated extends DomainEvent {
    private final String courseId;
    private final String name;

    public CourseCreated(String id, String name) {
        super("sofkau.course.create");
        this.courseId = id;
        this.name = name;
    }

    @Override
    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }
}
