package com.makeevrserg.todolist.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.makeevrserg.astralearner.utils.Dimens

@Composable
fun DashedCard(
    modifier: Modifier = Modifier,
    showDashedLine: Boolean = true,
    title: @Composable (() -> Unit)? = null,
    content: @Composable (() -> Unit)? = null,
) = Card(
    modifier
        .fillMaxWidth()
        .padding(Dimens.XS),
    shape = RoundedCornerShape(Dimens.XS),
    backgroundColor = Colors.colorPrimary
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Dimens.XS),
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.XS),
    ) {
        title?.invoke()
        if (showDashedLine)
            DashedLine()
        content?.invoke()
    }
}