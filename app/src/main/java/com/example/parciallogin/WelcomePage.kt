import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.parciallogin.ui.theme.ParcialLoginTheme

@Composable
fun WelcomePage(navController: NavController) {
    Text(
        text = "Bienvenido!",
    )
}

@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    ParcialLoginTheme {
        val navController = rememberNavController()
        WelcomePage(navController = navController)
    }
}