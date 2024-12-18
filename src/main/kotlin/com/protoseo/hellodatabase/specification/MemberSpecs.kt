package com.protoseo.hellodatabase.specification

import org.springframework.data.jpa.domain.Specification
import com.protoseo.hellodatabase.hibernate.member.Member

class MemberSpecs {

    companion object {
        fun isManMember(): Specification<Member> {
            return Specification { root, query, cb ->
                cb.equal(root.get<Boolean>("gender"), true)
            }
        }

        fun lessThan18Member(): Specification<Member> {
            return Specification { root, query, cb ->
                cb.lessThan(root.get("age"), 18)
            }
        }

    }
}
