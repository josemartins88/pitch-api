package pitch.search

import grails.rest.Resource

@Resource(uri = '/venues', formats=['json', 'xml'])
class Venue {

    String name
    String description
    String fullAddress
    Contact contact
    static hasMany = [pitches: Pitch]

    static constraints = {
        name blank:false
        description blank:false
        fullAddress blank:false
        contact nullable:false
    }
}
