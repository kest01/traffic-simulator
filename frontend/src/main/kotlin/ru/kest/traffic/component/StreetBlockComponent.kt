package ru.kest.traffic.component

import kotlinx.html.div
import react.ReactComponentNoState
import react.ReactComponentSpec
import react.dom.ReactDOMBuilder
import react.dom.ReactDOMComponent
import ru.kest.traffic.ROAD_MAP
import ru.kest.traffic.entity.StreetBlock
import ru.kest.traffic.entity.StreetBlockType.EMPTY
import ru.kest.traffic.entity.StreetBlockType.UP

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
        val blockTypeClass = classByBlockType(props)
        div(classes = "street-block street $blockTypeClass") {
            + ROAD_MAP[props.x][props.y].toString()
/*            if (props.type != EMPTY) {
                div("road-block-roadside")
                div("road-block-line")
            }*/
        }
    }

    private fun classByBlockType(block : StreetBlock) : String {
        if (block.type == UP) {
            if (block.leftNeighbor == EMPTY) {
                return "road-block"
            } else if (block.rightNeighbor == EMPTY) {
                return "road-block road-block-rotate-180"
            }
        }
        return ""
    }

}