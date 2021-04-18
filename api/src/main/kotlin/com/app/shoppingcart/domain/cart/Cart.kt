package com.app.shoppingcart.domain.cart

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "cart")
data class Cart(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: UUID = UUID.randomUUID()
                , var createdAt: LocalDateTime? = null
                , var purchaseDate: LocalDateTime? = null
                , var purchaseStatus: String? = ""
                , var total: Double = 0.0) {

    fun updateCreatedAt() {
        createdAt = LocalDateTime.now()
    }

    fun updatePurchaseDate() {
        purchaseDate = LocalDateTime.now()
    }

    fun updatePurchaseStatus(newStatus: String) {
        purchaseStatus = newStatus
    }

    fun updateTotal(totalProducts: Double) {
        total = totalProducts
    }
}