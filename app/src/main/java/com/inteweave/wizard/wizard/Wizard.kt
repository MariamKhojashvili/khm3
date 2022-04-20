package com.inteweave.wizard.wizard

/**
 * The wizard class is the engine that drives the navigation
 * Given the screen navigation and the events it determines the identifier for the
 * next screen
 *
 * @param ScreenIdentifier The type of the screen identifier; normally an enum
 * @param WizardEvent The type of the event raised; normally an enum
 *
 * @author W M Milward
 * Copyright © 2019 Inteweave. All rights reserved.
 */
class Wizard<ScreenIdentifier, WizardEvent>(
    private val screenNavigation: List<ScreenNavigation<ScreenIdentifier, WizardEvent>>,
    val startScreen: ScreenIdentifier
) {
    /**
     * An event was raised on the current screen
     *
     * @param event The event that occurred on the current screen
     * @return The [ScreenIdentifier] for the event
     */
    fun onEvent(event: WizardEvent, currentScreen: ScreenIdentifier): ScreenIdentifier {
        val navigation = screenNavigation.filter { it.event == event && it.onScreen == currentScreen }
        when (navigation.size) {
            1 -> return navigation[0].navigateTo
            0 -> throw WizardError("No event found for screen $currentScreen")
            else -> throw WizardError("Multiple definitions for screen $currentScreen")
        }
    }
}
