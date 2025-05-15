package de.flix29.membersapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import de.flix29.membersapp.ui.screens.MemberScreen
import de.flix29.membersapp.ui.theme.MembersAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MembersAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MemberScreen()
                }
            }
        }
    }
}