package com.app.shoppingcart.infrastructure.applicationservice.cart

import com.app.shoppingcart.domain.cart.Cart

interface ApplicationUpdateCartService {

    fun update(cart: Cart): Cart
}