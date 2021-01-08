package com.yonlabs.boxcolors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "box")
public class Box {

    @Id
    Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "box_id", referencedColumnName = "id")
    List<Color> colors = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

}
