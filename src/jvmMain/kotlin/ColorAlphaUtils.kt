import kotlin.math.roundToInt

fun getAlphaCode(alphaPercent: Int): String {
    val decimal = (255 * (alphaPercent / 100.0)).roundToInt()
    return String.format("%02X", decimal)
}