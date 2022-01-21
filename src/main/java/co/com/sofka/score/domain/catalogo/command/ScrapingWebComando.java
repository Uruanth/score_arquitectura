package co.com.sofka.score.domain.catalogo.command;

import co.com.sofka.score.domain.generic.Command;

public class ScrapingWebComando extends Command {
    private String catalogoId;
    private String url;

    public String getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(String catalogoId) {
        this.catalogoId = catalogoId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
