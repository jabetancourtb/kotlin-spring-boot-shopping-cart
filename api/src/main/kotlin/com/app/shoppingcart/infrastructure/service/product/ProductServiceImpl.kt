package com.app.shoppingcart.infrastructure.service.product

import com.app.shoppingcart.domain.product.Product
import com.app.shoppingcart.domain.product.ProductJPARepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(@Autowired val productJPARepository: ProductJPARepository? = null): ProductService {

    override fun findById(id: UUID): Optional<Product> {
        try {
            return productJPARepository!!.findById(id)
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }

    override fun findAll(): List<Product> {
        try {
            return productJPARepository!!.findAll()
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }

    override fun save(product: Product): Product {
        try {
            return productJPARepository!!.save(product)
        } catch(e: Exception) {
            throw Exception(e.message)
        }
    }

    override fun deleteById(id: UUID) {
        try {
             productJPARepository!!.deleteById(id)
        } catch(e: Exception) {
            println(e.message)
            throw Exception(e.message)
        }
    }
}