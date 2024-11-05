package com.core.ui.icons.myiconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.core.ui.icons.MyIconPack

public val MyIconPack.Flame: ImageVector
    get() {
        if (_flame != null) {
            return _flame!!
        }
        _flame = Builder(name = "Flame", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(18.57f, 8.2f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, -0.95f, -0.41f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, -0.8f, 0.65f)
                arcToRelative(5.57f, 5.57f, 0.0f, false, true, -0.59f, 1.0f)
                arcToRelative(10.24f, 10.24f, 0.0f, false, false, -6.14f, -8.38f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, -1.42f, 0.85f)
                arcTo(12.25f, 12.25f, 0.0f, false, true, 6.12f, 9.07f)
                arcTo(9.55f, 9.55f, 0.0f, false, false, 4.0f, 15.0f)
                arcToRelative(8.0f, 8.0f, 0.0f, false, false, 8.0f, 8.0f)
                arcToRelative(7.91f, 7.91f, 0.0f, false, false, 8.0f, -8.0f)
                curveTo(20.0f, 10.33f, 18.72f, 8.41f, 18.57f, 8.2f)
                close()
            }
        }
        .build()
        return _flame!!
    }

private var _flame: ImageVector? = null
