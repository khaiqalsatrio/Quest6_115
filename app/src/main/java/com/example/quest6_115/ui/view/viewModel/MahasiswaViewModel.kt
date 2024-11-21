package com.example.quest6_115.ui.view.viewModel


import androidx.lifecycle.ViewModel
import com.example.quest6_115.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MahasiswaViewModel : ViewModel() {


    private val _statusUI = MutableStateFlow(Mahasiswa())

    val statusUI: StateFlow<Mahasiswa> get() = _statusUI