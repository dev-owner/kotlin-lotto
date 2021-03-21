package lotto

import lotto.domain.LottoCompany
import lotto.domain.LottoStore
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val money = InputView.inputPrice()

    val manualLottos = InputView.inputManualLotto(money)

    val lottos = LottoStore().buy(money, manualLottos)
    OutputView.showPurchaseStatus(lottos)

    val winnerLottoNumber = InputView.inputWinnerNumber()
    val comp = LottoCompany()
    val bonusNumber = InputView.inputBonusNumber()
    comp.setWinnerNumber(winnerLottoNumber, bonusNumber)

    val winners = comp.findWinners(lottos)
    OutputView.showWinningStatus(winners)

    val earningRate = comp.calculateEarningRate(winners, money)
    OutputView.showEarningRatio(earningRate)
}
