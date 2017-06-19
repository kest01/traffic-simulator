package ru.kest.traffic.entity

/**
 * Represent map of environment
 *
 * Created by KKharitonov on 19.06.2017.
 */
class RoadMap {

//arrayOf('⬆','⬇','⬅','⮕','⬈','⬊','⬉','⬋'),
    private val ROAD_MAP = arrayOf(
            arrayOf(' ','⬈','⮕','⮕','⮕','⮕','⮕','⮕','⬊',' '),
            arrayOf('⬈','⬈','⮕','⮕','⮕','⮕','⮕','⮕','⬊','⬊'),
            arrayOf('⬆','⬆', ' ', ' ', ' ', ' ',' ', ' ', '⬇','⬇'),
            arrayOf('⬆','⬆',' ' , ' ', ' ', ' ',' ', ' ', '⬇','⬇'),
            arrayOf('⬆','⬆',' ' , ' ', ' ', ' ',' ', ' ', '⬇','⬇'),
            arrayOf('⬆','⬆',' ' , ' ', ' ', ' ',' ', ' ', '⬇','⬇'),
            arrayOf('⬆','⬆',' ' , ' ', ' ', ' ',' ', ' ', '⬇','⬇'),
            arrayOf('⬆','⬆',' ' , ' ', ' ', ' ',' ', ' ', '⬇','⬇'),
            arrayOf('⬉','⬉','⬅','⬅','⬅','⬅','⬅','⬅','⬋','⬋'),
            arrayOf(' ','⬉','⬅','⬅','⬅','⬅','⬅','⬅','⬋',' ')
    )

    val xSize = ROAD_MAP[0].size
    val ySize = ROAD_MAP.size


    fun getRoadType(x: Int, y: Int) : StreetBlockType {
        if (isCoordinateOutOfBound(x, y)) {
            return StreetBlockType.EMPTY
        }
        return getStreetBlockTypeByChar(ROAD_MAP[y][x])
    }

    private fun isCoordinateOutOfBound(x: Int, y: Int) =
            (y < 0 || y >= ROAD_MAP.size) || (x < 0 || x >= ROAD_MAP[y].size)


}