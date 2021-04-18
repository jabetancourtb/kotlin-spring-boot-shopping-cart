package com.app.shoppingcart.infrastructure.service.cart

import com.app.shoppingcart.domain.cart.Cart
import com.app.shoppingcart.domain.cart.CartJPARepository
import com.app.shoppingcart.domain.cart.CartState
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CartServiceImpl(@Autowired val cartJPARepository: CartJPARepository? = null): CartService {

    override fun findById(id: UUID): Optional<Cart> {
        try {
            return cartJPARepository!!.findById(id)
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }

    override fun save(cart: Cart): Cart {
        try {
            cart.updateCreatedAt()
            cart.updatePurchaseStatus(CartState.EMPTY.toString())
            println(cart)
            return cartJPARepository!!.save(cart)
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }

    override fun update(cart: Cart): Cart {
        try {
            return cartJPARepository!!.save(cart)
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }


    override fun deleteById(id: UUID) {
        try {
            return cartJPARepository!!.deleteById(id)
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }
}