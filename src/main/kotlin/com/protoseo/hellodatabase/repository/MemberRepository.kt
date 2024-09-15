package com.protoseo.hellodatabase.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.protoseo.hellodatabase.hibernate.member.Member

interface MemberRepository : JpaRepository<Member, Long> {
}
