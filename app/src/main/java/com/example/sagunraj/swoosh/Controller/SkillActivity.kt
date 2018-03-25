package com.example.sagunraj.swoosh.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sagunraj.swoosh.Model.Player
import com.example.sagunraj.swoosh.R
import com.example.sagunraj.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {

    lateinit var player: Player // we're initializing the variable later

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun onSkillFinishClicked(view:View) {
        if (player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        }

        else{
            Toast.makeText(this, "Please select a skill level.", Toast.LENGTH_SHORT).show()
        }
    }

    fun onBallerClicked(view: View){
        if(player.skill == "baller"){
            player.skill = ""
        }
        else {
            beginnerSkillBtn.isChecked = false
            player.skill = "baller"
        }
    }

    fun onBeginnerClicked(view: View) {
        if (player.skill == "beginner") {
            player.skill = ""
        } else {
            ballerSkillBtn.isChecked = false
            player.skill = "beginner"
        }
    }
}
