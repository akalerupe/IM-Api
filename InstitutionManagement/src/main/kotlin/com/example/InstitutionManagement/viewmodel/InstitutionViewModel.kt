package com.example.InstitutionManagement.viewmodel

import Institution
import com.example.InstitutionManagement.repository.InstitutionRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class InstitutionViewModel(val repository: InstitutionRepository) {
    fun getAllInstitutions(): List<Institution> = repository.findAll()

    fun getInstitutionByID(id: Long): Institution = repository.findByIdOrNull(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun createInstitution(institution: Institution): Institution = repository.save(institution)

    fun deleteInstitution(id: Long) {
        if (repository.existsById(id)) repository.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun editInstitution(id: Long, institution: Institution): Institution {
        return if (repository.existsById(id)) {
            institution.id = id
            repository.save(institution)
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

}