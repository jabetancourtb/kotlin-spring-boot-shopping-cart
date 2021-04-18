package com.app.shoppingcart.infrastructure.applicationservice.cartproduct

import com.app.shoppingcart.domain.cart.CartState
import com.app.shoppingcart.domain.cartproduct.CartProduct
import com.app.shoppingcart.infrastructure.applicationservice.cart.ApplicationUpdateCartService
import com.app.shoppingcart.infrastructure.service.cart.CartService
import com.app.shoppingcart.infrastructure.service.cartproduct.CartProductService
import com.app.shoppingcart.infrastructure.service.product.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ApplicationSaveCartProductServiceImpl(@Autowired val cartProductService: CartProductService? = null
                                            , @Autowired val productService: ProductService? = null
                                            , @Autowired val cartService: CartService? = null
                                            , @Autowired val applicationUpdateCartService: ApplicationUpdateCartService? = null)
    : ApplicationSaveCartProductService
{

    override fun saveProduct(cartProduct: CartProduct): CartProduct {
        val product = productService!!.findById(cartProduct.product!!.id)
        var totalProduct = 0.0

        if(product.isPresent) {
            totalProduct = if(product.get().discounted) {
                (product.get().price / 2) * cartProduct.productQuantity
            } else {
                product.get().price * cartProduct.productQuantity
            }
        }

        cartProduct.updateTotalProduct(totalProduct)

        val savedProduct = cartProductService!!.saveProduct(cartProduct)

        val cart = cartProduct.cartId?.let { cartService!!.findById(it) }
        cart!!.get().updatePurchaseStatus(CartState.PENDING.toString())
        applicationUpdateCartService!!.update(cart.get())

        return savedProduct
    }
}