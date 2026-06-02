package com.glycin.model

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserRequest(
    val name: String,
    val score: Int,
    val email: String? = null,
    val website: String? = null,
    val dearHacker: String? = null,
)
