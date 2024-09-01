import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.core.ui.icons.SleepyIcons


private var _Error: ImageVector? = null

public val SleepyIcons.Error: ImageVector
    get() {
        if (_Error != null) {
            return _Error!!
        }
        _Error = ImageVector.Builder(
            name = "Error",
            defaultWidth = 38.dp,
            defaultHeight = 38.dp,
            viewportWidth = 38f,
            viewportHeight = 38f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(20.878f, 26.272f)
                arcTo(1.878f, 1.878f, 0f, isMoreThanHalf = false, isPositiveArc = true, 19f, 28.15f)
                arcTo(
                    1.878f,
                    1.878f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    17.122f,
                    26.272f
                )
                arcTo(
                    1.878f,
                    1.878f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    20.878f,
                    26.272f
                )
                close()
            }
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(18.969f, 21.6f)
                horizontalLineToRelative(0f)
                arcToRelative(
                    1.2f,
                    1.2f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    -1.2f,
                    -1.146f
                )
                lineToRelative(-0.425f, -8.883f)
                arcTo(1.653f, 1.653f, 0f, isMoreThanHalf = false, isPositiveArc = true, 19f, 9.85f)
                horizontalLineToRelative(0f)
                arcToRelative(
                    1.652f,
                    1.652f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    1.65f,
                    1.731f
                )
                lineToRelative(-0.487f, 8.881f)
                arcTo(1.2f, 1.2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 18.969f, 21.6f)
                close()
            }
        }.build()
        return _Error!!
    }

