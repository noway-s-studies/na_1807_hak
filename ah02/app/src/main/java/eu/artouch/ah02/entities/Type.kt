package eu.artouch.ah02.entities

import io.objectbox.annotation.Backlink
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne

@Entity
class Type(
        @Id var id: Long = 0,
        var engineType: String,
        var name: String,
        var manufacturerId: Long
) {

    init {
        this.manufacturer.targetId = manufacturerId
    }

    constructor(engineType: String, name: String, manufacturerId: Long) : this(0, engineType, name, manufacturerId) {
        this.manufacturer.targetId = manufacturerId
    }

    @Backlink
    lateinit var manufacturer: ToOne<Manufacturer>
}

