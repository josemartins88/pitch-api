package pitch.search

class Contact {

    String telephone
    String email
    static belongsTo = Venue

    static constraints = {
        telephone blank:false
        email email:true
    }
}
