package com.example.logonpflocal.blocodenotasapp.view.formulario

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonpflocal.blocodenotasapp.model.Nota
import com.example.logonpflocal.blocodenotasapp.model.ResponseStatus
import com.example.logonpflocal.blocodenotasapp.repository.NotaRepository

class FormularioViewModel : ViewModel() {

    val responseStatus: MutableLiveData<ResponseStatus> = MutableLiveData()

    val notarepository = NotaRepository()

    fun salvar(titulo: String, decricao: String) {

        val nota = Nota(null, titulo, decricao)
        notarepository.salvar(nota,
                onComplete = {
                    responseStatus.value = ResponseStatus(true, "Dados gravados com Sucesso!")
                },
                onError = {
                    responseStatus.value = ResponseStatus(false, it?.message!!)
                })
    }
}