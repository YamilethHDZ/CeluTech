package com.example.celutech2.model

class RecentlyViewed(
    var name: String,
    var description: String,
    var price: String,
    var quantity: String,
    var unit: String,
    var imageUrl: Int,
    var bigImageUrl: Int
) {

    // Getter and Setter for bigImageUrl
    var bigimageurl: Int
        get() = bigImageUrl
        set(value) {
            bigImageUrl = value
        }
}