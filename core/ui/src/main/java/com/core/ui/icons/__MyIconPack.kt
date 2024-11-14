package com.core.ui.icons

import androidx.compose.ui.graphics.vector.ImageVector
import com.core.ui.icons.myiconpack.Error
import com.core.ui.icons.myiconpack.Flame
import com.core.ui.icons.myiconpack.Stop
import kotlin.collections.List as ____KtList

public object MyIconPack

private var __AllIcons: ____KtList<ImageVector>? = null

public val MyIconPack.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Stop, Error, Flame)
    return __AllIcons!!
  }
