package com.yonlabs.java_boxcolors.inverse;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JColor2 {

    @EmbeddedId
    JColorId2 colorId;

    @ManyToOne
    @JoinColumn(name = "box_id")
    JBox2 box;

    public JColor2() {
    }

    public JColor2(JColorId2 colorId) {
        this.colorId = colorId;
    }

    public JColorId2 getColorId() {
        return colorId;
    }

    public void setColorId(JColorId2 colorId) {
        this.colorId = colorId;
    }

    public JBox2 getBox() {
        return box;
    }

    public void setBox(JBox2 box) {
        this.box = box;
    }

}
