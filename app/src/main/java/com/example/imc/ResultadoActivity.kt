package com.example.imc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imc.databinding.ActivityMainBinding
import com.example.imc.databinding.ActivityResultadoBinding
import java.text.DecimalFormat

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        processarResultado()

        binding.btnVoltar.setOnClickListener{
            finish()
        }
    }

    private fun processarResultado(){
        val nome = intent.getStringExtra("nome")
        val imc = intent.getDoubleExtra("imc",0.0)
        val peso = intent.getDoubleExtra("peso",0.0)
        val altura = intent.getDoubleExtra("altura",0.0)

        binding.txtNome.text = nome
        val formatador = DecimalFormat("#0.00")
        binding.txtResultadoImc.text = "IMC: ${formatador.format(imc)}"
        binding.txtResultadoPeso.text = "Peso: ${formatador.format(peso)}"
        binding.txtResultadoAltura.text = "Altura: ${formatador.format(altura)}"

        when {
            imc <= 18.5 ->{
                binding.txtResultadoImcStatus.text = "Abaixo do peso"
            }
            imc <= 24.9 ->{
                binding.txtResultadoImcStatus.text = "Peso normal"
            }
            imc <= 29.9 ->{
                binding.txtResultadoImcStatus.text = "Sobrepeso"
            }
            imc <= 34.9 ->{
                binding.txtResultadoImcStatus.text = "Obesidade 1"
            }
            imc >= 40.0 ->{
                binding.txtResultadoImcStatus.text = "Obesidade 3"
            }

        }

    }
}