package com.yonlabs.java_boxcolors.owning;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class JColor1 {

    @EmbeddedId
    JColorId1 colorId;

    public JColorId1 getColorId() {
        return colorId;
    }

    public void setColorId(JColorId1 colorId) {
        this.colorId = colorId;
    }

    public JColor1() {
    }

    public JColor1(JColorId1 colorId) {
        this.colorId = colorId;
    }

}
