package co.com.sofka.score.domain.course;

import co.com.sofka.score.domain.course.events.CourseCreated;
import co.com.sofka.score.domain.course.events.LessonAdded;
import co.com.sofka.score.domain.generic.EventChange;

import java.util.HashMap;

public class CourseChange implements EventChange {
    public CourseChange(Course course) {

        listener((CourseCreated event) -> {
            course.name = event.getName();
            course.lessons = new HashMap<>();
        });

        listener((LessonAdded event) -> {
            course.lessons.put(event.getLessonId(),
                    new Lesson(event.getLessonId(), event.getName()));
        });

    }
}
