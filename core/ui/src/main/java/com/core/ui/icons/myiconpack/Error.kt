package com.core.ui.icons.myiconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.core.ui.icons.MyIconPack

public val MyIconPack.Error: ImageVector
    get() {
        if (_error != null) {
            return _error!!
        }
        _error = Builder(name = "Error", defaultWidth = 38.0.dp, defaultHeight = 38.0.dp,
                viewportWidth = 38.0f, viewportHeight = 38.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(19.0f, 26.272f)
                moveToRelative(-1.878f, 0.0f)
                arcToRelative(1.878f, 1.878f, 0.0f, true, true, 3.756f, 0.0f)
                arcToRelative(1.878f, 1.878f, 0.0f, true, true, -3.756f, 0.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(18.969f, 21.6f)
                horizontalLineToRelative(0.0f)
                arcToRelative(1.2f, 1.2f, 0.0f, false, true, -1.2f, -1.146f)
                lineToRelative(-0.425f, -8.883f)
                arcTo(1.653f, 1.653f, 0.0f, false, true, 19.0f, 9.85f)
                horizontalLineToRelative(0.0f)
                arcToRelative(1.652f, 1.652f, 0.0f, false, true, 1.65f, 1.731f)
                lineToRelative(-0.487f, 8.881f)
                arcTo(1.2f, 1.2f, 0.0f, false, true, 18.969f, 21.6f)
                close()
            }
        }
        .build()
        return _error!!
    }

private var _error: ImageVector? = null
