package eu.artouch.ah02.cache.child

import android.content.Context
import eu.artouch.ah02.NetAcademiaApplication
import eu.artouch.ah02.cache.BaseCache
import eu.artouch.ah02.entities.Type

class TypeCache(context: Context) : BaseCache<Type>(
        (context.applicationContext as NetAcademiaApplication).boxStore.boxFor(Type::class.java)
)