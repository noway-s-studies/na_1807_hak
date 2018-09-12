package eu.artouch.ah02.mapper

interface Mapper<T> {

    fun transformToStringList(target: List<T>): List<String>
}

