package com.c23pr591.adventour.core.utils

import com.c23pr591.adventour.core.data.local.entity.GunungEntity
import com.c23pr591.adventour.core.data.local.entity.UserDataEntity
import com.c23pr591.adventour.core.data.network.response.UserDataResponseItem
import com.c23pr591.adventour.core.domain.model.UserData

object UserDataMapper {
    fun mapResponsesToEntities(input: List<UserDataResponseItem>): List<UserDataEntity> {
        val dataList = ArrayList<UserDataEntity>()
        input.map {
            val data = UserDataEntity(
                id = it.id,
                nama = it.nama,
                jenisKelamin = it.jenisKelamin,
                umur = it.umur,
                domisili = it.domisili,
                pengalaman = it.pengalaman,
                email = it.email,
                level = it.level
            )
            dataList.add(data)
        }
        return dataList
    }

    fun mapEntitiesToDomain(input: List<UserDataEntity>): List<UserData> =
        input.map {
            UserData(
                id = it.id,
                nama = it.nama,
                jenisKelamin = it.jenisKelamin,
                umur = it.umur,
                domisili = it.domisili,
                pengalaman = it.pengalaman,
                email = it.email,
                level = it.level
            )
        }

}