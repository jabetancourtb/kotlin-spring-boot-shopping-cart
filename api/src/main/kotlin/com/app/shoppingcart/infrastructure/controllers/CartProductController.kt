package com.app.shoppingcart.infrastructure.controllers

import com.app.shoppingcart.domain.cartproduct.CartProduct
import com.app.shoppingcart.infrastructure.applicationservice.cartproduct.ApplicationSaveCartProductService
import com.app.shoppingcart.infrastructure.service.cartproduct.CartProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("cart-product")
class CartProductController(@Autowired val cartProductService: CartProductService? = null
                            , @Autowired val applicationSaveCartProductService: ApplicationSaveCartProductService? = null)
{

    @GetMapping("/{cartId}")
    fun findAllProductsByCartId(@PathVariable("cartId") cartId: UUID): ResponseEntity<List<CartProduct>>
    {
        return try {
            ResponseEntity(cartProductService!!.findAllProductsByCartId(cartId), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping
    fun saveProduct(@RequestBody cartProduct: CartProduct): ResponseEntity<CartProduct>
    {
        return try {
            ResponseEntity(applicationSaveCartProductService!!.saveProduct(cartProduct), HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping
    fun updateProduct(@RequestBody cartProduct: CartProduct): ResponseEntity<Any>
    {
        return try {
            applicationSaveCartProductService!!.saveProduct(cartProduct)
            ResponseEntity(HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{productId}")
    fun deleteById(@PathVariable("productId") productId: UUID): ResponseEntity<Any>
    {
        return try {
            cartProductService!!.deleteProductById(productId)
            ResponseEntity(HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}