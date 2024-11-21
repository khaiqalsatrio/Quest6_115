package com.example.quest6_115.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quest6_115.R
import com.example.quest6_115.model.Mahasiswa

@Composable
fun RencanaStudyView(
    mahasiswa: Mahasiswa,
    onSubmitButtonCliked: (MutableList<String>) -> Unit,
    onBackButtonCliked: () -> Unit
) {

    var chosenDropdown by remember { mutableStateOf("") }
    var pilihanKelas by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }

    val listData = mutableListOf(chosenDropdown, pilihanKelas)


    val snackbarHostState = remember { SnackbarHostState() }

    val coroutineScope = rememberCoroutineScope()


    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.primary))
                .padding(paddingValues)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.umy2),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                )
                Spacer(modifier = Modifier.padding(start = 16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = mahasiswa.Nim,
                        fontWeight = FontWeight.Bold,  // Tetap Bold untuk menebalkan
                        fontSize = 20.sp,  // Besarkan font size sesuai keinginan
                        color = Color.White
                    )
                    Text(
                        text = mahasiswa.Nama,
                        fontWeight = FontWeight.Light,
                        fontSize = 15.sp,
                        color = Color.White
                    )
                }
                Box {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }