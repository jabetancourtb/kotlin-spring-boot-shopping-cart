package com.app.shoppingcart.infrastructure.service.cartproduct

import com.app.shoppingcart.domain.cartproduct.CartProduct
import com.app.shoppingcart.domain.cartproduct.CartProductJPARepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CartProductServiceImpl(@Autowired val cartProductJPARepository: CartProductJPARepository? = null): CartProductService {

    override fun findAllProductsByCartId(cartId: UUID): List<CartProduct> {
        try {
            return cartProductJPARepository!!.findAllProductsByCartId(cartId)
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }

    override fun saveProduct(cartProduct: CartProduct): CartProduct {
        try {
            return cartProductJPARepository!!.save(cartProduct)
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }

    override fun deleteProductById(productId: UUID) {
        try {
            return cartProductJPARepository!!.deleteById(productId)
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }
}