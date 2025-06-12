package de.flix29.membersapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.flix29.membersapp.MemberRepositoryInterface
import de.flix29.membersapp.model.Member
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MemberViewModel @Inject constructor(
    private val memberRepository: MemberRepositoryInterface
) : ViewModel() {

    private val _memberList = MutableStateFlow<List<Member>>(emptyList())
    val memberList = _memberList
    private val _randomName = MutableStateFlow<String?>(null)
    val randomName = _randomName
    private val _randomNameReceived = MutableStateFlow<Boolean>(false)
    val randomNameReceived = _randomNameReceived

    fun fetchMembers() {
        _memberList.value = memberRepository.fetchMembersData()
    }

    fun clickGetRandomMember(names: List<Member>) {
        viewModelScope.launch {
            getRandomMember(names)
        }
    }

    private suspend fun getRandomMember(names: List<Member>) {
        _randomName.value = memberRepository.getRandomName(names).name
        _randomNameReceived.value = true
    }
}