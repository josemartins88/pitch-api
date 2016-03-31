package pitch.search

import grails.rest.Resource

@Resource(uri = '/pitches', formats=['json', 'xml'])
class Pitch {

    static belongsTo = [venue: Venue]
    String name
    String description
    Integer length
    Integer width
    Boolean bibsIncluded
    Boolean ballIncluded
    Long latitude
    Long longitude
    FloorType floorType
    SizeType sizeType

    static constraints = {
        name blank:false
        description blank:false
        floorType nullable: true
        latitude blank:false
        longitude blank:false
    }
}
