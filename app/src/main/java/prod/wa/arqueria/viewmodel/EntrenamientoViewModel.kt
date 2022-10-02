package prod.wa.arqueria.viewmodel

import androidx.lifecycle.ViewModel
import java.math.RoundingMode
import java.math.RoundingMode.*
import java.text.DecimalFormat

class EntrenamientoViewModel : ViewModel(){

    fun sumaFlechas(flecha1: Int, flecha2: Int, flecha3: Int): Int{
         var resultado  = flecha1 + flecha2 + flecha3
        return resultado
    }

    fun redondeo(number: Double): Double? {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.FLOOR
        return df.format(number).toDouble()
    }
}