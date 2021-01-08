package com.yonlabs.kt_boxcolors

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Embeddable
class ColorId1(colorId: Int) : Serializable {

    constructor() : this(0)

    var id = colorId

    var locale = Locale.GERMAN

}

@Entity
class Color1(colorId1: ColorId1?) {

    constructor() : this(null)

    @EmbeddedId
    var colorId: ColorId1? = colorId1
}

@Entity
class Box1(id: Int, colors: MutableList<Color1>) {

    constructor() : this(0, mutableListOf())

    @Id
    var id: Int? = id

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "box_id", referencedColumnName = "id")
    var colors: MutableList<Color1> = colors

}

@Repository
interface Box1Repository : CrudRepository<Box1, Int>

