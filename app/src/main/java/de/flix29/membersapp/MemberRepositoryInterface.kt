package de.flix29.membersapp

import de.flix29.membersapp.model.Member

interface MemberRepositoryInterface {
    suspend fun getRandomName(memberList: List<Member> ): Member
    fun fetchMembersData(): List<Member>
}