package de.flix29.membersapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.flix29.membersapp.model.Member
import de.flix29.membersapp.ui.MemberItem

@Composable
fun MemberScreen() {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxSize().padding(top = 65.dp)) {
                AskQuestionField()
            }
            Box(
                modifier = Modifier.fillMaxSize().padding(top = 45.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                MembersList()
            }
        }
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
fun MembersList(list: List<Member>) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(list) { member ->
            MemberItem(member = member)
        }
    }
}