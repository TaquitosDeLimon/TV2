package com.example.ra.data

import com.example.ra.R

data class Student(
    val nombre: String,
//    val grado: String,
//    val grupo: String,
    val foto: Int
)

// Información de los integrantes
val students = listOf(
    Student("Anahí Guadalupe Álvarez Gómez", R.drawable.anahi),
    Student("Manrique Emmanuel Sánchez Lara", R.drawable.manrique),
    Student("Daniel Alejandro Trujillo López", R.drawable.daniel)
)
