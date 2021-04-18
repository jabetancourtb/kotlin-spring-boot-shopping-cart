package com.app.shoppingcart.domain.cart

import com.app.shoppingcart.domain.cart.Cart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CartJPARepository: JpaRepository<Cart, UUID> {
}