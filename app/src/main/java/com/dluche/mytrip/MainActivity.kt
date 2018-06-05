package com.dluche.mytrip

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        btnCalculate.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        val id = v.id
        //
        if(id ==  R.id.btnCalculate){
            handleCalculate()
        }
    }

    private fun handleCalculate() {
            if(isValid()){
                try{
                    //(distancia * preco) / autonomia
                    val distance = etDistance.text.toString().toFloat()
                    val price = etPrice.text.toString().toFloat()
                    val autonomy = etAutonomy.text.toString().toFloat()
                    //
                    val result = ((distance * price) / autonomy)
                    //
                    tvResult.text = "Total: R$ $result"

                }catch (nfe: NumberFormatException){
                    Toast.makeText(this,getString(R.string.valores_invalidos),Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this,getString(R.string.valores_invalidos),Toast.LENGTH_LONG).show()
            }
    }

    private fun isValid(): Boolean{
        return !etDistance.text.toString().trim().isEmpty()
               && !etPrice.text.toString().trim().isEmpty()
               && !etAutonomy.text.toString().trim().isEmpty()
               && etAutonomy.text.toString() != "0"
    }


}
