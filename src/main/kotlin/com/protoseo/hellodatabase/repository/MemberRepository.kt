package com.protoseo.hellodatabase.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import com.protoseo.hellodatabase.hibernate.member.Member

interface MemberRepository : JpaRepository<Member, Long>, JpaSpecificationExecutor<Member> {
}
