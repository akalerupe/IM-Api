package com.example.InstitutionManagement.model

import javax.persistence.*

@Entity
@Table(name="institution")

data class Institution(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
        @Column(name = "name", unique = true, nullable = false)
        val name:String,
        val location:String,
        val population:Int,
        )