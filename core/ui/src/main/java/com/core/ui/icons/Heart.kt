/*
* Converted using https://composables.com/svgtocompose
*/

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Heart: ImageVector
    get() {
        if (_Heart != null) {
            return _Heart!!
        }
        _Heart = ImageVector.Builder(
            name = "Heart",
            defaultWidth = 426.668.dp,
            defaultHeight = 426.668.dp,
            viewportWidth = 426.668f,
            viewportHeight = 426.668f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFF05228)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(401.788f, 74.476f)
                curveToRelative(-63.4920f, -82.4320f, -188.4460f, -33.7920f, -188.4460f, 49.920f)
                curveToRelative(00f, -83.7120f, -124.9620f, -132.3560f, -188.4630f, -49.920f)
                curveToRelative(-65.630f, 85.2220f, -0.9430f, 234.5090f, 188.4590f, 320.2650f)
                curveTo(402.7310f, 308.9850f, 467.4180f, 159.6980f, 401.7880f, 74.4760f)
                close()
            }
            group {
            }
            group {
            }
            group {
            }
            group {
            }
            group {
            }
            group {
            }
            group {
            }
            group {
            }
            group {
            }
            group {
            }
            group {
            }
            group {
            }
            group {
            }
            group {
            }
            group {
            }
        }.build()
        return _Heart!!
    }

private var _Heart: ImageVector? = null
