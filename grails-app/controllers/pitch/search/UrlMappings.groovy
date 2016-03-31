package pitch.search

class UrlMappings {

    static mappings = {
        "/pitches"(resources: "pitch")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
