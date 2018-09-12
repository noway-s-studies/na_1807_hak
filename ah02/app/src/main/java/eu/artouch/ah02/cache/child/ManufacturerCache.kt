package eu.artouch.ah02.cache.child

import android.content.Context
import eu.artouch.ah02.NetAcademiaApplication
import eu.artouch.ah02.cache.BaseCache
import eu.artouch.ah02.entities.Manufacturer


class ManufacturerCache(context: Context) : BaseCache<Manufacturer>(
        (context.applicationContext as NetAcademiaApplication).boxStore.boxFor(Manufacturer::class.java)
)