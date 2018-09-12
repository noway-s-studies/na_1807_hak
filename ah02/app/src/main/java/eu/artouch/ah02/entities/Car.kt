package eu.artouch.ah02.entities

import io.objectbox.annotation.Backlink
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne

@Entity
class Car(
        @Id var id: Long = 0,
        var color: String,
        var typeId: Long
) {

    init {
        type.targetId = typeId
    }

    constructor(color: String, typeId: Long) : this(0, color, typeId) {
        type.targetId = typeId
    }

    @Backlink
    lateinit var type: ToOne<Type>
}

