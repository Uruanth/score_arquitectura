package co.com.sofka.score.domain.course.events;

import co.com.sofka.score.domain.generic.DomainEvent;

public class LessonAdded extends DomainEvent {
    private final String lessonId;
    private final String name;

    @Override
    public String toString() {
        return "LessonAdded{" +
                "lessonId='" + lessonId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public LessonAdded(String id, String name) {
        super("sofkau.course.addLesson");
        this.lessonId = id;
        this.name = name;
    }

    public String getLessonId() {
        return lessonId;
    }

    public String getName() {
        return name;
    }
}
