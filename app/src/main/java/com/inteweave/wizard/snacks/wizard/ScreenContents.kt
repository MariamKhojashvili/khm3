package com.inteweave.wizard.snacks.wizard

import android.content.Context
import androidx.annotation.StringRes

/**
 * For our simple wizard, we use a single fragment and set the contents
 * for the specific screen.
 *
 * This defines the contents of the screen
 *
 * @author W M Milward
 * Copyright © 2019 Inteweave. All rights reserved.
 */
class ScreenContents(
    context: Context,
    @StringRes labelId: Int,
    @StringRes button1Id: Int,
    @StringRes button2Id: Int,
    val button1Event: SnacksEvent,
    val button2Event: SnacksEvent,
    val button2Hidden: Boolean
) {
    val label: String = context.getString(labelId)
    val button1Title: String = context.getString(button1Id)
    val button2Title: String = context.getString(button2Id)
}
