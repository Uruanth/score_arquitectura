package co.com.sofka.score.domain.catalogo.OV;

import java.util.Objects;

public class Url {

    private final String value;

    public Url(String value) {
        this.value = Objects.requireNonNull(value);
    }

    public String value() {
        return value;
    }
}
