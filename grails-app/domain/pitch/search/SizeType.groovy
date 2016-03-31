package pitch.search

import grails.rest.Resource

@Resource(uri = '/sizeTypes', formats=['json', 'xml'])
class SizeType {

    String type

    static constraints = {
        type blank:false, unique:true
    }
}
