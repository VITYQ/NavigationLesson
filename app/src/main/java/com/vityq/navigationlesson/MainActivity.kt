package com.vityq.navigationlesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vityq.navigationlesson.ui.theme.NavigationLessonTheme

sealed class Screen(val route: String, val title: String) {
    object First : Screen("firstscreen", "My lessons")
    object Second : Screen("secondscreen/4", "My Profile")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val items = listOf(
                Screen.First,
                Screen.Second
            )
            var expanded by rememberSaveable { mutableStateOf(false) }
            NavigationLessonTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigation {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            items.forEach { screen ->
                                BottomNavigationItem(
                                    icon = {
                                        Icon(
                                            Icons.Filled.Favorite,
                                            contentDescription = null
                                        )
                                    },
                                    label = { Text(screen.title) },
                                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                    onClick = {
                                        navController.navigate(screen.route)
                                    }
                                )
                            }
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { expanded = !expanded }) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                            ) {
                                Icon(Icons.Filled.Star, contentDescription = null)
                                AnimatedVisibility(visible = expanded) {
                                    Text(text = "Likeeeee", modifier = Modifier.padding(start = 8.dp))
                                }
                            }
                        }
                    }
                ) {
                    NavHost(navController = navController, startDestination = "firstscreen") {
                        composable("firstscreen") {
                            FirstScreen() {
                                navController.navigate("secondscreen/$it") {
                                    popUpTo(0)
                                }
                            }
                        }
                        composable(
                            "secondscreen/{argument1}",
                            arguments = listOf(
                                navArgument("argument1") { type = NavType.StringType }
                            )
                        ) {
                            SecondScreen(it.arguments?.getString("argument1") ?: "no args2")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationLessonTheme {
        Greeting("Android")
    }
}