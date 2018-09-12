package eu.artouch.ah02.ui



import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import eu.artouch.ah02.R
import eu.artouch.ah02.cache.child.CarCache
import eu.artouch.ah02.cache.child.ManufacturerCache
import eu.artouch.ah02.cache.child.TypeCache
import eu.artouch.ah02.mapper.ColorMapper
import eu.artouch.ah02.mapper.ManufacturerMapper
import eu.artouch.ah02.mapper.TypeMapper
import eu.artouch.ah02.settings.SettingsFragment
import eu.artouch.ah02.settings.SettingsPreferences

class OrderActivity : AppCompatActivity() {

    @JvmField
    @BindView(R.id.order_container)
    var orderContainer: ConstraintLayout? = null

    @JvmField
    @BindView(R.id.order_manufacturer_name)
    var manufacturerSpinner: Spinner? = null

    @JvmField
    @BindView(R.id.order_type_name)
    var typeNameSpinner: Spinner? = null

    @JvmField
    @BindView(R.id.order_type_engine)
    var engineTypeSpinner: Spinner? = null

    @JvmField
    @BindView(R.id.order_color)
    var colorSpinner: Spinner? = null

    @JvmField
    @BindView(R.id.order_settings)
    var settingsButton: Button? = null

    @JvmField
    @BindView(R.id.order_button)
    var orderButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        ButterKnife.bind(this)

        initializeSpinners()
        initListeners()
        setOrderButtonVisibility()
    }

    private fun initializeSpinners() {
        val manufacturers = ManufacturerMapper().transformToStringList(ManufacturerCache(this@OrderActivity).getAll()).toTypedArray()
        manufacturerSpinner?.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, manufacturers)

        val types = TypeMapper().transformToStringList(TypeCache(this@OrderActivity).getAll()).toTypedArray()
        typeNameSpinner?.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, types)

        val engineTypes = TypeMapper().transformEngineTypeToStringList(TypeCache(this@OrderActivity).getAll()).toTypedArray()
        engineTypeSpinner?.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, engineTypes)

        val colors = ColorMapper().transformToStringList(CarCache(this@OrderActivity).getAll()).toTypedArray()
        colorSpinner?.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, colors)
    }

    private fun initListeners() {
        settingsButton?.setOnClickListener {
            supportFragmentManager.beginTransaction().add(android.R.id.content, SettingsFragment(), SettingsFragment.ID_TAG).addToBackStack(SettingsFragment.ID_TAG).commit()
            orderContainer?.visibility = View.GONE
        }

        orderButton?.setOnClickListener {
            Toast.makeText(this@OrderActivity, "Ordered!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setOrderButtonVisibility() {
        when {
            SettingsPreferences().getOrderButtonAllowed(this) -> orderButton?.visibility = View.VISIBLE
            else -> orderButton?.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        supportFragmentManager.popBackStack()
        orderContainer?.visibility = View.VISIBLE
        setOrderButtonVisibility()
    }
}

