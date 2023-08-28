package com.example.hirein.UI

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Display
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.hirein.R
import com.example.hirein.data.db.JobPortalDatabase
import com.example.hirein.data.db.entity.User
import com.example.hirein.data.db.populateDB
import com.example.hirein.databinding.ActivityLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class LoginActivity:AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var toast: Toast
    inner class CustomTextWatcher(private val inputField : View):TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            when(inputField.id){
                R.id.PhoneOrEmail -> isEmptyEmailIdOrPhone()
                R.id.password -> isEmptyPassword()
            }
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        toast = Toast.makeText( this,"INVALID CREDENTIALS", Toast.LENGTH_LONG)
        sharedPreferences = getSharedPreferences(CustomSharedPreferences.NAME,Context.MODE_PRIVATE)

        if((!sharedPreferences.getBoolean(CustomSharedPreferences.IS_FIRST_TIME, true) )&& (sharedPreferences.getLong(CustomSharedPreferences.LOGGED_IN_USER_ID, 0)!=  0L) )  {
            sharedPreferences.edit().apply {
                putBoolean(CustomSharedPreferences.IS_LOGGED_IN, true)
                apply()
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }
        }


        binding.btnContinue.setOnClickListener{authenticate()}
        binding.PhoneOrEmail.addTextChangedListener(CustomTextWatcher((binding.PhoneOrEmail)))
        binding.password.addTextChangedListener(CustomTextWatcher(binding.password))

    }
    private fun isEmptyEmailIdOrPhone():Boolean{
        val email: String = binding.PhoneOrEmailHolder.editText?.text.toString()
        return when{
            email.isEmpty() -> {
                binding.PhoneOrEmailHolder.error = "Field cant be empty"; true}
            else -> {binding.PhoneOrEmailHolder.error = null; false}
        }
    }
    private fun isEmptyPassword():Boolean{
        val password:String = binding.passwordHolder.editText?.text.toString()
        return when{
            password.isEmpty() ->{
                binding.passwordHolder.error = " Field cant be empty"; true}
            else -> {binding.passwordHolder.error = null; false}
        }
    }

    private fun authenticate(){
        println("Inside the authentication")
        if(isEmptyEmailIdOrPhone() or isEmptyPassword() ){
            println("Failure case")
            return
        }
        else{
            println("inside Else case")
            binding.btnContinue.apply{
                visibility = View.INVISIBLE
                isEnabled = false
            }

                lifecycleScope.launch {
                    withContext(Dispatchers.IO) {
                        println("Inside the login")
                        val database = JobPortalDatabase.getInstance(this@LoginActivity)
                        if(sharedPreferences.getBoolean(CustomSharedPreferences.IS_FIRST_TIME, true)  ){
                           populateDB(database)
                        }

                       // val noRecords = database.registerDao().countRecords()
                       // println(" inside $noRecords")
                        val isValidUser = database.registerDao().authenticateUser(
                            binding.PhoneOrEmailHolder.editText?.text.toString(),
                            binding.passwordHolder.editText?.text.toString()
                        )
                        sharedPreferences.edit().apply {
                            if (sharedPreferences.getBoolean(CustomSharedPreferences.IS_FIRST_TIME, true)) {
                                putBoolean(CustomSharedPreferences.IS_FIRST_TIME, false)
                            }
                            apply()
                        }
                        println("inside $isValidUser")
                        isValidUser?.let {

                            sharedPreferences.edit().apply {

                                putBoolean(CustomSharedPreferences.IS_LOGGED_IN, true)
                                putLong(CustomSharedPreferences.LOGGED_IN_USER_ID,isValidUser)
                                apply()
                            }
                            println("Insert passed the sharedPref")
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                            finish()

                        } ?:  runOnUiThread{
                            if(::toast.isInitialized){
                                toast.cancel()
                            }
                            toast.show()
                            binding.btnContinue.apply {
                                visibility = View.VISIBLE
                                isEnabled = true
                            }
                        }

                    }
            }
        }
    }

}