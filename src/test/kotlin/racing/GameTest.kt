package racing

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeInRange

class GameTest : FunSpec({
    // given
    val carNumberInput = 3
    val turnNumberInput = 4
    val game = Game()
    context("run() 단위테스트") {
        test("3대, 4턴에 대해 run 실행 시 carList크기는 3, 모든 Car의 currentLocation은 0~4 사이의 수를 가진다") {
            // when
            game.run(carNumberInput, turnNumberInput)
            // then
            game.carList shouldHaveSize 3

            game.carList.forAll {
                it.currentLocation shouldBeInRange (0..4)
            }
        }
    }
    context("clearResult() 단위테스트") {
        test("run 실행 이후 clearResult 실행 시 carList는 비어있어야 한다") {
            game.carList shouldHaveSize 3
            // when
            game.clearCarList()
            // then
            game.carList shouldHaveSize 0
        }
    }
})
