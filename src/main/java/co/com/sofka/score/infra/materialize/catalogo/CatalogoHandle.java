package co.com.sofka.score.infra.materialize.catalogo;

import co.com.sofka.score.domain.catalogo.events.CatalogoCreado;
import co.com.sofka.score.domain.catalogo.events.ScrapeandoWeb;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import io.quarkus.vertx.ConsumeEvent;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;


@ApplicationScoped
public class CatalogoHandle {

    private final MongoClient mongoClient;

    public CatalogoHandle(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }


    @ConsumeEvent(value = "sofkau.peliculas.creada", blocking = true)
    void consumeCatalogoCreado(CatalogoCreado event) {
        Map<String, Object> document = new HashMap<>();
        document.put("_id", event.getAggregateId());
        document.put("pagina", event.getNombre());

        mongoClient.getDatabase("queries")
                .getCollection("catalogo")
                .insertOne(new Document(document));
    }


    @ConsumeEvent(value = "sofkau.catalogo.scrapeando", blocking = true)
    void consumeScrapeando(ScrapeandoWeb event) {
        BasicDBObject document = new BasicDBObject();
        document.put("pelis."+event.getAggregateId()+".name", event.getPelis());

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", document);

        mongoClient.getDatabase("queries")
                .getCollection("catalogo")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);

    }

}


