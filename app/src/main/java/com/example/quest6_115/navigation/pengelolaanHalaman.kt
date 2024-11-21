package com.example.quest6_115.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Halaman {
    MahasiswaForm,
    RencanaStudy,
    Splash,
    Tampil,
}

@Composable
fun PengelolaanHalaman(
    modifier: Modifier = Modifier,
    navHost: NavHostController = rememberNavController()
) {
    // State untuk menyimpan data mahasiswa
    val mahasiswa = remember {
        mutableStateOf(
            Mahasiswa(
                Nama = "",
                Nim = "",
                Email = "",
                Matakuliah = "",
                Kelas = ""
            )
        )
    }

