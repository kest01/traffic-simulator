package ru.kest.traffic.component

import kotlinx.html.div
import kotlinx.html.h1
import react.*
import react.dom.ReactDOMBuilder
import react.dom.ReactDOMComponent
import ru.kest.traffic.entity.RoadMap
import ru.kest.traffic.entity.StreetBlock

/**
 * Base Application component
 *
 * Created by KKharitonov on 16.06.2017.
 */
class Application : ReactDOMComponent<Application.ApplicationProps, ReactComponentNoState>() {
    companion object : ReactComponentSpec<Application, ApplicationProps, ReactComponentNoState>

    init {
        state = ReactComponentNoState()
    }


    override fun ReactDOMBuilder.render() {
        div {
            h1 { +"Traffic simulator" }
            div("street-area") {
                for(y in 0..props.map.ySize - 1) run {
                    div(classes = "street-line") {
                        for (x in 0..props.map.xSize - 1) {
                            StreetBlockComponent(StreetBlock(props.map, x, y))
                        }
                    }
                }
            }
            div {
                div("street-block") {
                    div("test-content")
                }
            }
        }
    }

    class ApplicationProps(val map : RoadMap) : RProps()
}



