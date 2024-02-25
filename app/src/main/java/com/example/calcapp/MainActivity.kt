package com.example.calcapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calcapp.databinding.ActivityMainBinding
import com.example.calcapp.ui.theme.CalcAppTheme
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {

    lateinit var bindingClass: ActivityMainBinding

    var opp: Double = 0.0
    var adj: Double = 0.0
    var hyp: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    private fun isFieldsEmpty(): Boolean{
        bindingClass.apply {
            if (edOpposite.text.isNullOrEmpty()) {
                edOpposite.error = "Field is Empty!"
            }
            if (edAdjacent.text.isNullOrEmpty()) {
                edAdjacent.error = "Field is Empty!"
            }
            return edOpposite.text.isNullOrEmpty() || edAdjacent.text.isNullOrEmpty()
        }
    }

    private fun calc(): String{
        bindingClass.apply {
            opp = edOpposite.text.toString().toDouble()
            adj = edAdjacent.text.toString().toDouble()
            return sqrt((opp.pow(2)) + (adj.pow(2))).toString()
        }
    }

    fun onClickCalculate(view: View){
        if (!isFieldsEmpty()){
            hyp = getString(R.string.result_info) + calc()
            bindingClass.tvResult.text = hyp
        }

    }
}