package com.example.indra.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.indra.R
import com.example.indra.databinding.FragmentLoginBinding
import com.example.indra.presentation.movies.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            loginViewModel.ValidateLogin(binding.etUserName.text.toString(),binding.etPassword.text.toString())
        }
        loginViewModel.isLogin.observe(viewLifecycleOwner,{
            if (it){
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_moviesFragment2)
            }else{
                Toast.makeText(context,"No se encontro",Toast.LENGTH_LONG).show()
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_moviesFragment2)
            }
        })
    }
}