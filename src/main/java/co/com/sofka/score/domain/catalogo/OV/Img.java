package co.com.sofka.score.domain.catalogo.OV;

import java.util.Objects;

public class Img {

    private final String value;

    public Img(String value) {
        this.value = Objects.requireNonNull(value);
    }

    public String value() {
        return value;
    }
}
