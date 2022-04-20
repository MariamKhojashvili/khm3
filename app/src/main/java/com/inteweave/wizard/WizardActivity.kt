package com.inteweave.wizard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.inteweave.wizard.snacks.wizard.SnacksEvent
import com.inteweave.wizard.snacks.wizard.SnacksScreen
import com.inteweave.wizard.snacks.wizard.SnacksViewModel
import com.inteweave.wizard.ui.wizard.HomeFragment
import com.inteweave.wizard.ui.wizard.SnacksFragment
import com.inteweave.wizard.ui.wizard.SnacksFragmentPresenter

/**
 * Main activity is responsible for displaying the fragments of the wizard.
 * The view model contains the definition of the wizard
 *
 * @author W M Milward
 * Copyright © 2019 Inteweave. All rights reserved.
 */
class WizardActivity : AppCompatActivity(),
    SnacksFragmentPresenter.EventListener,
    HomeFragment.Listener {

    private lateinit var model: SnacksViewModel

    /**
     * Create or attach the the view model and instantiate the home fragment
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wizard_host_activity)
        model = ViewModelProviders.of(this)[SnacksViewModel::class.java]
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commitNow()
        }
    }

    /**
     * Perhaps in a production app the event would be handled by the View Model, which is
     * really the wizard controller.
     * I would also expect to see factory methods to create the fragment to display.
     */
    override fun onSnacksEvent(event: SnacksEvent, currentScreen: SnacksScreen) {
        if (event == SnacksEvent.FINISH) {
            supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        } else {
            val screen = model.wizard.onEvent(event, currentScreen)
            showScreen(SnacksFragment.newInstance(screen))
        }
    }

    /**
     * The user has selected to start the wizard. Show the initial screen.
     */
    override fun onStartWizard() {
        showScreen(SnacksFragment.newInstance(model.wizard.startScreen))
    }

    /**
     * Show a new wizard fragment with animation. A standard sliding animation is used
     * to indicate forward or back navigation.
     */
    private fun showScreen(fragment: Fragment) {
        supportFragmentManager.beginTransaction().setCustomAnimations(
            R.anim.slide_in_right,
            R.anim.slide_out_left,
            R.anim.slide_in_left,
            R.anim.slide_out_right
        )
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
