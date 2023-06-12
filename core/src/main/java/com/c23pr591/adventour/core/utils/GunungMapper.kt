package com.c23pr591.adventour.core.utils

import com.c23pr591.adventour.core.data.local.entity.GunungEntity
import com.c23pr591.adventour.core.data.network.response.GunungListResponse
import com.c23pr591.adventour.core.domain.model.Gunung

object GunungMapper {
    fun mapResponsesToEntities(input: List<GunungListResponse>): List<GunungEntity> {
        val dataList = ArrayList<GunungEntity>()
        input.map {
            val data = GunungEntity(
                id = it.id,
                daerah = it.daerah,
                nama = it.nama,
                ketinggian = it.ketinggian,
                lokasi = it.lokasi,
                trek = it.trek,
                jalur = it.jalur,
                simaksi = it.simaksi,
                level = it.level,
                rating = it.rating,
                imageUrl = it.imageUrl,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt,
            )
            dataList.add(data)
        }
        return dataList
    }

    fun mapEntitiesToDomain(input: List<GunungEntity>): List<Gunung> =
        input.map {
            Gunung(
                id = it.id,
                daerah = it.daerah,
                nama = it.nama,
                ketinggian = it.ketinggian,
                lokasi = it.lokasi,
                trek = it.trek,
                jalur = it.jalur,
                simaksi = it.simaksi,
                level = it.level,
                rating = it.rating,
                imageUrl = it.imageUrl,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt,
            )
        }

}