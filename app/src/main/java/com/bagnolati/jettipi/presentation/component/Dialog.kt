package com.bagnolati.jettipi.presentation.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.bagnolati.jettipi.presentation.theme.AppTheme

@Composable
fun InfoDialog(
    title: String,
    text: String,
    buttonText: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(backgroundColor = AppTheme.colors.primary, contentColor = AppTheme.colors.onPrimary),
    iconContent: @Composable() BoxScope.() -> Unit,
    dialogProperties: DialogProperties = DialogProperties(
        dismissOnBackPress = true,
        dismissOnClickOutside = true
    ),
    onClick: () -> Unit,
    onDismiss: () -> Unit,
) {
    Dialog(
        properties = dialogProperties,
        onDismissRequest = onDismiss,
    ) {
        Card(
            shape = AppTheme.shapes.dialog,
            elevation = 8.dp
        ) {
            Column(
                Modifier
                    .width(240.dp)
                    .background(AppTheme.colors.cardBackground)
                    .padding(vertical = AppTheme.spacing.verticalDefault, horizontal = AppTheme.spacing.horizontalDefault),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .padding(20.dp),
                    content = iconContent
                )
                Text(
                    text = title,
                    style = AppTheme.typography.h3,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = text,
                    style = AppTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    color = AppTheme.colors.onBackground.copy(alpha = 0.6f)
                )
                Spacer(modifier = Modifier.height(28.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(40.dp),
                    onClick = {
                        onDismiss()
                        onClick()
                    },
                    shape = AppTheme.shapes.buttonDialog,
                    colors = buttonColors,
                ) {
                    Text(text = buttonText, style = AppTheme.typography.button)
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}


@Composable
fun ErrorDialog(
    message: String? = null,
    onClick: () -> Unit,
    onDismiss: () -> Unit,
) {
    InfoDialog(
        dialogProperties = DialogProperties(),
        title = "Whoops!", text = message ?: "Something went wrong.", buttonText = "Try Again",
        iconContent = {
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = Icons.Rounded.ErrorOutline, contentDescription = null,
                tint = AppTheme.colors.onBackground.copy(alpha = 0.5f)
            )
        },
        buttonColors = ButtonDefaults.buttonColors(backgroundColor = AppTheme.colors.error, contentColor = AppTheme.colors.onError),
        onClick = onClick,
        onDismiss = onDismiss
    )
}


@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
private fun InfoDialogPreview() {
    AppTheme {
        InfoDialog(
            title = "Info", text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", buttonText = "Ok",
            iconContent = {
                Icon(
                    modifier = Modifier.fillMaxSize(),
                    imageVector = Icons.Rounded.ErrorOutline, contentDescription = null,
                    tint = AppTheme.colors.onBackground.copy(alpha = 0.5f)
                )
            },
            onClick = {},
            onDismiss = {}
        )
    }
}

@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
private fun ErrorDialogPreview() {
    AppTheme {
        ErrorDialog(
            message = "An unexpected error occurred.",
            onClick = {},
            onDismiss = {}
        )
    }
}