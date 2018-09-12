package eu.artouch.ah02



import android.app.Application
import eu.artouch.ah02.cache.child.CarCache
import eu.artouch.ah02.cache.child.ManufacturerCache
import eu.artouch.ah02.cache.child.TypeCache
import eu.artouch.ah02.entities.Car
import eu.artouch.ah02.entities.Manufacturer
import eu.artouch.ah02.entities.MyObjectBox
import eu.artouch.ah02.entities.Type
import io.objectbox.BoxStore

class NetAcademiaApplication : Application() {

    lateinit var boxStore: BoxStore

    override fun onCreate() {
        super.onCreate()
        boxStore = MyObjectBox.builder().androidContext(this).build()

        Thread(Runnable {
            initDb()
        }).start()
    }

    private fun initDb() {
        if (ManufacturerCache(this).isEmpty()) {
            ManufacturerCache(this).save(Manufacturer("Porsche", 1931))
            ManufacturerCache(this).save(Manufacturer("Ford", 1903))
        }

        if (TypeCache(this).isEmpty()) {
            TypeCache(this).save(Type("3.6", "911", 1))
            TypeCache(this).save(Type("1.6", "Focus", 2))
        }

        if (CarCache(this).isEmpty()) {
            CarCache(this).save(Car("piros", 1))
            CarCache(this).save(Car("kék", 2))
        }
    }
}