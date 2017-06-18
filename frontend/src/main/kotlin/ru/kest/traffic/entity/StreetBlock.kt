package ru.kest.traffic.entity

import react.RProps
import ru.kest.traffic.MAP_WEIGHT
import ru.kest.traffic.ROAD_MAP

/**
 * Represents block of road environment (road, roadside territory)
 *
 * Created by KKharitonov on 16.06.2017.
 */
class StreetBlock(val x : Int, val y : Int) : RProps() {

    val type : StreetBlockType = getStreetBlockTypeByChar(ROAD_MAP[x][y])

    val topNeighbor : StreetBlockType = calcNeighbor(x - 1, y)
    val bottomNeighbor : StreetBlockType = calcNeighbor(x + 1, y)
    val rightNeighbor : StreetBlockType = calcNeighbor(x, y + 1)
    val leftNeighbor : StreetBlockType = calcNeighbor(x, y - 1)


    private fun calcNeighbor(neighborX: Int, neighborY: Int) : StreetBlockType {
        if ((neighborX < 0 || neighborX >= MAP_WEIGHT)
                || (neighborY < 0 || neighborY >= MAP_WEIGHT)) {
            return StreetBlockType.EMPTY
        }
        return getStreetBlockTypeByChar(ROAD_MAP[neighborX][neighborY])
    }

}