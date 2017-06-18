package ru.kest.traffic.component

import kotlinx.html.div
import kotlinx.html.h1
import react.*
import react.dom.ReactDOMBuilder
import react.dom.ReactDOMComponent
import ru.kest.traffic.ROAD_MAP
import ru.kest.traffic.entity.StreetBlock

/**
 * Base Application component
 *
 * Created by KKharitonov on 16.06.2017.
 */
class Application : ReactDOMComponent<ReactComponentNoProps, ReactComponentNoState>() {
    companion object : ReactComponentSpec<Application, ReactComponentNoProps, ReactComponentNoState>

    init {
        state = ReactComponentNoState()
    }


    override fun ReactDOMBuilder.render() {
        div {
            h1 { +"Traffic simulator" }
            div("street-area") {
                for(x in ROAD_MAP.indices) run {
                    div(classes = "street-line") {
                        for (y in ROAD_MAP[x].indices) {
                            StreetBlockComponent(StreetBlock(x, y))
                        }
                    }
                }
            }
            div("test-content")
        }
    }
}



