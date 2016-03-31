import pitch.search.Contact
import pitch.search.Pitch
import pitch.search.SizeType
import pitch.search.Venue

class BootStrap {

    def init = { servletContext ->

        def fiveOnFive = new SizeType(type: "5vs5")
        def sevenOnSeven = new SizeType(type: "7vs7")
        def elevenOnEleven = new SizeType(type: "11vs11")
        fiveOnFive.save()
        sevenOnSeven.save()
        elevenOnEleven.save()


        def venue1 = new Venue(name: "FCP", description: "FC Porto", fullAddress: "Antas", contact : new Contact(telephone: "259322746", email: "example@email.com")).save()
        venue1.addToPitches(new Pitch(name: "Pitch1", description: "shitty pitch", ballIncluded: false, bibsIncluded: false, length: 50, width: 20,
                sizeType: fiveOnFive, latitude: 100, longitude: 100)).save();
        venue1.addToPitches(new Pitch(name: "Pitch2", description: "brand new pitch", ballIncluded: true, bibsIncluded: true, length: 120, width: 55,
                sizeType: fiveOnFive, latitude: 100, longitude: 100)).save();


        def venue2 = new Venue(name: "SLB", description: "SL Benfica", fullAddress: "Luz", contact : new Contact(telephone: "259322747", email: "example2@email.com")).save()
        venue2.addToPitches(new Pitch(name: "Pitch3", description: "merda", ballIncluded: false, bibsIncluded: false, length: 50, width: 20,
                sizeType: fiveOnFive, latitude: 100, longitude: 100)).save();

        venue2.addToPitches(new Pitch(name: "Pitch4", description: "campo de batatas", ballIncluded: false, bibsIncluded: false, length: 20, width: 10,
                sizeType: fiveOnFive, latitude: 100, longitude: 100)).save();
    }
    def destroy = {
    }
}
