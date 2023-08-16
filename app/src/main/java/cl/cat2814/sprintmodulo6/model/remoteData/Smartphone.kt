package cl.cat2814.sprintmodulo6.model.remoteData

data class Smartphone(
    val id: Int,
    val name: String,
    val price: Int,
    val image: String
)

data class SmartphoneDetail(
    val id: Int,
    val name: String,
    val price: Int,
    val image: String,
    val description:String,
    val lastPrice:Int,
    val credit: Boolean
)
