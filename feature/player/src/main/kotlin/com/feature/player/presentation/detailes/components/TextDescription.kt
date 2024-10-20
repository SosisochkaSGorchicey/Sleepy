package com.feature.player.presentation.detailes.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.core.ui.theme.AppTheme

@Composable
fun TextDescription() {
    Text(
        modifier = Modifier
            .fillMaxWidth(.8f)
            .padding(bottom = 10.dp),
        text = "Lorem ipsum odor amet, consectetuer adipiscing elit. Facilisis amet auctor orci fames class ligula semper cras. Curabitur natoque efficitur praesent consectetur magna ligula ligula phasellus ligula. Et sollicitudin velit ullamcorper suspendisse enim dis hendrerit. Elit mauris dis maximus sed sollicitudin porta. Dis quis aliquet rhoncus mattis tempus netus semper. Auctor cubilia laoreet massa egestas neque fames nascetur class. Iaculis vulputate rutrum neque elementum potenti nam finibus.\n" +
                "\n" +
                "Varius purus mattis vitae commodo ullamcorper maecenas hendrerit faucibus pretium. Senectus nibh sapien nibh inceptos condimentum senectus vestibulum scelerisque ultricies. Dolor commodo non commodo fringilla sem orci urna aptent. Ipsum fames ornare efficitur nisi, platea mauris turpis faucibus. Ipsum curae molestie magnis facilisi elit libero feugiat. Eros id porttitor duis convallis venenatis. Nibh aliquam rhoncus mi phasellus et lacus nullam condimentum lectus. Maecenas facilisi taciti accumsan ullamcorper amet.\n" +
                "\n" +
                "Phasellus convallis venenatis elementum mollis libero; cras pharetra sem. Hac cras proin nec gravida quis integer. Orci conubia tincidunt amet purus ad vestibulum non. Sodales neque aenean congue viverra vehicula lorem dictumst eget. Cursus morbi litora inceptos urna etiam nullam fringilla. Gravida rhoncus vehicula; a parturient molestie vehicula nam. Risus penatibus erat quis; non enim sem mus felis. Blandit vestibulum hendrerit imperdiet elit mus erat.\n" +
                "\n" +
                "Finibus tortor himenaeos proin nec pretium justo condimentum amet. Fringilla mollis faucibus ultrices penatibus platea auctor aliquam nascetur elementum. Dictum vestibulum maximus magna purus scelerisque consectetur? Nulla lobortis donec nulla libero rutrum varius mollis scelerisque. Auctor integer vivamus sed platea at ultricies elit commodo. Fringilla etiam libero felis habitasse habitant.",
        style = AppTheme.typography.bodySmall
    )
}