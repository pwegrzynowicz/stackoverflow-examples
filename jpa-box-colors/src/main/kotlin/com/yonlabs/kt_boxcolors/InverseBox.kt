package com.yonlabs.kt_boxcolors

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Embeddable
class ColorId2(colorId: Int) : Serializable {

    constructor() : this(0)

    var id = colorId

    var locale = Locale.GERMAN
}

@Entity
class Color2(colorId2: ColorId2?) {

    constructor() : this(null)

    @EmbeddedId
    var colorId: ColorId2? = colorId2

    @ManyToOne
    @JoinColumn(name = "box_id")
    var box: Box2? = null
}

@Entity
@Table(name = "box")
class Box2(boxId: Int, colors: MutableList<Color2>) {

    constructor() : this(0, mutableListOf())

    @Id
    var id: Int? = boxId

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "box")
    var colors: MutableList<Color2> = colors
}

@Repository
interface Box2Repository : CrudRepository<Box2, Int>


