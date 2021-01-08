package com.yonlabs.boxcolors;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Locale;

@Embeddable
class ColorId implements Serializable {

    int id;

    Locale locale = Locale.GERMAN;

    public ColorId() {
    }

    public ColorId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
