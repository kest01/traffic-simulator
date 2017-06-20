package ru.kest.traffic.entity

import ru.kest.traffic.road.RoadMap

/**
 * Represents block of road environment (road, roadside territory)
 *
 * Created by KKharitonov on 16.06.2017.
 */
class StreetBlock(val map: RoadMap, val x: Int, val y: Int) {

    val type : StreetBlockType = map.getRoadType(x, y)

    val topNeighbor : StreetBlockType = map.getRoadType(x, y - 1)
    val bottomNeighbor : StreetBlockType = map.getRoadType(x, y + 1)
    val rightNeighbor : StreetBlockType = map.getRoadType(x + 1, y)
    val leftNeighbor : StreetBlockType = map.getRoadType(x - 1, y)

    fun isTopNeighborsEmpty() : Boolean = isAllEmpty(Pair(x - 1, y - 1), Pair(x, y - 1), Pair(x + 1, y - 1))
    fun isBottomNeighborsEmpty() : Boolean = isAllEmpty(Pair(x - 1, y + 1), Pair(x, y + 1), Pair(x + 1, y + 1))
    fun isLeftNeighborsEmpty() : Boolean = isAllEmpty(Pair(x - 1, y - 1), Pair(x - 1, y), Pair(x - 1, y + 1))
    fun isRightNeighborsEmpty() : Boolean = isAllEmpty(Pair(x + 1, y - 1), Pair(x + 1, y), Pair(x + 1, y + 1))

    private fun isAllEmpty(vararg coords: Pair<Int, Int>) : Boolean {
        for (coord in coords) {
            if (map.getRoadType(coord.first, coord.second) != StreetBlockType.EMPTY) {
                return false
            }
        }
        return true
    }

}