package com.yonlabs.java_boxcolors.owning;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JBox1 {

    @Id
    Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "box_id", referencedColumnName = "id")
    List<JColor1> colors = new ArrayList<>();

    public JBox1() {
    }

    public JBox1(Integer id, List<JColor1> colors) {
        this.id = id;
        this.colors = colors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<JColor1> getColors() {
        return colors;
    }

    public void setColors(List<JColor1> colors) {
        this.colors = colors;
    }

}
