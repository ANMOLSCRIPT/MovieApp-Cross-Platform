package com.example.movieappkmm.android.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieappkmm.android.Red
import com.example.movieappkmm.domain.model.Movie
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeScreenState,
    loadNextMovies: (Boolean) -> Unit,
    navigateToDetail: (Movie) -> Unit
) {
    // Define and remember the isRefreshing state
    val isRefreshing = remember { mutableStateOf(false) }
    val pullRefreshState = rememberSwipeRefreshState(isRefreshing.value)

    // Call the refresh function when the user swipes down
    fun refresh() {
        isRefreshing.value = true
        loadNextMovies(true)
        isRefreshing.value = false
    }

    SwipeRefresh(
        state = pullRefreshState,
        onRefresh = { refresh() }
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(
                    uiState.movies,
                    key = { _, movie -> movie.id }
                ) { index, movie ->
                    MovieListItem(movie = movie, onMovieClick = { navigateToDetail(movie) })

                    if (index >= uiState.movies.size - 1 && !uiState.loading && !uiState.loadFinished) {
                        LaunchedEffect(key1 = Unit, block = { loadNextMovies(false) })
                    }
                }

                if (uiState.loading && uiState.movies.isNotEmpty()) {
                    item(span = { GridItemSpan(2) }) {
                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CircularProgressIndicator(
                                color = Red
                            )
                        }
                    }
                }
            }

            if (uiState.loading && uiState.movies.isEmpty()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Red
                )
            }
        }
    }
}
