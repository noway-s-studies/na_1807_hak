package eu.artouch.ah02.cache

interface Cache<T> {

    fun get(id: Long): T
    fun getAll(): List<T>

    fun save(target: T)
    fun saveAll(target: List<T>)

    fun isEmpty() : Boolean
}