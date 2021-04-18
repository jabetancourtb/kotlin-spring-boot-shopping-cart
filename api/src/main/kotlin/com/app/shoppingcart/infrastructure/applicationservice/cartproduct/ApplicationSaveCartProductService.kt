package com.app.shoppingcart.infrastructure.applicationservice.cartproduct

import com.app.shoppingcart.domain.cartproduct.CartProduct

interface ApplicationSaveCartProductService {

    fun saveProduct(cartProduct: CartProduct): CartProduct
}