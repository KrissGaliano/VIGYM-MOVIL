package pe.edu.tecsup.ViGym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*

import com.google.firebase.auth.FirebaseAuth
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {

    private lateinit var txtUser: EditText
    private lateinit var txtPassword: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)
        setTheme(R.style.Theme_ViGym)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val registrar = findViewById<TextView>(R.id.registrarse)
        registrar.setOnClickListener {
            val Registro = Intent(this, MainActivity_Registro::class.java)
            startActivity(Registro)
            }
            val log = findViewById<Button>(R.id.ingresar)
            log.setOnClickListener {
                val ingresare = Intent(this, MainActivity_Inicio::class.java)
                startActivity(ingresare)
            }*/

        txtUser=findViewById(R.id.txtUser)
        txtPassword=findViewById(R.id.txtPassword)
        progressBar=findViewById(R.id.progressBar2)
        auth= FirebaseAuth.getInstance()

    }
    fun recup_contra(view: View){
        startActivity(Intent(this,MainActivity_RecupContra::class.java))
    }
    fun registrarse(view: View){
        startActivity(Intent(this,MainActivity_Registro::class.java))

    }
    fun ingresar(view: View){
        loginUser()

    }
    private fun loginUser(){
        val user:String=txtUser.text.toString()
        val password:String=txtPassword.text.toString()

        if(!TextUtils.isEmpty(user) &&!TextUtils.isEmpty(password)){
            progressBar.visibility= View.VISIBLE

            auth.signInWithEmailAndPassword(user,password)
                .addOnCompleteListener(this){
                        task ->

                    if(task.isSuccessful){
                        action()
                    }else{
                        Toast.makeText(this,"Error en la autenticación", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
    private fun action(){
        startActivity(Intent(this,MainActivity_Inicio::class.java))
    }
}

