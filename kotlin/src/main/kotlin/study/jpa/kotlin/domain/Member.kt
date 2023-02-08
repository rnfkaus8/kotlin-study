package study.jpa.kotlin.domain

import jakarta.persistence.*

@Entity
class Member(
  name: String,
  address: Address
) {

  @Id
  @GeneratedValue
  @Column(name = "member_id")
  var id: Long? = null

  var name: String = name
    protected set

  @Embedded
  var address: Address = address
    protected set

  @OneToMany(mappedBy = "member")
  var orders: MutableList<Order> = arrayListOf()
}