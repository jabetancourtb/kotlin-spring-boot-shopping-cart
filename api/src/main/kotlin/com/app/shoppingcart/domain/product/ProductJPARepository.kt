package com.app.shoppingcart.domain.product

import com.app.shoppingcart.domain.product.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductJPARepository: JpaRepository<Product, UUID>{
}