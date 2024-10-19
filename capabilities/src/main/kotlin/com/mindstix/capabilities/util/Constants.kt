/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

package com.mindstix.capabilities.util

import com.mindstix.core.R

/**
 * Object containing constants used in the application.
 *
 * @author Alhaj SIddiqui
 */
object Constants {
    // Constant for named arguments in Hilt to avoid the conflict with different provider.
    const val NETWORK_NAMED_ARGUMENTS = "mindstix_network_args"
    const val DEFAULT_EMPTY_STRING = ""
    val DEFAULT_PRODUCT_IMAGE = listOf(
        R.drawable.ic_skinfirst,
        R.drawable.ic_hydratant,
        R.drawable.ic_concentarte,
        R.drawable.ic_serium,
        R.drawable.ic_biorest,
    )

    val DEFAULT_BEAUTY_PRODUCT_IMAGE = listOf(
        R.drawable.ic_product_6,
        R.drawable.ic_product_7,
        R.drawable.ic_product_8,
        R.drawable.ic_product_2,
        R.drawable.ic_product_3,
        R.drawable.ic_product_1,
        R.drawable.ic_product_4,
        R.drawable.ic_product_5,
    )
    val DEFAULT_LIST_URLS = listOf(
        "https://cyzone.tiendabelcorp.cl/contorno-de-ojos-eye-detox-skin-first/p",
        "https://lbel.tiendabelcorp.cl/set-acido-hialuronico-retinol/p",
        "https://lbel.tiendabelcorp.cl/set-nocturne-rostro-y-ojos-cl/p",
        "https://lbel.tiendabelcorp.cl/concentre-total-rostro-crema-antiedad-cc/p",
        "https://lbel.tiendabelcorp.cl/botanology-locion-hidratante-corporal-400-ml/p"
    )

    val DEFAULT_BEAUTY_LIST_URLS = listOf(
        "https://lbelmy.store/en/collections/maquillaje-lbel-usa/products/lbel-clarite-maquillaje-champagne",
        "https://lbelmy.store/en/collections/maquillaje-lbel-usa/products/esika-duo-tattoo-intense-nude-fortaleza",
        "https://lbel.tiendabelcorp.cl/devos-magnetic-seduction-perfume-para-hombre-100-ml/p",
        "https://dibenisa.com/collections/esika-usa/products/esika-usa-mega-full-size-mascara-pestanas",
        "https://dibenisa.com/collections/lbel-usa/products/lbel-usa-leclat-perfume-mujer",
        "https://cyzone.tiendabelcorp.cl/perfume-de-mujer-sweet-black/p"
    )

}
