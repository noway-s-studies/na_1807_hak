package eu.artouch.ah02.mapper

import eu.artouch.ah02.entities.Type

class TypeMapper : Mapper<Type> {

    override fun transformToStringList(target: List<Type>): List<String> {
        return target.map { type ->
            type.name
        }
    }

    fun transformEngineTypeToStringList(target: List<Type>): List<String> {
        return target.map { type ->
            type.engineType
        }
    }
}

