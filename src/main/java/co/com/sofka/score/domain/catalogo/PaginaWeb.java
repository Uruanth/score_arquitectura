package co.com.sofka.score.domain.catalogo;

import co.com.sofka.score.domain.catalogo.OV.Url;

import java.util.Objects;

public final class PaginaWeb {

    private final String id;
    private Url url;

    public PaginaWeb(String id, Url url) {
        this.id = Objects.requireNonNull(id);
        this.url = Objects.requireNonNull(url);
    }

    private PaginaWeb(String id){
        this.id = Objects.requireNonNull(id);
    }


}
