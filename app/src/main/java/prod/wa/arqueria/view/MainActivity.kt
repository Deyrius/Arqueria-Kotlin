package prod.wa.arqueria.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import prod.wa.arqueria.R
import prod.wa.arqueria.fragment.EntrenamientoFragment
import androidx.lifecycle.ViewModelProvider



class MainActivity : AppCompatActivity() {
    lateinit var frameLayout: FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializador ()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val manager = supportFragmentManager
        val entrenamientoFragment = EntrenamientoFragment()
        val args = Bundle()

        return when (item.itemId){
            R.id.m_entrenamiento ->{
                val transaction = manager.beginTransaction()
                entrenamientoFragment.arguments = args
                transaction.replace(R.id.main_frame,entrenamientoFragment)
                transaction.commit()
                true
            }
            else ->{
                Toast.makeText(this,"Opcion erronea.", Toast.LENGTH_SHORT).show()
                true
            }
        }
    }
    fun inicializador (){
        frameLayout = findViewById(R.id.main_frame)
    }
}