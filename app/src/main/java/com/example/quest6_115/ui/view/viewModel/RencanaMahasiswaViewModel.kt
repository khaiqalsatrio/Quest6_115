package com.example.project8.ui.view.viewModel

import androidx.lifecycle.ViewModel
import com.example.quest6_115.model.RencanaStudi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RencanaMahasiswaViewModel : ViewModel() {

    private val _krsState = MutableStateFlow(RencanaStudi())
    val krsStateUi: StateFlow<RencanaStudi> = _krsState.asStateFlow()

    fun setMatakuliah(mkPilihan: String) {
        _krsState.update { stateMk -> stateMk.copy(namaMk = mkPilihan) }
    }

    fun setKelas(kelasPilihan: String) {
        _krsState.update { stateKelas -> stateKelas.copy(kelas = kelasPilihan) }
    }

    fun saveDataKRS(ls: MutableList<String>) {
        if (ls.size >= 2) {
            _krsState.update { status ->
                status.copy(
                    namaMk = ls[0],
                    kelas = ls[1]
                )
            }
        } else {
            println("Data tidak valid. Pastikan list memiliki minimal 2 elemen.")
        }
    }
}
