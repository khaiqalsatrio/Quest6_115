import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quest6_115.model.Mahasiswa
import com.example.quest6_115.ui.view.screen.MahasiswaFormView
import com.example.quest6_115.ui.view.screen.RencanaStudyView
import com.example.quest6_115.ui.view.screen.SplashView

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

    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navHost,
        startDestination = Halaman.Splash.name
    ) {
        // Splash Screen
        composable(route = Halaman.Splash.name) {
            SplashView(onStartClick = {
                navHost.navigate(Halaman.MahasiswaForm.name)
            })
        }

        // Form Mahasiswa
        composable(route = Halaman.MahasiswaForm.name) {
            MahasiswaFormView(
                onSubmitButtonCliked = { listData -> // Ejaan diperbaiki
                    mahasiswa.value = Mahasiswa(
                        Nama = listData[0],
                        Nim = listData[1],
                        Email = listData[2],
                        Matakuliah = mahasiswa.value.Matakuliah,
                        Kelas = mahasiswa.value.Kelas
                    )
                    navHost.navigate(Halaman.RencanaStudy.name)
                },
                onBackButtonCliked = { // Ejaan diperbaiki
                    navHost.navigateUp()
                }
            )
        }

        // Rencana Study
        composable(route = Halaman.RencanaStudy.name) {
            RencanaStudyView(
                mahasiswa = mahasiswa.value,
                onSubmitButtonCliked = { listData -> // Ejaan diperbaiki
                    mahasiswa.value = Mahasiswa(
                        Nama = mahasiswa.value.Nama,
                        Nim = mahasiswa.value.Nim,
                        Email = mahasiswa.value.Email,
                        Matakuliah = listData[0],
                        Kelas = listData[1]
                    )
                    navHost.navigate(Halaman.Tampil.name)
                },
                onBackButtonCliked = { // Ejaan diperbaiki
                    navHost.navigateUp()
                }
            )
        }

        // Tampilkan Data Mahasiswa
        composable(route = Halaman.Tampil.name) {
            TampilView(
                uiState = mahasiswa.value,
                onBackButtonClicked = {
                    navHost.navigateUp()
                },
                onSubmitButtonClicked = {
                    navHost.navigate(Halaman.Splash.name) // Atur sesuai kebutuhan
                }
            )
        }
    }
}
