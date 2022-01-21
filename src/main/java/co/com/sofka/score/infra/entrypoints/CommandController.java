package co.com.sofka.score.infra.entrypoints;

import co.com.sofka.score.domain.course.command.AddLessonCommand;
import co.com.sofka.score.domain.course.command.ConfigureCourse;
import io.vertx.core.eventbus.EventBus;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/api")
public class CommandController {

        private final EventBus bus;

        public CommandController(EventBus bus) {
            this.bus = bus;
        }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Path("/create")
        public Response executor(ConfigureCourse command){
            bus.publish(command.getType(), command);
            return Response.ok().build();
        }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Path("/addLesson")
        public Response executor(AddLessonCommand command){
            bus.publish(command.getType(), command);
            return Response.ok().build();
        }

}
