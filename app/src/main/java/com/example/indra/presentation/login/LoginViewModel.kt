package com.example.indra.presentation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.indra.domain.usecase.GetValidateLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getValidateLoginUseCase: GetValidateLoginUseCase
) : ViewModel() {
    val isLogin = MutableLiveData<Boolean>()

    fun ValidateLogin(userName : String,pass : String){
        val result = getValidateLoginUseCase(userName,pass)
        isLogin.postValue(result)
    }
}