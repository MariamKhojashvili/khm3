package com.inteweave.wizard.snacks.wizard

import androidx.lifecycle.ViewModel
import com.inteweave.wizard.wizard.ScreenNavigation
import com.inteweave.wizard.wizard.Wizard

/**
 * The view model contains the definition of the wizard
 *
 * @author W M Milward
 * Copyright © 2019 Inteweave. All rights reserved.
 */
class SnacksViewModel : ViewModel() {
    private val screenNavigation = listOf(
        // from screen, on event, navigate to screen
        ScreenNavigation(SnacksScreen.SELECT_TYPE, SnacksEvent.ICE_CREAM_CHOSEN, SnacksScreen.ICE_CREAM_SERVE),

        ScreenNavigation(SnacksScreen.ICE_CREAM_SERVE, SnacksEvent.SOFT_SERVE_CHOSEN, SnacksScreen.CHOOSE_TOPPING),
        ScreenNavigation(SnacksScreen.ICE_CREAM_SERVE, SnacksEvent.SCOOP_CHOSEN, SnacksScreen.SCOOP),

        ScreenNavigation(SnacksScreen.CHOOSE_TOPPING, SnacksEvent.CHOC_DIP_CHOSEN, SnacksScreen.SOFT_SERVE_CHOC_DIP),
        ScreenNavigation(SnacksScreen.CHOOSE_TOPPING, SnacksEvent.SPRINKLES_CHOSEN, SnacksScreen.SOFT_SERVE_SPRINKLES),

        ScreenNavigation(SnacksScreen.SELECT_TYPE, SnacksEvent.NUTS_CHOSEN, SnacksScreen.NUTS)
    )

    val wizard = Wizard(screenNavigation, SnacksScreen.SELECT_TYPE)
}
