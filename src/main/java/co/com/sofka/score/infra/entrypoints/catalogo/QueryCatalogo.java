package co.com.sofka.score.infra.entrypoints.catalogo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/api/catalogo")
public class QueryCatalogo {

    private final MongoClient mongoClient;

    public QueryCatalogo(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response get(@PathParam("id") String programId) {
        List<Document> documentList = new ArrayList<>();
        mongoClient.getDatabase("queries")
                .getCollection("catalogo")
                .find(Filters.eq("_id", programId))
                .forEach(documentList::add);
        return Response.ok(documentList).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
   // @Path("/catalogo")
    public Response get() {
        List<Document> documentList = new ArrayList<>();
        mongoClient.getDatabase("queries")
                .getCollection("catalogo")
                .find()
                .forEach(documentList::add);
        return Response.ok(documentList).build();
    }

}
