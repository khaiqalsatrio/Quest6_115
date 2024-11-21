package com.example.quest6_115.ui.view.viewModel

import androidx.lifecycle.ViewModel
import com.example.quest6_115.model.RencanaStudi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RencanaMahasiswaViewModel : ViewModel() {

    private val _krsState = MutableStateFlow(RencanaStudi())
    val krsStateUi: StateFlow<RencanaStudi> = _krsState.asStateFlow()
}