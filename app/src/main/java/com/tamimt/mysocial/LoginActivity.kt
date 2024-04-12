package com.tamimt.mysocial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tamimt.mysocial.databinding.ActivityLoginBinding
import com.tamimt.mysocial.models.User

class LoginActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {

            if (binding.email.editText?.text.toString().equals("") or
                binding.password.editText?.text.toString().equals("")) {

                Toast.makeText(this@LoginActivity, "Fenoy daholo azafady !", Toast.LENGTH_SHORT).show()

            } else {

                var user = User(binding.email.editText?.text.toString(),
                                binding.password.editText?.text.toString())

                Firebase.auth.signInWithEmailAndPassword(user.email!!, user.password!!)
                    .addOnCompleteListener {

                        if (it.isSuccessful){
                            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this@LoginActivity, it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
                        }

                    }

            }

        }
        binding.signUpBtn.setOnClickListener{
            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
            finish()
        }

    }
}