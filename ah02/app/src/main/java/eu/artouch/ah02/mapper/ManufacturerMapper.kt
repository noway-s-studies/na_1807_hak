package eu.artouch.ah02.mapper

import eu.artouch.ah02.entities.Manufacturer

class ManufacturerMapper : Mapper<Manufacturer> {

    override fun transformToStringList(target: List<Manufacturer>): List<String> {
        return target.map { manufacturer ->
            manufacturer.name
        }
    }
}

