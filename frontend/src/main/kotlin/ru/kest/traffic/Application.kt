package ru.kest.traffic

import kotlinx.html.div
import kotlinx.html.h1
import react.RState
import react.ReactComponentNoProps
import react.ReactComponentSpec
import react.dom.ReactDOMBuilder
import react.dom.ReactDOMComponent

class Application : ReactDOMComponent<ReactComponentNoProps, ApplicationPageState>() {
    companion object : ReactComponentSpec<Application, ReactComponentNoProps, ApplicationPageState>

    init {
        state = ApplicationPageState("Hello world")
    }

    override fun ReactDOMBuilder.render() {
        div {
            h1 { +"Traffic simulator" }
            div("road-area") {
                for(i in ROAD_MAP.indices) run {
                    div(classes = "road-line") {
                        for (j in ROAD_MAP[i].indices) {
                            div(classes = "road-block") {
                                + getRoadChar(ru.kest.traffic.ROAD_MAP[i][j])
                            }
                        }
                    }
                }
            }
        }
    }
}

fun getRoadChar(c : Char) = if (c == ' ') " " else c.toString()

class ApplicationPageState(var message: String) : RState
