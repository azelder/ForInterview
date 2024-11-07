package com.azelder.fetchhiring.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.azelder.fetchhiring.MainListUiState
import com.azelder.fetchhiring.MainListViewModel


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
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                hiringList.forEach {
                    item {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = it.name ?: "No Name",
                            )
                            Text(
                                text = it.listId
                            )
                            Text(
                                text = it.id.toString()
                            )
                        }
                    }
                }
            }
        }
    }
}