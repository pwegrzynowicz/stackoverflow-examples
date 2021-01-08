package com.yonlabs.boxcolors;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class Color {

    @EmbeddedId
    ColorId colorId;

    public ColorId getColorId() {
        return colorId;
    }

    public void setColorId(ColorId colorId) {
        this.colorId = colorId;
    }

}
