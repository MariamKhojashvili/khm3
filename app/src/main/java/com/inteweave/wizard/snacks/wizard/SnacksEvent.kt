package com.inteweave.wizard.snacks.wizard

/**
 * Each screen can raise events and the event defines the next screen to show
 *
 * @author W M Milward
 * Copyright © 2019 Inteweave. All rights reserved.
 */
enum class SnacksEvent {
    FINISH, // common to multiple screens
    ICE_CREAM_CHOSEN,
    SCOOP_CHOSEN,
    SOFT_SERVE_CHOSEN,
    CHOC_DIP_CHOSEN,
    SPRINKLES_CHOSEN,
    NUTS_CHOSEN
}
