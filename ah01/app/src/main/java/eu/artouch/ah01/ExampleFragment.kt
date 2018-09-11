package eu.artouch.ah01

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class ExampleFragment : Fragment() {

    companion object {
        val ID_TAG: String = ExampleFragment::class.java.simpleName

        val SAVED_TEXT: String = "Saved text"
    }

    @JvmField
    @BindView(R.id.button1)
    var button: Button? = null

    @JvmField
    @BindView(R.id.text_field_1)
    var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState?.getString(SAVED_TEXT)?.let { savedText ->
            editText?.setText(savedText, TextView.BufferType.EDITABLE)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_example, container, false)

        ButterKnife.bind(this, view)
        button?.setOnClickListener({ Toast.makeText(requireContext(), "Szia!", Toast.LENGTH_SHORT).show() })

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        editText?.let {
            outState.putString(SAVED_TEXT, editText!!.text.toString())
        }

        super.onSaveInstanceState(outState)
    }

    @OnClick(R.id.button1)
    fun onButtonClickEvent() {
        Toast.makeText(requireContext(), "Üdv butterknife!", Toast.LENGTH_SHORT).show()
    }
}