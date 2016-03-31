package pitch.search

class Pitch {

    static belongsTo = [venue: Venue]
    String name
    String description
    Integer length
    Integer width
    Integer pricePerHour
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
        length min:0
        width min:0
        pricePerHour nullable:false, min:0
    }
}
