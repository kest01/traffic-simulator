package ru.kest.traffic.entity

import react.RProps
import ru.kest.traffic.ROAD_MAP

/**
 * Represents block of road environment (road, roadside territory)
 *
 * Created by KKharitonov on 16.06.2017.
 */
class StreetBlock(val x : Int, val y : Int) : RProps() {

    val type = getStreetBlockTypeByChar(ROAD_MAP[x][y])



}