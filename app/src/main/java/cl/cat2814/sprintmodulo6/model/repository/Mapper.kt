package cl.cat2814.sprintmodulo6.model.repository

import cl.cat2814.sprintmodulo6.model.localData.SmartphoneEntity
import cl.cat2814.sprintmodulo6.model.remoteData.Smartphone

fun Smartphone.toEntity(): SmartphoneEntity =
    SmartphoneEntity(this.id, this.name, this.price, this.image)
