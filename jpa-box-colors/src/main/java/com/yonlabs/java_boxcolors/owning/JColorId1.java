package com.yonlabs.java_boxcolors.owning;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Locale;

@Embeddable
public
class JColorId1 implements Serializable {

    int id;

    Locale locale = Locale.GERMAN;

    public JColorId1() {
    }

    public JColorId1(int id) {
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
