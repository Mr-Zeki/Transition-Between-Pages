package mrz.example.transitionbetweenpages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mrz.example.transitionbetweenpages.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mainBinding : ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this@MainActivity,R.layout.activity_main)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val eMail : String = "mrz@gmail.com"
        val pw : String = "00"

        mainBinding.login.setOnClickListener{
            val intent = Intent(this,HomePage::class.java)
            if (mainBinding.eMailInput.text.toString().isNotEmpty() && mainBinding.pwInput.text.toString().isNotEmpty()){
                if (mainBinding.eMailInput.text.toString() == eMail && mainBinding.pwInput.text.toString() == pw){
                    startActivity(intent)
                }
                else if (mainBinding.eMailInput.text.toString()!= eMail) {
                    mainBinding.eMailInput.error = "E-Mail adresinizi yanlış girdiniz,lütfen tekrar giriniz!"

                }
                else if (mainBinding.pwInput.text.toString()!= pw){
                    mainBinding.pwInput.error = "Şifrenizi yanlış girdiniz,lütfen tekrar giriniz!"
                }
            }
            else if (mainBinding.eMailInput.text.isEmpty() && mainBinding.pwInput.text.isEmpty()){
                mainBinding.eMailInput.error = "Boş Bırakılamaz!"
                mainBinding.pwInput.error = "Boş Bırakılamaz!"
            }
            else if (mainBinding.eMailInput.text.isEmpty()) {
                mainBinding.eMailInput.error = "Boş Bırakılamaz!"
            }
            else if (mainBinding.pwInput.text.isEmpty()){
                mainBinding.pwInput.error = "Boş Bırakılamaz!"
            }

        }


    }
}