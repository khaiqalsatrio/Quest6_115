package com.example.quest6_115.ui.view.viewModel

import androidx.lifecycle.ViewModel
import com.example.quest6_115.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {


    private val _statusUI = MutableStateFlow(Mahasiswa())

    val statusUI: StateFlow<Mahasiswa> get() = _statusUI

    fun setMahasiswa(ls: List<String>) {
        println("Called setMahasiswa with $ls")
        if (ls.size == 5) {
            println("Valid list size, updating Mahasiswa object")
            _statusUI.update { statusSaatIni ->
                statusSaatIni.copy(
                    Nim = ls[0],
                    Nama = ls[1],
                    Email = ls[2],
                    Matakuliah = ls[3],
                    Kelas = ls[4],
                )
            }
        } else {
            println("Invalid list size: $ls")
            throw IllegalArgumentException("List harus memiliki 5 elemen: nim, nama, email, matakuliah, kelas.")
        }
    }
}
