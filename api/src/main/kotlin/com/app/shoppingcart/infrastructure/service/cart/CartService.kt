package com.app.shoppingcart.infrastructure.service.cart

import com.app.shoppingcart.domain.cart.Cart
import java.util.*

interface CartService {

    fun findById(id: UUID): Optional<Cart>

    fun save(cart: Cart): Cart

    fun update(cart: Cart): Cart

    fun deleteById(id: UUID)
}