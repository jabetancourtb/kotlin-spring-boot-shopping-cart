package com.app.shoppingcart.infrastructure.service.cartproduct

import com.app.shoppingcart.domain.cartproduct.CartProduct
import java.util.*

interface CartProductService {

    fun findAllProductsByCartId(cartId: UUID): List<CartProduct>

    fun saveProduct(cartProduct: CartProduct): CartProduct

    fun deleteProductById(id: UUID)
}