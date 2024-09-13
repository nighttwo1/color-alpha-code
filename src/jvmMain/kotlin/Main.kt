import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension

@Composable
@Preview
fun App() {
    val text by remember { mutableStateOf("Alpha 계산기") }
    var inputAlpha by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    MaterialTheme {
        Column(
            modifier = Modifier.wrapContentSize(), verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            TextField(
                value = inputAlpha,
                onValueChange = {
                    inputAlpha = it
                    inputAlpha.toIntOrNull()?.let { it1 -> output = getAlphaCode(it1) }
                },
                maxLines = 1,
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Text("alpha 0 ~ 100")
                }
            )
            TextField(
                value = output,
                onValueChange = { },
                maxLines = 1,
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                ),
                readOnly = true
            )
        }
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(width = Dp.Unspecified, height = Dp.Unspecified),
        title = "Adaptive",
        resizable = false
    ) {
        App()
    }
}
