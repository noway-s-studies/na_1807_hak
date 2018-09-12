package eu.artouch.ah02.cache

import io.objectbox.Box

abstract class BaseCache<T>(var box: Box<T>) : Cache<T> {

    override fun get(id: Long): T {
        return box.get(id)
    }

    override fun getAll(): List<T> {
        return box.all
    }

    override fun save(target: T) {
        box.put(target)
    }

    override fun saveAll(target: List<T>) {
        box.put(target)
    }

    override fun isEmpty(): Boolean {
        return box.count() == 0L
    }
}