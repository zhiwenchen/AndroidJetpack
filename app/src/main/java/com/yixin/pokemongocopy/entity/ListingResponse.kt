package com.yixin.pokemongocopy.entity

data class ListingResponse(
//    val count: Int,
//    val next: String?,
//    val previous: String?,
    val results: List<ListingData>
)

data class ListingData(
    val name: String,
    val url: String
) {
    fun getImageUrl(): String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$index.png"
    }

    override fun toString(): String {
        return "ListingData(name='$name', url='$url')"
    }
}