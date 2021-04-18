package com.app.shoppingcart.infrastructure.controllers

import com.app.shoppingcart.domain.product.Product
import com.app.shoppingcart.infrastructure.service.product.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("product")
class ProductController(@Autowired val productService: ProductService? = null) {

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: UUID): ResponseEntity<Optional<Product>> {
        return try {
            ResponseEntity(productService!!.findById(id), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<Product>> {
        return try {
            ResponseEntity(productService!!.findAll(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping
    fun save(@RequestBody product: Product): ResponseEntity<Product> {
        return try {
            ResponseEntity(productService!!.save(product), HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping
    fun update(@RequestBody product: Product): ResponseEntity<Any> {
        return try {
            productService!!.save(product)
            ResponseEntity(HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: UUID): ResponseEntity<Any> {
        return try {
            productService!!.deleteById(id)
            ResponseEntity(HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}