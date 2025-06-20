package de.flix29.membersapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import de.flix29.R
import de.flix29.membersapp.model.Member
import de.flix29.membersapp.ui.MemberItem
import de.flix29.membersapp.viewmodels.MemberViewModel

@Composable
fun MemberScreen(memberViewModel: MemberViewModel = hiltViewModel()) {

    val membersList by memberViewModel.memberList.collectAsState()
    val randomName by memberViewModel.randomName.collectAsState()
    val randomNameReceived by memberViewModel.randomNameReceived.collectAsState()

    LaunchedEffect(Unit) {
        memberViewModel.fetchMembers()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 65.dp)
            ) {
                AskQuestionField(memberViewModel, membersList, randomName)
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 45.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                MembersList(membersList)
            }
        }
    }

    if (randomNameReceived) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color= colorResource(R.color.member_item_bg),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(60.dp)
            ) {
                Text(
                    text = "Random Name: ${randomName ?: "No name found"}",
                    color = Color.Black,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun AskQuestionField(
    memberViewModel: MemberViewModel,
    list: List<Member>,
    randomName: String?,
) {
    var text by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("Name") }

    if (randomName != null) {
        name = randomName
    }

    Box {
        TextField(
            value = text,
            onValueChange = { text = it },
//            modifier = Modifier.weight(1f),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.DarkGray,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
    IconButton(
        onClick = { memberViewModel.clickGetRandomMember(list) },
        modifier = Modifier
            .size(30.dp)
            .background(
                color = colorResource(R.color.button_color),
                shape = CircleShape
            )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Send",
            tint = Color.White
        )
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