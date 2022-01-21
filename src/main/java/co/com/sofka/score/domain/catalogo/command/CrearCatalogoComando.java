package co.com.sofka.score.domain.catalogo.command;

import co.com.sofka.score.domain.generic.Command;

public class CrearCatalogoComando extends Command {
    @Override
    public String toString() {
        return "CrearCatalogoComando{" +
                "catalogoId='" + catalogoId + '\'' +
                ", pagina='" + pagina + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    private String catalogoId;
    private String pagina;
    private String nombre;

    public String getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(String catalogoId) {
        this.catalogoId = catalogoId;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
