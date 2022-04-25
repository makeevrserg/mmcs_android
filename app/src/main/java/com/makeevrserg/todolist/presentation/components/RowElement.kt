package com.makeevrserg.todolist.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.makeevrserg.astralearner.utils.Dimens
import com.makeevrserg.astralearner.utils.TextSizes

@Composable
fun RowElement(prefix: String, postfix: @Composable () -> Unit): Unit = Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = Dimens.S, vertical = Dimens.XXS),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
) {
    Text(prefix, color = Colors.colorHint, fontSize = TextSizes.M)
    postfix.invoke()
}


@Composable
fun RowElement(prefix: String, postfix: String) = RowElement(
    prefix = prefix, postfix = {
        Text(
            postfix,
            color = Colors.colorOnPrimary,
            fontSize = TextSizes.M, modifier = Modifier.widthIn(10.dp, 200.dp)
        )
    }
)
