package co.com.sofka.score.domain.catalogo.OV;

import java.util.Objects;

public class Nombre {

    private final String value;

    public Nombre(String value) {
        this.value = Objects.requireNonNull(value);
    }

    public String value() {
        return value;
    }

}
