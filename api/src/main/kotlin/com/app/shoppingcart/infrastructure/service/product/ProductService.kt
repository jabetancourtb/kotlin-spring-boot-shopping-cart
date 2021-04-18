package com.app.shoppingcart.infrastructure.service.product

import com.app.shoppingcart.domain.product.Product
import java.util.*

interface ProductService {

    fun findById(id: UUID): Optional<Product>

    fun findAll(): List<Product>

    fun save(product: Product): Product

    fun deleteById(id: UUID)
}