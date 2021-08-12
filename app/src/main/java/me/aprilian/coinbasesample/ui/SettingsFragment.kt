package me.aprilian.coinbasesample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Surface
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import java.lang.reflect.Modifier

class SettingsFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                Text("Hello World")
            }
        }
    }
}

@Composable
fun SimpleOutlinedTextFieldSample() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )
}

//@Composable
//fun MainApp() {
//    Surface(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Scaffold(
//            topBar = { ChukyTopBar() },
//            bottomBar = { MainNavigation() }
//        ) {
//            HomeScreen()
//        }
//    }
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyChukyEatsApplicationTheme {
//        MainApp()
//    }
//}