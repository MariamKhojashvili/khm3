package com.inteweave.wizard.snacks.wizard

import android.os.Parcel
import android.os.Parcelable

/**
 * An enum defining the screens to show.
 * Parcelable so that we can pass to the fragment
 *
 * @author W M Milward
 * Copyright © 2019 Inteweave. All rights reserved.
 */
enum class SnacksScreen : Parcelable {
    SELECT_TYPE,
    ICE_CREAM_SERVE,
    SCOOP,
    CHOOSE_TOPPING,
    SOFT_SERVE_CHOC_DIP,
    SOFT_SERVE_SPRINKLES,
    NUTS;

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SnacksScreen> {
        override fun createFromParcel(parcel: Parcel): SnacksScreen {
            return valueOf(parcel.readString()!!)
        }

        override fun newArray(size: Int): Array<SnacksScreen?> {
            return arrayOfNulls(size)
        }
    }
}
