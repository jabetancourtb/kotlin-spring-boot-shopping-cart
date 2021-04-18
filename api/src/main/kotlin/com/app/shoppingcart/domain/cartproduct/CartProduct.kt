package com.app.shoppingcart.domain.cartproduct

import com.app.shoppingcart.domain.product.Product
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "cart_product")
data class CartProduct( val productQuantity: Int = 0
                        , var totalProduct: Double = 0.0
                        , val cartId: UUID? = null
                        , @ManyToOne
                            @JoinColumn(name = "product_id")
                                val product: Product? = null) {

    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID()

    fun updateTotalProduct(total: Double) {
        totalProduct = total
    }
}