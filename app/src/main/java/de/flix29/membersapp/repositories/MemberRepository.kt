package de.flix29.membersapp.repositories

import android.content.Context
import de.flix29.membersapp.MemberReposityInterface
import de.flix29.membersapp.model.Member

class MemberRepository @Inject constructor(
    context: Context
): MemberReposityInterface {

    override suspend fun getRandomName(
        memberList: List<Member>
    ): Member {
        return if (memberList.isNotEmpty()) {
            memberList.random()
        } else {
            Member(-1, "", "")
        }
    }

    override fun fetchMembersData(): List<Member> {
        return listOf(
            Member(1, "Alice", ""),
            Member(2, "Bob", ""),
            Member(3, "Charlie", ""),
            Member(4, "Peter", ""),
            Member(5, "Lisa", ""),
        )
    }
}