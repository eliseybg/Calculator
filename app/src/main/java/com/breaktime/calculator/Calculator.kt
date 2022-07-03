package com.breaktime.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.breaktime.calculator.ui.theme.LightGray
import com.breaktime.calculator.ui.theme.MediumGray
import com.breaktime.calculator.ui.theme.Orange

@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorActions) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol.orEmpty()) + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 2
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.tertiary)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorActions.Clear)
                    }
                )
                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.8f))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Delete)
                    }
                )
                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.8f))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperation.Divide))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                (7..9).forEach {
                    CalculatorButton(
                        symbol = it.toString(),
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.secondary)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorActions.Number(it))
                        }
                    )
                }
                CalculatorButton(
                    symbol = "x",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.8f))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperation.Multiply))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                (4..6).forEach {
                    CalculatorButton(
                        symbol = it.toString(),
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.secondary)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorActions.Number(it))
                        }
                    )
                }
                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.8f))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperation.Subtract))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                (1..3).forEach {
                    CalculatorButton(
                        symbol = it.toString(),
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.secondary)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorActions.Number(it))
                        }
                    )
                }
                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.8f))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperation.Add))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondary)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorActions.Number(0))
                    }
                )
                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Decimal)
                    }
                )
                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Calculate)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun CalculatorPreview() {
    Calculator(
        state = CalculatorState(),
        onAction = { },
        buttonSpacing = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    )
}

@Preview
@Composable
fun CalculatorWithNumber1Preview() {
    Calculator(
        state = CalculatorState(number1 = "123"),
        onAction = { },
        buttonSpacing = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    )
}

@Preview
@Composable
fun CalculatorWithActionPreview() {
    Calculator(
        state = CalculatorState(
            number1 = "123",
            operation = CalculatorOperation.Add
        ),
        onAction = { },
        buttonSpacing = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    )
}

@Preview
@Composable
fun CalculatorWithNumber2Preview() {
    Calculator(
        state = CalculatorState(
            number1 = "123",
            operation = CalculatorOperation.Add,
            number2 = "123"
        ),
        onAction = { },
        buttonSpacing = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    )
}