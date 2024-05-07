import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parciallogin.ui.theme.ParcialLoginTheme

@Composable
fun LoginPage(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    val user = "emmanuel.tabares@istea.com.ar";
    val pass = "istea123456"

    Column (modifier.padding(30.dp)) {
        Row () {
            TextField(
                value = username,
                onValueChange = { username = it },
                modifier = modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
            )
        }
        Row {
            TextField(
                modifier = modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                value = password,
                onValueChange = {
                    password = it
                }
            )
        }

        Button(
            onClick = {
                if (username == user && password == pass) {
                    navController.navigate("welcomePage")
                } else {
                    showError = true;
                }
            },
            modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp)
        ) {
            Text(
                text = "Ingresar",
                modifier = modifier.padding(horizontal = 10.dp)
            )
        }

        if(showError) {
            Text(
                text = "Credenciales incorrectas"
            )
        }
    }

    NavHost(
        navController = navController,
        modifier = Modifier.padding(),
        startDestination = "loginPage"
    ) {
        composable("welcomePage") {
            WelcomePage(navController = rememberNavController())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    ParcialLoginTheme {
        LoginPage()
    }
}