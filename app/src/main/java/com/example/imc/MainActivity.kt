package com.example.imc

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener{
            calculaIMC()
        }
    }
    private fun calculaIMC(){
        val nome = binding.edtNome.text.toString()
        val altura = binding.edtAltura.text.toString().toDouble()
        val peso =binding.edtPeso.text.toString().toDouble()
        val imc = peso/(altura*altura)
        navegarParaTelaResultado(nome, imc,peso,altura)
    }

    private fun navegarParaTelaResultado(nome:String,imc:Double,peso:Double,altura:Double){
        val intent = Intent(this,ResultadoActivity::class.java)
        intent.putExtra("nome",nome)
        intent.putExtra("imc",imc)
        intent.putExtra("peso",peso)
        intent.putExtra("altura",altura)
        startActivity(intent)

    }
}