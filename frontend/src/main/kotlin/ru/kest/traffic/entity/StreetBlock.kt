package ru.kest.traffic.entity

import react.RProps

/**
 * Represents block of road environment (road, roadside territory)
 *
 * Created by KKharitonov on 16.06.2017.
 */
class StreetBlock(map: RoadMap, x: Int, y: Int) : RProps() {

    val type : StreetBlockType = map.getRoadType(x, y)

    val topNeighbor : StreetBlockType = map.getRoadType(x, y - 1)
    val bottomNeighbor : StreetBlockType = map.getRoadType(x, y + 1)
    val rightNeighbor : StreetBlockType = map.getRoadType(x + 1, y)
    val leftNeighbor : StreetBlockType = map.getRoadType(x - 1, y)


}