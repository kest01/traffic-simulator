package ru.kest.traffic.component

import kotlinx.html.div
import react.ReactComponentNoState
import react.ReactComponentSpec
import react.dom.ReactDOMBuilder
import react.dom.ReactDOMComponent
import ru.kest.traffic.ROAD_MAP
import ru.kest.traffic.entity.StreetBlock

/**
 * React Component that represents block of road environment (road, roadside territory)
 *
 * Created by KKharitonov on 16.06.2017.
 */
class StreetBlockComponent : ReactDOMComponent<StreetBlock, ReactComponentNoState>() {
    companion object : ReactComponentSpec<StreetBlockComponent, StreetBlock, ReactComponentNoState>

    init {
        state = ReactComponentNoState()
    }

    override fun ReactDOMBuilder.render() {
        div(classes = "street-block street") {
            + ROAD_MAP[props.x][props.y].toString()
        }
    }

}