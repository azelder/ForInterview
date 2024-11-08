package com.azelder.fetchhiring.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.azelder.fetchhiring.MainListUiState
import com.azelder.fetchhiring.MainListViewModel
import com.azelder.fetchhiring.R
import com.azelder.model.data.HiringModel


@Composable
fun ListScreen(
    viewModel: MainListViewModel
) {
    val list by viewModel.uiState.collectAsState()
    when (list) {
        is MainListUiState.Loading -> {
            Text(
                text = "Loading...",
                modifier = Modifier.padding(16.dp)
            )
        }

        is MainListUiState.Success -> {
            // TODO: double check why this smart cast isn't working
            val hiringList = (list as MainListUiState.Success).hiringList
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray)
            ) {
                item {
                    ItemRowHeader()
                }
                hiringList.keys.forEach { key ->
                    hiringList[key]?.forEach {
                        item {
                            ItemRow(it)
                        }
                    }
                    item {
                        HorizontalDivider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 24.dp, horizontal = 8.dp),
                            color = Color.Black,
                            thickness = 4.dp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ItemRowHeader() {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.item_id),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .defaultMinSize(60.dp)
        )
        Text(
            text = stringResource(id = R.string.item_name),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp)
                .defaultMinSize(60.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.list_id),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .defaultMinSize(60.dp),
            textAlign = TextAlign.End
        )
    }
}

@Preview
@Composable
private fun PreviewItemRowHeader() {
    ItemRowHeader()
}

@Composable
private fun ItemRow(it: HiringModel) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = it.listId,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .defaultMinSize(60.dp)
        )
        Text(
            text = it.name ?: "No Name",
            modifier = Modifier
                .padding(8.dp)
                .defaultMinSize(60.dp),
            textAlign = TextAlign.Center,
        )
        Text(
            text = it.id.toString(),
            textAlign = TextAlign.End,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .defaultMinSize(60.dp)
        )
    }
}

@Preview
@Composable
private fun PreviewItemRow() {
    val hiringModel = HiringModel(1, "1", "name")
    ItemRow(hiringModel)
}

