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
        R.drawable.ic_essikaproduct,
        R.drawable.ic_productimage,
        R.drawable.ic_vitaminc,
        R.drawable.ic_pillogram,
        R.drawable.ic_minimalist,
    )
    val DEFAULT_LIST_URLS = listOf(
        "https://cyzone.tiendabelcorp.cl/contorno-de-ojos-eye-detox-skin-first/p",
        "https://lbel.tiendabelcorp.cl/set-acido-hialuronico-retinol/p",
        "https://lbel.tiendabelcorp.cl/set-nocturne-rostro-y-ojos-cl/p",
        "https://lbel.tiendabelcorp.cl/concentre-total-rostro-crema-antiedad-cc/p",
        "https://lbel.tiendabelcorp.cl/botanology-locion-hidratante-corporal-400-ml/p"
    )

}
