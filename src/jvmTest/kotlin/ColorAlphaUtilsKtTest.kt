import org.junit.Test
import kotlin.test.assertEquals

class ColorAlphaUtilsKtTest {

    @Test
    fun percent_to_alphacode() {
        var percent = 0
        while (percent <= 100) {
            assertEquals(colorAlpha[percent], getAlphaCode(percent))
            percent += 1
        }
    }
}