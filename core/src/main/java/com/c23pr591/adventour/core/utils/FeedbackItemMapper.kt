package com.c23pr591.adventour.core.utils

import com.c23pr591.adventour.core.data.local.entity.FeedbackItemEntity
import com.c23pr591.adventour.core.data.network.response.FeedbackItemResponse
import com.c23pr591.adventour.core.data.network.response.UserItemResponse
import com.c23pr591.adventour.core.domain.model.FeedbackItem
import com.c23pr591.adventour.core.domain.model.User

object FeedbackItemMapper {
    fun mapResponsesToEntities(input: List<FeedbackItemResponse>): List<FeedbackItemEntity> {
        val dataList = ArrayList<FeedbackItemEntity>()
        input.map {
            val data = FeedbackItemEntity(
                id = it.id,
                gunungId = it.gunungId,
                userId = it.userId,
                user = mapResponseToDomain(it.user),
                rating = it.rating,
                review = it.review,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt
            )
            dataList.add(data)
        }
        return dataList
    }

    fun mapEntitiesToDomain(input: List<FeedbackItemEntity>): List<FeedbackItem> =
        input.map {
            FeedbackItem(
                id = it.id,
                gunungId = it.gunungId,
                userId = it.userId,
                user = it.user,
                rating = it.rating,
                review = it.review,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt
            )
        }

    private fun mapResponseToDomain(input: UserItemResponse?): User? =

        input?.let {
            User(
                id = it.id,
                nama = input.nama,
                domisili = input.domisili
            )
        }


}