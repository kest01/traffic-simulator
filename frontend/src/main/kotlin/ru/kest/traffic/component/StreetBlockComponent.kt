package ru.kest.traffic.component

import kotlinx.html.div
import react.*
import react.dom.ReactDOMBuilder
import react.dom.ReactDOMComponent
import ru.kest.traffic.entity.StreetBlock
import ru.kest.traffic.entity.StreetBlockType.*

/**
 * React Component that represents block of road environment (road, roadside territory)
 *
 * Created by KKharitonov on 16.06.2017.
 */
class StreetBlockComponent : ReactDOMComponent<StreetBlockComponent.StreetBlockProps, ReactComponentNoState>() {
    companion object : ReactComponentSpec<StreetBlockComponent, StreetBlockProps, ReactComponentNoState>

    init {
        state = ReactComponentNoState()
    }

    override fun ReactDOMBuilder.render() {
        val blockTypeClass = classByBlockType(props.block)
        div(classes = "street-block street $blockTypeClass") {
//            + ROAD_MAP[props.x][props.y].toString()
/*            if (props != EMPTY) {
                div("road-block-roadside")
                div("road-block-line")
            }*/
        }
    }

    private fun classByBlockType(block : StreetBlock) : String {
        if (block.type == EMPTY) {
            if (block.topNeighbor == UPLEFT && block.rightNeighbor == UPLEFT) {
                return "road-block-angle-up-left"
            } else if (block.bottomNeighbor == UPRIGHT && block.rightNeighbor == UPRIGHT) {
                return "road-block-angle-up-right"
            } else if (block.bottomNeighbor == DOWNRIGHT && block.leftNeighbor == DOWNRIGHT) {
                return "road-block-angle-down-right"
            } else if (block.topNeighbor == DOWNLEFT && block.leftNeighbor == DOWNLEFT) {
                return "road-block-angle-down-left"
            }
            return ""
        }
        val classes = mutableListOf<String>("road-block")

        if (block.type == UP) {
            if (block.leftNeighbor == EMPTY) {
                classes.add("road-block-wayside-left")
            }
            if (block.rightNeighbor == EMPTY) {
                classes.add("road-block-wayside-right")
            } else if (block.leftNeighbor == EMPTY) {
                classes.add("road-block-line-right")
            }
        } else if (block.type == DOWN) {
            if (block.rightNeighbor == EMPTY) {
                classes.add("road-block-wayside-right")
            }
            if (block.leftNeighbor == EMPTY) {
                classes.add("road-block-wayside-left")
            } else if (block.rightNeighbor == EMPTY) {
                classes.add("road-block-line-left")
            }
        } else if (block.type == RIGHT) {
            if (block.topNeighbor == EMPTY) {
                classes.add("road-block-wayside-top")
            }
            if (block.bottomNeighbor == EMPTY) {
                classes.add("road-block-wayside-bottom")
            } else if (block.topNeighbor == EMPTY) {
                classes.add("road-block-line-bottom")
            }
        } else if (block.type == LEFT) {
            if (block.bottomNeighbor == EMPTY) {
                classes.add("road-block-wayside-bottom")
            }
            if (block.topNeighbor == EMPTY) {
                classes.add("road-block-wayside-top")
            } else if (block.bottomNeighbor == EMPTY) {
                classes.add("road-block-line-top")
            }
        } else if (block.type == UPLEFT || block.type == UPRIGHT || block.type == DOWNLEFT || block.type == DOWNRIGHT) {
            if (block.isTopNeighborsEmpty) {
                classes.add("road-block-wayside-top")
            } else if (block.isBottomNeighborsEmpty) {
                classes.add("road-block-wayside-bottom")
            } else if (block.isLeftNeighborsEmpty) {
                classes.add("road-block-wayside-left")
            } else if (block.isRightNeighborsEmpty(false)) {
                classes.add("road-block-wayside-right")
            }
        }
        return classes.joinToString(separator = " ")
    }

    class StreetBlockProps(val block : StreetBlock) : RProps()
}