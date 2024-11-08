package com.azelder.fetchhiring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.azelder.fetchhiring.ui.composable.ListScreen
import com.azelder.fetchhiring.ui.theme.FetchHiringTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            /**
             * In a full sized application, this would be moved to a fragment or navigation graph
             * component. Since we are only having one screen then more complex screen flow handling
             * isn't needed.
             */
            FetchHiringTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ListScreen(viewModel)
                }
            }
        }
    }
}