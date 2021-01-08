package com.yonlabs.java_boxcolors.inverse;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Locale;

@Embeddable
public
class JColorId2 implements Serializable {

    int id;

    Locale locale = Locale.GERMAN;

    public JColorId2() {
    }

    public JColorId2(int id) {
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
