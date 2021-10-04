package com.example.indra.domain.usecase

import javax.inject.Inject

class GetValidateLoginUseCase @Inject constructor(
){
    operator fun invoke(userName : String,pass : String) : Boolean{
        return userName == "Admin" && pass == "Password*123"
    }
}