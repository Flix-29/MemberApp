package de.flix29.membersapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

@Composable
fun MemberScreen() {
    Column {
        AskQuestionField()
        MembersList()
    }
}

@Composable
fun AskQuestionField() {
    Box {
        TextField() {

        }
        Button() {

        }
    }
}

@Composable
fun MembersList() {
    LazyColumn {

    }
}