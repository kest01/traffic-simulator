package ru.kest.traffic

import kotlinx.html.div
import kotlinx.html.h1
import react.ReactComponentNoProps
import react.ReactComponentNoState
import react.ReactComponentSpec
import react.dom.ReactDOMBuilder
import react.dom.ReactDOMComponent

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
            div("road-area") {
                for(x in ROAD_MAP.indices) run {
                    div(classes = "road-line") {
                        for (y in ROAD_MAP[x].indices) {
                            RoadCell(RoadCell.RoadCellProps(x, y))
                        }
                    }
                }
            }
        }
    }
}



