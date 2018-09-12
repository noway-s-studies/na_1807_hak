package eu.artouch.ah02.mapper

import eu.artouch.ah02.entities.Car

class ColorMapper : Mapper<Car> {

    override fun transformToStringList(target: List<Car>): List<String> {
        return target.map { car ->
            car.color
        }
    }
}

