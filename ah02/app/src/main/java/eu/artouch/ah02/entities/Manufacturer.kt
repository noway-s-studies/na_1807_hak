package eu.artouch.ah02.entities

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class Manufacturer(
        @Id var id: Long = 0,
        var name: String,
        var foundationYear: Int
) {

    constructor(name: String, foundationDate: Int) : this(0, name, foundationDate)
}

