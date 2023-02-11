package study.jpa.kotlin.domain

import jakarta.persistence.*
import jakarta.persistence.FetchType.LAZY

@Entity
class Delivery(
  order: Order,
  address: Address,
  status: DeliveryStatus
) {
  @Id
  @GeneratedValue
  @Column(name = "delivery_id")
  var id: Long? = null

  @OneToOne(mappedBy = "delivery", fetch = LAZY)
  var order: Order = order

  @Embedded
  var address: Address = address

  @Enumerated(EnumType.STRING)
  var status: DeliveryStatus = status
}