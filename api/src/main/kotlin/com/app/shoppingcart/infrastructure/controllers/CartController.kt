package com.app.shoppingcart.infrastructure.controllers

import com.app.shoppingcart.domain.cart.Cart
import com.app.shoppingcart.infrastructure.applicationservice.cart.ApplicationUpdateCartService
import com.app.shoppingcart.infrastructure.service.cart.CartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("cart")
class CartController(@Autowired val cartService: CartService? = null
                    , @Autowired val applicationSaveCartService: ApplicationUpdateCartService? = null) {

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: UUID): ResponseEntity<Optional<Cart>>
    {
        return try {
            ResponseEntity(cartService!!.findById(id), HttpStatus.CREATED)
        } catch (e: Exception) {
            println(e)
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping
    fun save(@RequestBody cart: Cart): ResponseEntity<Cart>
    {
        return try {
            ResponseEntity(cartService!!.save(cart), HttpStatus.CREATED)
        } catch (e: Exception) {
            println(e)
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping
    fun update(@RequestBody cart: Cart): ResponseEntity<Cart>
    {
        return try {
            applicationSaveCartService!!.update(cart)
            ResponseEntity(HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: UUID): ResponseEntity<Any>
    {
        return try {
            cartService!!.deleteById(id)
            ResponseEntity(HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}