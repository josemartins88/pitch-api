package pitch.search

import grails.rest.Resource

@Resource(uri = '/formats', formats=['json', 'xml'])
class Format {

    String type

    static constraints = {
        type blank:false, unique:true
    }
}
