package com.feature.audioContent.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.core.domain.model.supabase.db.AudioSection
import com.core.ui.theme.AppTheme
import com.feature.audioContent.presentation.screenmodel.AudioContentEvent

@Composable
fun SectionUI(
    audioSection: AudioSection,
    modifier: Modifier,
    onEvent: (AudioContentEvent) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = audioSection.name,
            style = AppTheme.typography.bodyMediumBold
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(audioSection.items) { index, item ->
                ItemUI(
                    item = item,
                    modifier = index.toSideModifier(list = audioSection.items),
                    onItemClick = { onEvent(AudioContentEvent.OnItemClick(audioDataItem = item)) }
                )
            }
        }
    }
}