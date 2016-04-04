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
    Boolean showersIncluded
    Long latitude
    Long longitude
    String city
    FloorType floorType
    Format format

    static constraints = {
        name blank:false
        description blank:false
        floorType nullable: true
        format nullable:false
        latitude blank:false
        longitude blank:false
        length min:0
        width min:0
        pricePerHour nullable:false, min:0
        city blank:false
    }
}
