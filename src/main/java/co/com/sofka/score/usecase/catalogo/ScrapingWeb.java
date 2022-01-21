package co.com.sofka.score.usecase.catalogo;

import co.com.sofka.score.domain.catalogo.Catalogo;
import co.com.sofka.score.domain.catalogo.command.ScrapingWebComando;
import co.com.sofka.score.domain.generic.DomainEvent;
import co.com.sofka.score.domain.generic.EventStoreRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.enterprise.context.Dependent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Dependent
public class ScrapingWeb  implements Function<ScrapingWebComando, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public ScrapingWeb(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(ScrapingWebComando command) {
        var events = repository.getEventsBy("course", command.getCatalogoId());
        var catalogo = Catalogo.from(command.getCatalogoId(), events);

        System.out.println(command.getCatalogoId());

        catalogo.scrapingWeb(scraping(command.getUrl()));
        return catalogo.getUncommittedChanges();
    }

    private List<String> scraping(String url){
        Document html = null;
        ArrayList<String> lista = new ArrayList<>();
        try {
            html = Jsoup.connect(url).get();
            Elements ele = html.select("#tab-1 > ul > li > div > a > h2");
            for(Element e: ele){
                lista.add(e.text());
            }

        } catch (Exception e) {
            System.out.println("error");
        }
        return lista;
    }
}
