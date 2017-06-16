package ru.kest.traffic

import kotlinx.html.div
import react.RProps
import react.ReactComponentNoState
import react.ReactComponentSpec
import react.dom.ReactDOMBuilder
import react.dom.ReactDOMComponent

/**
 * Represents block of road environment (road, roadside territory)
 *
 * Created by KKharitonov on 16.06.2017.
 */
class RoadCell : ReactDOMComponent<RoadCell.RoadCellProps, ReactComponentNoState>() {
    companion object : ReactComponentSpec<RoadCell, RoadCellProps, ReactComponentNoState>

    init {
        state = ReactComponentNoState()
    }

    override fun ReactDOMBuilder.render() {
        div(classes = "road-cell") {
            + ru.kest.traffic.ROAD_MAP[props.x][props.y].toString()
        }
    }

    data class RoadCellProps(val x : Int, val y : Int) : RProps()
}