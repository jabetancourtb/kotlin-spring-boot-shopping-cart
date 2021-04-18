package com.app.shoppingcart.infrastructure.applicationservice.cart

import com.app.shoppingcart.domain.cart.Cart
import com.app.shoppingcart.domain.cart.CartState
import com.app.shoppingcart.infrastructure.service.cart.CartService
import com.app.shoppingcart.infrastructure.service.cartproduct.CartProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ApplicationUpdateCartServiceImpl(@Autowired val cartService: CartService? = null
                                       , @Autowired val cartProductService: CartProductService? = null)
    : ApplicationUpdateCartService
{
    override fun update(cart: Cart): Cart {
        val cartProduct = cartProductService!!.findAllProductsByCartId(cart.id)
        var totalProducts = 0.0

        when {
            cartProduct.isEmpty() -> {
                cart.updatePurchaseStatus(CartState.EMPTY.toString())
            }
            cart.purchaseStatus == CartState.PENDING.toString() -> {
                for(cp in cartProduct) {
                    totalProducts +=  cp.totalProduct
                }

                cart.updateTotal(totalProducts)
            }
            cart.purchaseStatus == CartState.COMPLETE.toString() -> {
                cart.updatePurchaseDate()
            }
        }

        return cartService!!.update(cart)
    }
}