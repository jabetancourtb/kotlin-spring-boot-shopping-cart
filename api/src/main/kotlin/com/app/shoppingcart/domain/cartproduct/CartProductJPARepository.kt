package com.app.shoppingcart.domain.cartproduct

import com.app.shoppingcart.domain.cartproduct.CartProduct
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CartProductJPARepository: JpaRepository<CartProduct, UUID> {

    @Query(value = "SELECT CPR.id, CPR.product_id, CPR.cart_id, CPR.product_quantity, CPR.total_product "
            + " FROM product PR "
            + " INNER JOIN cart_product CPR    ON PR.ID = CPR.product_id "
            + " INNER JOIN cart CR             ON CR.id = CPR.cart_id "
            + " WHERE CR.id = :cartId", nativeQuery = true)
    fun findAllProductsByCartId(cartId: UUID): List<CartProduct>
}