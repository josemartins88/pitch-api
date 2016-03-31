package pitch.search

import grails.rest.Resource

@Resource(uri = '/floorTypes', formats=['json', 'xml'])
class FloorType {

    String type
    String description

    static constraints = {
        type blank:false, unique:true
        description blank:false
    }
}
