package com.example.ra.data

data class Movie(
    val id: Int,
    val title: String,
    val director: String,
    val releaseYear: Int,
    val genre: String,
    val image: String,
    val description: String
)

val movies = listOf(
    Movie(
        id = 1,
        title = "El laberinto del fauno",
        director = "Guillermo del Toro",
        releaseYear = 2006,
        genre = "Fantasía",
        image = "https://cinemanahual.mx/wp-content/uploads/2022/11/laberinto-fauno.jpg",
        description = "En 1944, en la España post-guerra civil, una niña llamada Ofelia conoce a un fauno mítico que le asigna tres tareas para demostrar que es la reencarnación de la Princesa Moanna."
    ),
    Movie(
        id = 2,
        title = "Amores perros",
        director = "Alejandro González Iñárritu",
        releaseYear = 2000,
        genre = "Drama",
        image = "https://m.media-amazon.com/images/I/91GB-kpsUpL._AC_UF894,1000_QL80_.jpg",
        description = "Tres historias entrelazadas sobre las vidas de personas y sus perros en la Ciudad de México, conectadas por un accidente automovilístico."
    ),
    Movie(
        id = 3,
        title = "Y tu mamá también",
        director = "Alfonso Cuarón",
        releaseYear = 2001,
        genre = "Drama",
        image = "https://es.web.img3.acsta.net/medias/nmedia/18/79/77/82/19517593.jpg",
        description = "Dos adolescentes y una atractiva mujer mayor se embarcan en un viaje por carretera y aprenden mucho sobre la vida, la amistad y entre ellos."
    ),
    Movie(
        id = 4,
        title = "El secreto de sus ojos",
        director = "Juan José Campanella",
        releaseYear = 2009,
        genre = "Suspenso",
        image = "https://m.media-amazon.com/images/S/pv-target-images/4396cc2ce854e81eb1ffa97433856cc866ebd2cb01f612746633a06dd52809a9.jpg",
        description = "Un consejero legal retirado escribe una novela esperando encontrar cierre para uno de sus casos de homicidio no resueltos y para su amor no correspondido con su superior."
    ),
    Movie(
        id = 5,
        title = "Mar adentro",
        director = "Alejandro Amenábar",
        releaseYear = 2004,
        genre = "Biografía",
        image = "https://es.web.img3.acsta.net/pictures/16/02/08/17/48/343541.jpg",
        description = "La historia real del español Ramón Sampedro, quien luchó durante 30 años para ganar el derecho a terminar su vida con dignidad."
    ),
    Movie(
        id = 6,
        title = "El orfanato",
        director = "J.A. Bayona",
        releaseYear = 2007,
        genre = "Terror",
        image = "https://www.aceprensa.com/wp-content/uploads/2007/10/6537-0-683x1024.jpg",
        description = "Una mujer lleva a su familia de vuelta a su hogar de la infancia, que solía ser un orfanato, y comienza a descubrir la trágica historia de la casa."
    ),
    Movie(
        id = 7,
        title = "Relatos salvajes",
        director = "Damián Szifron",
        releaseYear = 2014,
        genre = "Comedia",
        image = "https://pics.filmaffinity.com/relatos_salvajes-102488639-mmed.jpg",
        description = "Una película de antología con seis historias independientes que exploran los extremos del comportamiento humano involucrando angustia, ira y venganza."
    ),
    Movie(
        id = 8,
        title = "Volver",
        director = "Pedro Almodóvar",
        releaseYear = 2006,
        genre = "Drama",
        image = "https://gofresyole.wordpress.com/wp-content/uploads/2017/03/volver-pedro-almodovar-peliculas-31225316-1024-768.jpeg",
        description = "Después de su muerte, una madre regresa a su pueblo natal para arreglar las situaciones que no pudo resolver durante su vida."
    )
)
