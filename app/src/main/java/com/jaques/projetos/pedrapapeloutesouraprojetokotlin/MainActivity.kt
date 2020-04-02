package com.jaques.projetos.pedrapapeloutesouraprojetokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun rocksSelected(view: View) {
        this.selectOption("pedra")
    }

    fun paperSelected(view: View) {
        this.selectOption("papel")

    }

    fun scissorSelected(view: View) {
        this.selectOption("tesoura")
    }

    fun selectOption(chooseUser: String) {
        val imagemResultado: ImageView = padrao
        val textoResultado: TextView = textResultado

        val number: Int = nextInt(3)
        val options =
            listOf("pedra", "papel", "tesoura") // 0 1 2   ->pedra 0 ->papel 1 -> tesouro 2
        val chooseApp = options[number]

        when (chooseApp) {
            "pedra" -> imagemResultado.setImageResource(R.drawable.pedra)
            "papel" -> imagemResultado.setImageResource(R.drawable.papel)
            "tesoura" -> imagemResultado.setImageResource(R.drawable.tesoura)
        }

        val vocePerdeu: String = "Você Perdeu"
        val voceGanhou: String = "Você ganhou!!"
        val empate: String = "Nós empatamos! "

        when {
            chooseApp == "tesoura" && chooseUser == "papel" ||
            chooseApp == "papel" && chooseUser == "pedra" ||
            chooseApp == "pedra" && chooseUser == "tesoura" -> {//App ganhador
            textoResultado.setText(vocePerdeu);
            }
            chooseUser == "tesoura" && chooseApp == "papel" ||
            chooseUser == "papel" && chooseApp == "pedra" ||
            chooseUser == "pedra" && chooseApp == "tesoura" -> {//Usuario ganhador
            textoResultado.setText(voceGanhou);
            }
            else -> {//Empate
                textoResultado.setText(empate);
            }
        }
        System.out.println("item clicado: " + chooseApp);
    }
}
