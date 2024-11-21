

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun TampilView(
    uiState: Mahasiswa,
    onBackButtonClicked: () -> Unit = {},
    onSubmitButtonClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = com.example.quest6_115.R.drawable.umy2),
                contentDescription = "Logo Universitas",
                modifier = Modifier.size(45.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "Universitas Muhamadiyah Yogyakarta",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Unggul Dan Islami",
                    color = Color.White,
                    fontWeight = FontWeight.Light
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topEnd = 15.dp,
                        topStart = 15.dp
                    )
                )
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    // Item List
                    DataRow(label = "Nim", value = uiState.Nama)
                    DataRow(label = "Nama", value = uiState.Nim)
                    DataRow(label = "Email", value = uiState.Email)
                    DataRow(label = "Mata Kuliah", value = uiState.Matakuliah)
                    DataRow(label = "Kelas", value = uiState.Kelas)
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = onBackButtonClicked,
                        modifier = Modifier.width(120.dp)
                    ) {
                        Text(text = "Kembali")
                    }
                    Button(
                        onClick = onSubmitButtonClicked,
                        modifier = Modifier.width(120.dp)
                    ) {
                        Text(text = "Selesai")
                    }
                }
            }
        }
    }
}

// Utility function for a data row
@Composable
fun DataRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "$label:", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = value, fontSize = 16.sp)
    }
}
