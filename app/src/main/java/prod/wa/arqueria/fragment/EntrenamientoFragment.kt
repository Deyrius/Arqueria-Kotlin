package prod.wa.arqueria.fragment

import android.os.Bundle
import android.util.Log
//import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import prod.wa.arqueria.R
import prod.wa.arqueria.viewmodel.EntrenamientoViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.Fragment


class EntrenamientoFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view: View = inflater.inflate(R.layout.activity_entrenamiento2,container,false)
       return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val evm = ViewModelProvider(this).get(EntrenamientoViewModel::class.java)
        val boton : Button = view.findViewById(R.id.e_btn)
        val flecha1 : EditText = view.findViewById(R.id.e_flecha_1)
        var flecha1Valor : Int
        val flecha2 : EditText = view.findViewById(R.id.e_flecha_2)
        var flecha2Valor : Int
        val flecha3 : EditText = view.findViewById(R.id.e_flecha_3)
        var flecha3Valor : Int
        val resultado: TextView =  view.findViewById(R.id.e_txt_e_resultado)
        var resultadoValor : Int
        var rondas : TextView = view.findViewById(R.id.e_txt_rondas)
        var rondaActual : Int
        var total : Double = 0.0
        var promedio : Double
        val promedioTexto : TextView = view.findViewById(R.id.e_txt_promedio)
        val totalTexto : TextView = view.findViewById(R.id.e_txt_total)
        var promedioNumero : TextView = view.findViewById(R.id.e_txt_e_promedio)
        var sumaNumero : TextView = view.findViewById(R.id.e_txt_e_total)

        boton.setOnClickListener {
            try {
                flecha1Valor =  if(flecha1.text.toString().isNullOrBlank() || flecha1.text.toString().toInt() > 10)throw IllegalArgumentException() else flecha1.text.toString().trim().toInt()
                flecha2Valor =  if(flecha2.text.toString().isNullOrBlank() || flecha2.text.toString().toInt() > 10)throw IllegalArgumentException() else flecha2.text.toString().trim().toInt()
                flecha3Valor =  if(flecha3.text.toString().isNullOrBlank() || flecha3.text.toString().toInt() > 10)throw IllegalArgumentException() else flecha3.text.toString().trim().toInt()

                resultadoValor = evm.sumaFlechas(flecha1Valor,flecha2Valor,flecha3Valor)
                total += resultadoValor.toDouble()

                resultado.setText(resultadoValor.toString())
                resultado.setVisibility(View.VISIBLE)

                rondaActual = rondas.text.toString().toInt() +1
                rondas.setText(rondaActual.toString())

                if (rondaActual == 20){
                    promedio = total / 60

                    promedioTexto.setVisibility(View.VISIBLE)
                    promedioNumero.setText(evm.redondeo(promedio).toString())
                    promedioNumero.setVisibility(View.VISIBLE)

                    sumaNumero.setText(total.toInt().toString())
                    sumaNumero.setVisibility(View.VISIBLE)
                    totalTexto.setVisibility(View.VISIBLE)

                    Toast.makeText(view.context,"FIN DEL ENTRENAMIENTO", Toast.LENGTH_LONG).show()

                }
            }catch (e:Exception){
                Log.e("Error al guardar Puntaje.", e.message.toString())
                Toast.makeText(view.context,"Hubo error al guardar", Toast.LENGTH_SHORT).show()
            }

        }
    }

}