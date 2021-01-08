package com.yonlabs.java_boxcolors.inverse;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JBox2 {

    @Id
    Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "box")
    List<JColor2> colors = new ArrayList<>();

    public JBox2() {
    }

    public JBox2(Integer id, List<JColor2> colors) {
        this.id = id;
        this.colors = colors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<JColor2> getColors() {
        return colors;
    }

    public void setColors(List<JColor2> colors) {
        this.colors = colors;
    }

}
