package pitch.search

import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class PitchController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        def searchCriteria = Pitch.createCriteria()
        def results = searchCriteria {
            if (params.minPrice) {
                ge("pricePerHour", params.int("minPrice"))
            }
            if (params.maxPrice) {
                le("pricePerHour", params.int("maxPrice"))
            }
            if (params.minWidth) {
                ge("width", params.int("minWidth"))
            }
            if (params.maxWidth) {
                le("width", params.int("maxWidth"))
            }
            if (params.minLength) {
                ge("length", params.int("minLength"))
            }
            if (params.maxLength) {
                le("length", params.int("maxLength"))
            }
            if (params.bibsIncluded != null) {
                eq("bibsIncluded", params.boolean("bibsIncluded"))
            }
            if (params.ballIncluded != null) {
                eq("ballIncluded", params.boolean("ballIncluded"))
            }
        }
        respond results
    }

    def show(Pitch pitch) {
        respond pitch
    }

    @Transactional
    def save(Pitch pitch) {
        if (pitch == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (pitch.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pitch.errors, view:'create'
            return
        }

        pitch.save flush:true

        respond pitch, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Pitch pitch) {
        if (pitch == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (pitch.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pitch.errors, view:'edit'
            return
        }

        pitch.save flush:true

        respond pitch, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Pitch pitch) {

        if (pitch == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        pitch.delete flush:true

        render status: NO_CONTENT
    }
}
