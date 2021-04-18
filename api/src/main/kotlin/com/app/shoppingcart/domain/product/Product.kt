package com.app.shoppingcart.domain.product

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "product")
data class Product(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: UUID = UUID.randomUUID()
                   , val name: String = ""
                   , val description: String = ""
                   , val price: Double = 0.0
                   , val discounted: Boolean = false) {

}