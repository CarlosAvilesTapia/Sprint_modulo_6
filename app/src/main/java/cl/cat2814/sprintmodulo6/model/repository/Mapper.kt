package cl.cat2814.sprintmodulo6.model.repository

import cl.cat2814.sprintmodulo6.model.localData.SmartphoneDetailEntity
import cl.cat2814.sprintmodulo6.model.localData.SmartphoneEntity
import cl.cat2814.sprintmodulo6.model.remoteData.Smartphone
import cl.cat2814.sprintmodulo6.model.remoteData.SmartphoneDetail

fun Smartphone.toEntity(): SmartphoneEntity = SmartphoneEntity(
    this.id,
    this.name,
    this.price,
    this.image)

fun SmartphoneDetail.toDetailEntity(): SmartphoneDetailEntity = SmartphoneDetailEntity(
    this.id,
    this.name,
    this.price,
    this.image,
    this.description,
    this.lastPrice,
    this.credit
)
