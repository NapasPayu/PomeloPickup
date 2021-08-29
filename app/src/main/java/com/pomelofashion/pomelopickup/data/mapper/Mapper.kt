package com.pomelofashion.pomelopickup.data.mapper

interface Mapper<E, D> {
    fun mapFromEntity(entity: E): D
}