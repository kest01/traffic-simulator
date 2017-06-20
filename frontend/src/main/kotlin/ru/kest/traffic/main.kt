package ru.kest.traffic

import kotlinx.html.div
import react.dom.ReactDOM
import react.dom.render
import ru.kest.traffic.component.Application
import ru.kest.traffic.road.RoadMap
import kotlin.browser.document


fun main(args: Array<String>) {
    runtime.wrappers.require("main.css")

    ReactDOM.render(document.getElementById("content")) {
        div {
            Application(Application.ApplicationProps(RoadMap()))
        }
    }
}
