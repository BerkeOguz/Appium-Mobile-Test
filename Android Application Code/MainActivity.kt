package com.example

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    // global variables that represent the regarding fields
    lateinit var frstNm: EditText
    lateinit var surNm: EditText
    lateinit var birthDt: EditText
    lateinit var sndBtn: Button
    lateinit var maleRdio: RadioButton
    lateinit var femaleRdio: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // local variables that represent the regarding fields
        frstNm = findViewById(R.id.firstnameText) as EditText
        surNm = findViewById(R.id.surnameText) as EditText
        birthDt = findViewById(R.id.birthdateText) as EditText
        val city: Spinner = findViewById(R.id.citiesSpinner) as Spinner
        maleRdio = findViewById(R.id.maleRadio) as RadioButton
        femaleRdio = findViewById(R.id.femaleRadio) as RadioButton
        val vaccine: Spinner = findViewById(R.id.vaccineSpinner) as Spinner
        val feverCheckbx: CheckBox = findViewById(R.id.feverCheckbox) as CheckBox
        val nauseaCheckbx: CheckBox = findViewById(R.id.nauseaCheckbox) as CheckBox
        val painCheckbx: CheckBox = findViewById(R.id.painCheckbox) as CheckBox
        val tirednessCheckbx: CheckBox = findViewById(R.id.tirednessCheckbox) as CheckBox
        val chillsCheckbx: CheckBox = findViewById(R.id.chillsCheckbox) as CheckBox
        val swellingCheckbx: CheckBox = findViewById(R.id.swellingCheckbox) as CheckBox
        val alertTxt: TextView = findViewById(R.id.alertText) as TextView
        sndBtn = findViewById(R.id.sendButton) as Button


        // regex to check whether the given name/surname is valid or not
        val nmPttrn: Pattern = Pattern.compile("^[A-Za-z]+$")

        // regex to check whether the given birth date is valid or not in the formats: dd/mm/yyyy, dd.mm.yyyy, dd-mm-yyyy
        val datePttrn: Pattern = Pattern.compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)" +
                "(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})\$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?" +
                "(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))\$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)" +
                "(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})\$")

        // text watchers to see whether the inputs are empty or not
        // and determine to activate or deactivate the send button
        frstNm.addTextChangedListener(textWatcher)
        surNm.addTextChangedListener(textWatcher)
        birthDt.addTextChangedListener(textWatcher)

        sndBtn.isEnabled = false
        maleRdio.isChecked = true

        // send button's click listener method
        sndBtn.setOnClickListener{
            // checks if the names and birth date is matching the initialized regexes or not
            // and thus determines the validity of the inputs
            if (!nmPttrn.matcher(frstNm.text.toString()).matches() || !nmPttrn.matcher(surNm.text.toString()).matches() ||
                    !datePttrn.matcher(birthDt.text.toString()).matches()){
                alertTxt.setText("Please give a valid name/birthdate!")
                alertTxt.postDelayed(Runnable { alertTxt.setText("Please fill all of the fields.") }, 2500)
            }
            // sends the survey if everything is in order
            else{
                alertTxt.setText("YOUR SURVEY HAS BEEN SENT!")
                alertTxt.postDelayed(Runnable { alertTxt.setText("Please fill all of the fields.") }, 2500)
                frstNm.setText("")
                surNm.setText("")
                birthDt.setText("")
                city.setSelection(0)
                maleRdio.isChecked = true
                femaleRdio.isChecked = false
                vaccine.setSelection(0)
                feverCheckbx.isChecked = false
                nauseaCheckbx.isChecked = false
                painCheckbx.isChecked = false
                tirednessCheckbx.isChecked = false
                chillsCheckbx.isChecked = false
                swellingCheckbx.isChecked = false
            }
        }
    }

    // text watcher structure to check the emptiness of the input fields
    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            var frstNmInput = frstNm.text.toString().trim()
            var surNmInput = surNm.text.toString().trim()
            var birthDtInput = birthDt.text.toString().trim()

            sndBtn.isEnabled = (!frstNmInput.isEmpty() && !surNmInput.isEmpty() &&
                    !birthDtInput.isEmpty() && maleRdio.isChecked != femaleRdio.isChecked )
        }
        override fun afterTextChanged(s: Editable?) {
        }
    }
}