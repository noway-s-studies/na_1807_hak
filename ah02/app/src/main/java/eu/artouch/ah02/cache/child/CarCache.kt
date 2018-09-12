package eu.artouch.ah02.cache.child

import android.content.Context
import eu.artouch.ah02.NetAcademiaApplication
import eu.artouch.ah02.cache.BaseCache
import eu.artouch.ah02.entities.Car
import eu.artouch.ah02.entities.Manufacturer

class CarCache(context: Context) : BaseCache<Car>(
        (context.applicationContext as NetAcademiaApplication).boxStore.boxFor(Car::class.java)
)