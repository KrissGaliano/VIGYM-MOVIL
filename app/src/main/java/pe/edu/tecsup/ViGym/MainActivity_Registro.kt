package pe.edu.tecsup.ViGym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MainActivity_Registro : AppCompatActivity() {

    private lateinit var txtName:EditText
    private lateinit var txtLastName:EditText
    private lateinit var txtUserName:EditText
    private lateinit var txtEmail:EditText
    private lateinit var txtPassword:EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_registro)

       /* val registrar = findViewById<TextView>(R.id.registro)
        registrar.setOnClickListener {
            val Registro = Intent(this, MainActivity::class.java)
            startActivity(Registro)
        }*/

        txtName=findViewById(R.id.txtName)
        txtLastName=findViewById(R.id.txtLastName)
        txtUserName=findViewById(R.id.txtUserName)
        txtEmail=findViewById(R.id.txtEmail)
        txtPassword=findViewById(R.id.txtPassword)

        progressBar=findViewById(R.id.progressBar)
        database= FirebaseDatabase.getInstance()
        auth= FirebaseAuth.getInstance()

        dbReference=database.reference.child("User")

        }
    fun registro (view:View){
        createNewAccount()

    }
    private fun createNewAccount(){
        val name:String=txtName.text.toString()
        val lastName:String=txtLastName.text.toString()
        val userName:String=txtUserName.text.toString()
        val email:String=txtEmail.text.toString()
        val password:String=txtPassword.text.toString()

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(lastName) &&!TextUtils.isEmpty(userName) &&!TextUtils.isEmpty(email) &&!TextUtils.isEmpty(password)){
            progressBar.visibility=View.VISIBLE

            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){
                        task ->

                    if(task.isComplete){
                        val user: FirebaseUser?=auth.currentUser
                        verifyEmail(user)

                        val userBD=dbReference.child(user?.uid!!)

                        userBD.child("Name").setValue(name)
                        userBD.child("LastName").setValue(lastName)

                        action()
                    }
                }
        }
    }
    private fun action(){
        startActivity(Intent(this,MainActivity::class.java))
    }
    private fun verifyEmail(user: FirebaseUser?){
        user?.sendEmailVerification()
            ?.addOnCompleteListener(this){
                    task ->

                if(task.isComplete){
                    Toast.makeText(this,"Email enviado correctamente", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"Error al enviar el Email", Toast.LENGTH_LONG).show()
                }
            }

    }

}